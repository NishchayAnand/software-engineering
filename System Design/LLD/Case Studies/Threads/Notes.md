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

- **Create Threads (ThreadService):** Users can compose a new `text-based` post.

- **Live Feed (NewsFeedService):** Users receive a continuous stream of fresh content in their feed.

- **Get Notifications (NotificationService):** Users receive notifications about `activities` (interactions) such as `new posts`.

## Use Case Diagram

- `User` sends a `createThread` request to the **server**. The server receives the **POST Request** with the `Thread` data and stores it in the **database**. The `followers` of the `User` receive `Notification` and see new `Thread` in their `Feed`.

- **Fanout on write** or **Fanout on read** ??

- When `User` navigates to the `Feed`, a `getFeed` request is sent to the **server**. The server receives the **GET Request** and queries the **database** for recent posts and activities relevant to the user. The `Feed` compiles the data, sorts it by recency or relevance, and sends it back to the client.

## Class Diagram

- `User(-userId: int, -username: string, -email: string, -password: string, -friends: List<User>)`:

- `Thread(-threadId: int, -content: string, userId: int)`:

- `ThreadService(-ThreadRepository, +saveThread(Thread):boolean)`:

- `FeedService`:

- `NotificationService`:

## Sequence Diagram

- When a user **signs up** for the first time, servers collect the `User` info and stores it in the `User database`.

- The `User` sends a **POST request** to the `ThreadService` to publish a new `Thread` to the `Post database`.

- `FeedService` fetches `User` `friends` list from the `User Database` and sends it to the **message queue**.

- `NotificationService` pull notification events from message queue an send them to the corresponding users.

- The fully hydrated ``Feed` is returned in JSON format back to the client for rendering.

## EXTRA

Cache is extremely important for a news feed system.
