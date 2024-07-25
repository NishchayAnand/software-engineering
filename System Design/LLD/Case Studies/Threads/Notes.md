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

## MVP Requirements

1. **Create Threads (Posts):** Users compose a new post, including text, images, or other media. The post is submitted to the server and stored in the database.

2. **Like / Comment / Share:** Users can like posts, add comments and share posts to their feed or in direct messages with others.

3. **Live Feed:** Users receive a continuous stream of fresh content in their feed.

4. **Get Notifications**: Users receive notifications about interactions (activities) such as new posts, `likes`, `comments`, `shares`.
