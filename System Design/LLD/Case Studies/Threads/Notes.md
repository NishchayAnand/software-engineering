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

- **Create Threads:** Users can compose a new `text-based` post.

- **Live Feed:** Users receive a continuous stream of fresh content in their feed.

- **Get Notifications:** Users receive notifications about `activities` (interactions) such as `new posts`.

## Use Case Diagram

- `User` sends a `createThread` request to the **server**. The server receives the **POST Request** with the `Thread` data and stores it in the **database**. The `followers` of the `User` receive `Notification` and see new `Thread` in their `Feed`.

- When `User` navigates to the `Feed`, a `getFeed` request is sent to the **server**. The server receives the **GET Request** and queries the **database** for recent posts and activities relevant to the user. The `Feed` compiles the data, sorts it by recency or relevance, and sends it back to the client.

## Class Diagram

- `User(-userId, -username, -email, -password)`:

- `ThreadService(-ThreadRepository, +saveThread(Thread):boolean)`:

- `Thread(threadId, content, userId)`:

## Sequence Diagram
