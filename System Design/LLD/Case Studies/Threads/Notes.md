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

- **Live Feed (`NewsFeedService`):**
  - Users can publish text-based posts.
  - Users recieve a continuous stream of fresh content in their feed **(Fanout on Write - Push Model)**.

## Use Case Diagram

- `User` sends a **POST request** to the `ThreadService` to publish a new `Thread` in the database. The `FeedService` executes `User.getFollowers()` to fetch the list of followers who should see the new `Thread`.

## Class Diagram

**Components:**

- `User(-userId: int, -username: string, -email: string, -password: string, -followers: List<User>)`:

- `Thread(-threadId: int, -content: string, userId: int)`:

- `ThreadService(-ThreadRepository, +saveThread(Thread):boolean)`:

- `FeedService`:

**Relationships:**

## EXTRA

- When a user **signs up** for the first time, the servers collect the `User` info and stores it in the **user database**.

- **Get Notifications (`NotificationService`)**: Users receive notifications about activities (interactions) such as new posts.

- Cache is extremely important for a **news feed service**.
