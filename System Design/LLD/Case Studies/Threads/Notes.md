# Threads Low-Level System Design

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

- `User(-userId: int, -username: string, -email: string, -password: string, -followers: List<User>)`:

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
