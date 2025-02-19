# Movie Ticket Booking System

Design a web application like **BookMyShow** that allows users to book movie tickets online.

---
## Functional Requirements

1. **User Registration and Login:** Allow users to create an account to authenticate themselves and access the platform's services.

2. **Movie Listings:** Display the list of currently running movies along with details like genre, release date, duration, rating, etc.

3. **Show Selection:** Display all available shows of the selected movie based on the preferred date and location.

4. **Seat Selection:** Show a seat map for the selected show allowing users to choose their preferred seats.

5. **Pricing:** Calculate the total amount for the selected seats based on factors like seat type.

6. **Payment:** Integrate third-party payment gateways to allow secure transactions via credit/debit cards, digital wallets, or net banking.

7. **Notification:** Send a booking confirmation via email or SMS.

---
## Non-Functional Requirements

1. **Consistency:** Ensure **strong consistency** for seat reservations to prevent double bookings, even if it means the system takes a few seconds to process reservations.

2. **Scalability:** Should scale horizontally to support growing user traffic, especially during peak times (e.g., movie premieres).

3. **Partition Tolerance:** Should **not lose booking data** even if some nodes (individual servers, databases, or microservices) become unreachable.

> **NOTE:** If network partitions occur, the system might **sacrifice Availability, i.e., deny some requests** rather than allow inconsistent seat bookings.

---

