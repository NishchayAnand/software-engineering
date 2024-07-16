# Understanding Facebook Low Level Design

## Use Cases

The **“Send friend request”** use case also has an include relationship with the “Send new friend request notification,” because whenever a user receives a friend request, the user is notified.

The **“Send message”** use case has an include relationship with the “Send message notification” use case, because whenever a user receives a message, the user is notified.

The **“Add post”** use case has an include relationship with the “Send new post notification” use case. Whenever a new post is created by a user being followed by the default user, the default user is notified.

The **“Add comment”** use case has an include relationship with the “Send new comment notification” use case. Whenever a new comment is made by another user on a post either created by the default user or followed by the default user, the default user is notified.
