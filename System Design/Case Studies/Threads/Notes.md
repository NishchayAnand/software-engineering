# Threads System Design

Threads is a social media platform. Key features **(services)** provided by Threads include:

- **Create Threads (Posts)** to share your ideas, opinions and creativity with the world.

- **Follow / Unfollow** friends and people who care about whatever it is you're interested in.

- **Like / Comment / Share** other people's posts.

- **Get Notifications** about relevant activities and interactions related to user's account and posts.

- **Live Feed** to efficiently delivering new posts to user's feed.

- **Authorize** who can see your content, reply to your threads, or mention you.

- **Direct Messaging** to have private, real-time communication with other users.

- **Create Communities** to foster engagement and interaction around users with shared interests, topics, or activities.

- **Search** posts, users, and other content.

## Functional Requirements

- **Create Thread (`PostService`)**: Users can publish text-based posts.

- **Follow / Unfollow People (`FollowService`)**: Users can follow new people or unfollow existing followees.

- **Live Feed (`NewsFeedService`):** Users can request a stream of fresh content in their feed **(Fanout on Read - Pull Model)**.

- `Thread - Chat Service`, `Feed - News Feed Service (Fanout)`, `Notification Service`

## Non-Functional Requirements

- **Eventual Consistency:** All users should eventually see the the updated set of posts, even though there may be temporary discrepancies.

- **Low Latency:** Crucial for providing a responsive and seamless user experience, particularly for real-time interactions like posting threads and notifications.

- **High Availability:** Feed should be accessible and functional even during network partitions or node failures. This is critical for maintaining user engagement and trust, especially in a social media platform where users expect continuous access.

## News Feed Service

News feed is the constantly updating list of stories in the middlee of your home page. For example, a user can publish a post and see her friend's posts on the news feed page.

The design is divided into 2 flows:

1. **Feed Publishing**: When a user publishes a post, corresponding data is written into cache and database. The post is populated to her friend's news feed.

2. **News Feed Buidling:** For simplicity, let us assume the news feed is built by aggregating friends' post in reverse chronological order (the order in which they were posted).

The news feed APIs are the primary ways for clients to communicate with servers. Those APIs are **HTTP** based that allows clients to perform actions such as post a message, retrieve news feed, etc.

Two most important APIs: `Feed Publishing API` **(Thread Service)** and `News Feed Retrieval API` **(Feed Service)**.

## Query Per Second (QPS)

It's a metric used to measure the rate at which a system can handle requests. Essentially, it tells you how many queries a system can process in one second.

- **Monthly Active Users (MAU)**: 300 million (30 CR) monthly active users.
- **Daily Active Users (DAU)**: 50% (15 CR) use Threads daily.
- **Average Posts Per User Per Day**: Users post (queries) 2 threads per day on average.

- `Total Daily Posts`: (15 CR)\*2 = 30 CR.
- `Total Seconds in a Day`: (24\*60\*60) = 86400 seconds
- `Query per second`: 30 CR /86400 ~ 3500

## Storage Requirements

- **Daily Media Content**: 10% of Threads (3 CR) contain media (average size 1 MB).
- **Data Retention Period**: Data is stored for 5 years.

- `Daily Media Content Size`: (3 CR)\*(1 MB) = 30 TB per day.
- `5 Year Storage`: (30 TB)\*(365)\*(5) ~ 55 PB.


## DB Schema Modeling

- `User(userId, name, email)`

- `post(postId, userId, imageId, caption)`

- `image(imageId, imageUrl)`

- `follow(follower, followee)`: followee is the person who is being followed by another user.

## Use Case Diagram (Design API structure)

Understand what services we need to incorporate in our design to fulfill our requirement.

- `User` sends a **POST request** to the `PostService` to publish a new `Thread` in the database.

- `User` sends a **POST request** to the `FollowService` to add a new followee for the user. The `followDAO` will add a new (userId, followeeId) row in the `follow` table.

- `User` sends a **GET request** to the `FeedService` to fetch latest `Thread` posted by its **followees**.

- `FeedService` -> followees = `FollowService`.getUsersFollowerBy(`User`) -> posts = forEach(followee -> `PostService`.getPostsByUser(`User`))

- `FollowService` will answer 2 important questions:
  1. list of people who are following me.
  2. list of people who I'm following.

## Class Diagram

**Components:**

- `User(-userId: int, -username: string, -email: string)`:

- `Thread(-threadId: int, -content: string, userId: int)`:

- `ThreadService(-ThreadRepository, +saveThread(Thread):boolean)`:

- `FeedService`:

**Relationships:**

## Sample Code

## Optimizations

1. Add another functionality PostService.getPostsByUsers({`User`, `User`, `User`}) to avoid querying posts for each followee separately.

2. Limit post fetched from the database to 20.

3. Use `fanout on Write` to pre-compute the user feed. When a post is saved in the database, the `PostService` should send a notification to the `FeedService` to get followers = getFollowers(`User`) and then forEach(follower -> FeedService.addPost(`Post`))

## EXTRA

- When a user **signs up** for the first time, the servers collect the `User` info and stores it in the **user database**.

- **Get Notifications (`NotificationService`)**: Users receive notifications about activities (interactions) such as new posts.

- Cache is extremely important for a **news feed service**.

- `FollowService` will answer 2 important questions:

  1. list of people who are following me.
  2. list of people who I'm following.

- ImageService(imageId, url) -> Distributed File System (DFS)

## Links

- https://www.youtube.com/watch?v=QmX2NPkJTKg&t=200s
