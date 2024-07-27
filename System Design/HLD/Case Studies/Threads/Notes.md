# Threads High-Level System Design

- `Thread - Chat Service`, `Feed - News Feed Service`, `Notification Service`

## Non-Functional Requirements

- **Eventual Consistency:** All users should eventually see the the updated set of posts, even though there may be temporary discrepancies.

- **Low Latency:** Crucial for providing a responsive and seamless user experience, particularly for real-time interactions like posting threads and notifications.

- **High Availability:** Feed should be accessible and functional even during network partitions or node failures. This is critical for maintaining user engagement and trust, especially in a social media platform where users expect continuous access.
