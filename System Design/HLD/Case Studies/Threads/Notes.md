# Threads High-Level System Design

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
