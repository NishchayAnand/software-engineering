**Seat Selection:** Show a seat map for the selected show allowing users to choose their preferred seats (with real-time availability updates).

## Non-Functional Requirements

1. **High Concurrency**: At peak times, for example, on the release day, multiple customer may try to book the same ticket. 

2. **Moderate Latency:** It's ideal to have a fast response time when a user makes a reservation, but it's okay if the system takes a few seconds to process the reservation requests.

---
## Workflow for Booking a Ticket

1. The **customer** selects his/her preferred **location**. A **GET request** is sent to fetch the list of **movies** currently running in the **theatres** near the preferred **location**.

2. The **customer** selects a **movie** and his/her preferred **date**. A **GET request** is sent to fetch the list of available **shows** for the selected **movie** on the preferred **date**.

3. The **customer** selects a **show**. A **GET request** is sent to fetch the lists of available **seats** for the selected **show**. 

4. The **customer** selects his/her preferred **seats**. A **POST request** is sent to book the selected **seats**.

---
## System Architecture

- **User Service:** Manages user (customer) authentication and profile.

- **Movie Service:** Manages movie listings and shows.

- **Theatre Service:** Handles theatres, screens and seat layouts.

- **Booking Service:** Handles seat reservation and ticket confirmation.

- **Payment Service:** Integrates with payment gateways (Stripe, PayPal, Razorpay).

- **Notification Service:** Sends email/SMS confirmations.

---
## User Service

---
## Theatre Service

---


1. **Handle Concurrency:** The `MovieService.bookSeats(customer, show, seats)` functionality can leverage database transactions and locking mechanisms (e.g. pessimistic locking) to ensure data consistency when multiple customers attempt to book the same seats simultaneously.

2. **Maintain Data Integrity:** We cannot have two shows running on a screen in a theatre at same time. You use a **trigger** at the database level to catch overlapping shows for ultimate data integrity (guarantees integrity no matter the source of data insertion). Alternatively, you can implement checks in your service layer or DAO to ensure no overlapping shows are added.

## Services

1. `MovieService`: Provides detailed information on Movies, Theatres, Screens, Shows. Theatres and screens are generally static, so can be easily cached. 

    - **Private Data Members**: `MovieDAO` movieDAO, `ShowDAO` showDAO, `SeatDAO` seatDAO, `PaymentService` paymentService, `NotificationService` notificationService, `BookingDAO` bookingDAO.

    - **Public Member Functions**: 

        - `List<Movie>` getMovies(`Location` location): fetch the list of movies currently showing in the theatres near the preferred location.

        - `List<Show>` getShows(`Movie` movie, `LocalDate` date): fetch the list of available shows for the selected movie on the preferred date.

        - `List<Seat>` getAvailableSeats(`Show` show): fetch the list of available seats for the selected show.

2. `ReservationService`: Receives reservation requests and reserves the movie show. This service also tracks seat inventory as tickets are reserved or bookings are cancelled.

	- **Private Data Members**: `BookingDAO` bookingDAO.

	- **Public Member Functions**: 

        - `Booking` bookSeats(`Customer` customer, `Show` show, `List<Seat>` seats): book the selected seats for the customer in the selected show. 

3. `RateService`

4. `PaymentService`: executes payment from a customer and updates the reservation status to `paid` once the payment transaction succeeds, or `rejected` if the transaction fails.

    - **Public Member Functions**: 

        - `boolean` processPayment(`Customer` customer, `double` amount)

5. `NotificationService`:

    - **Public Member Functions**:

        - notifySeatUnavailable(`Customer` customer, `Seat` seat) 

        - notifyPaymentFailure(`Customer` customer)

        - sendBookingConfirmation(`Customer` customer, `Booking` booking)


## Data Transfer Objects (DTOs)

6. `Customer`:

    - **Private Data Members**: `int` customerId, `String` name, `Location` location, `String` email, `String` phone, `List<Booking>` bookings.

    - **Public Member Functions**: All Getters and Setters.

7. `Location`:

    - **Private Data Members**: `String` street, `String` city, `String` state, `String` country, `String` postalCode.

    - **Public Member Functions**: All Getters and Setters.

8. `Movie`:

    - **Private Data Members**: `int` movieId, `String` title, `String` genre, `String` releaseDate, `int` duration.

    - **Public Member Functions**: All Getters and Setters.

9. `Show`:

    - **Private Data Members**: `int` showId, `Movie` movie, `Theatre` theatre, `Screen` screen, `LocalDateTime` showTime.

    - **Public Member Functions**: All Getters and Setters. 

10. `Screen`:

    - **Private Data Members**: `int` screenId, `String` screenName, `Theatre` theatre.

    - **Public Member Functions**: All Getters and Setters. 

11. `Theatre`:

    - **Private Data Members**: `int` theatreId, `Location` location.

    - **Public Member Functions**: All Getters and Setters.

12. `Seat`:

    - **Private Data Members**: int `seatId`, `String` seatNumber, `SeatType` seatType, `boolean` isBooked. 

    - **Public Member Functions**: All Getters and Setters.

> NOTE: Seat numbers are assigned when a customer books a ticket. 

13. `Booking`:

    - **Private Data Members**: `int` bookingId, `Customer` customer, `Show` show, `List<Seat>` bookedSeats, `double` totalAmount, `BookingStatus` status.

    - **Public Member Functions**: All Getters and Setters.

**NOTE:**

- Do not include `Show` directly in the `Seat` class. Instead, use a `Booking` class to manage the relationship between Seats and Shows.

## Enums

14. `SeatType`: NORMAL(price: 250), PREMIUM(price: 400), VIP(price: 550).

15. `BookingStatus`: CONFIRMED, CANCELED.

## Data Access Objects (DAOs)

16. `MovieDAO`:

    - **Public Member Functions**:

        - `List<Movie>` getMoviesByLocation(`String` city, `String` state): SELECT DISTINCT m.movieId, m.title, m.genre, m.releaseDate, m.duration FROM movie m JOIN show s ON m.movieId = s.movieId JOIN theatre t ON s.theatreId = t.theatreId WHERE t.city = ? and t.state = ?.

        - `Movie` getMovieById(`int` movieId): SELECT * FROM movie WHERE movieId = ?.

17. `ShowDAO`:

    - **Private Data Members**: `MovieDAO` movieDAO, `ScreenDAO` screenDAO. 

    - **Public Member Functions**:

        - `List<Show>` getShowsByMovieIdAndDate(int movieId, LocalDate date): SELECT * FROM show WHERE movieId = ? and showTime = ?.

18. `ScreenDAO`:

    - **Public Member Functions**:

        - `Screen` getScreenById(`int` screenId): SELECT * FROM screen WHERE screenId = ?.

19. `SeatDAO`:

    - **Public Member Functions**:

        - `List<Seat>` getSeatsByShowId(`int` showId): SELECT * FROM seat WHERE showId = ?.

        - `boolean` updateSeatBookingStatus(`int` seatId, `boolean` isBooked): UPDATE seat SET isBooked = ? WHERE seatId = ?.

20. `BookingDAO`:

    - **Public Member Functions**: 

        - addBooking(`Booking` booking): INSERT INTO booking (bookingId, customerId, showId, amount, status) VALUES (?,?,?,?,?).
        
## Entities (Database Schema)

21. `customer`: `int` customerId, `varchar` name, `varchar` city, `varchar` state, `varchar` country, `varchar` email, `varchar` phone.

22. `movie`: `int` movieId, `varchar` title, `varchar` genre, `date` releaseDate, `int` duration.

23. `show`: `int` showId, `int` movieId, `int` theatreId, `int` screenId, `date` showTime.

24. `theatre`: `int` theatreId, `varchar` street, `varchar` city, `varchar` state, `varchar` country, `varchar` postalCode.

25. `screen`: `int` screenId, `varchar` screenName, `int` theatreId. 

26. `seat`: `int` seatId, `varchar` seatNumber, `varchar` seatType, `int` showId, `boolean` isBooked.

27. `booking`: `int` bookingId, `int` customerId, `int` showId, `int` totalAmount, `varchar` status.

**Constraints:**

- When a theatre is removed from the `theatre` table, all the screens belonging to that theatre should also be removed from the `screen` table.

- When a movie is removed from the `movie` table, all the shows corresponding to that movie should also be removed from the `show` table.

- When a theatre is removed from the `theatre` table, all the shows running in that theatre should also be removed from the `show` table. 


## Best Practices

- Adopting the singleton pattern for service and DAO classes reduces the overhead of creating and managing resources, ensures thread safety, maintains consistency in business logic or database operations, minimizes dependency management complexity, and simplifies the overall code structure.

- Always override `equals()` and `hashCode()` for DTO or entity classes, especially when they are part of collections or when you need logical equality.

- **Error Handling:** 

    - If `MovieRepository` throws `DataAccessException`, wrap it around a customException: `MovieServiceException` and handle it in the `MovieController` class (API layer).

    - If any part of the booking process fails (e.g., payment or seat update), the method throws an exception, ensuring the transaction is rolled back.

- **Logging:** Use the Logger from `SLF4J` with `Logback` to log messages in your application.

## High Level Design Decisions

Q. What is the scale of the system? 

The system caters approx. 1000 theatres (each with approx. 5 screens) and 5000 screens.

---

Q. Do customer's book movie tickets through the website only? Do we need to support other reservations options?

Assume people can book ticket though website or using mobile app. 

---

Q. What should be the average reservation (transaction) per second?

---

Q. Understand QPS of all pages in the system.

There are 3 steps in a typical customer flow:

28. **View Upcoming / Showing Movies Detail Page:** Users browse this page (query).
29. **View Booking Page:** Users can confirm the booking details, such as dates, number of tickets, payment details before booking (query).
30. **Reserve the Tickets:** Users click the "book" button to book the movie tickets and the tickets are reserved (transaction).

Assuming only 10% of the user reach the final and 90% of the user drop before reaching the final step.

31. **QPS of View Upcoming / Showing Movies Detail Page:** 300 QPS
32. **QPS of View Booking Page:** 30 QPS
33. **QPS (TPS) of Reserve the Tickets:** 3 QPS

---

Q. Understand Data Access Patterns.

For a booking movie system, we need to support the following queries:

34. View detailed information about a movie.
35. Find available shows for a given date range.
36. Record a reservation.

The scale of the system is not too large but we need to prepare for traffic surges during big events. 

A relational database works well with read-heavy and write-less frequently workflow. This is because the number of users who visit the website / app is a few orders of magnitude higher than those who actually make the reservations. NoSQL databases are generally optimised for writes and the relational database works well enough for read-heavy workflow.

**IMPORTANT: A relational database provides ACID (atomicity, consistency, isolation, durability) guarantees. ACID properties are important for reservation systems. Without those properties, it's not easy to prevent problems such as double reservations. ACID properties make application code a lot simpler and make the whole system easier to reason about.** 

A relational database can easily model the data. The structure of the business data is very clear and the relationship between different entities (Theatre, Screen, Show, etc) is stable. This kind of data model is easily modelled by a relational database. 

---

Q. Which database to use?

Use MySQL over PostgreSQL

---

Q. What is the use of Public API Gateway?

A fully managed service that supports rate limiting, authentication, etc. The API gateway is configured to direct requests to specific services based on the endpoints.

---

Q. How does the inter-service communication happens?

For production systems, inter-service communication often employs a modern and high-performance remote procedure call (RPC) framework like **gRPC**.  

---

Q. Estimate the storage volume.

Booking database will grow dynamically. 

1000 Theatres x 5 screens x 100 seats x 365 days ~= 150 million rows per year.

150 million rows is not a lot of data and a single database is enough to store the data. However, a single database means a single point of failure. To achieve high availability, we could setup database replications across multiple regions or availability zones.

---

Q. If the reservation data is too large, what would you do?

37. Store only the current and future reservation data. Reservation history is not frequently accessed. So they can be archived and some can even be moved to cold storage. 

38. **Database Sharding**: The most frequent queries include making a reservation. However, we need to choose the `movie/theatre` first, meaning `movie_id/theatre_id` is a good sharding key. 

---

Q. Explain double booking - concurrency issue. 

We need to solve 2 problems:

39. **The same user clicks on the "book" button multiple times.** Two common approaches to solve this problem:

	- **Client-side implementation:** A client can grey out, hide or disable the "submit" button once a request is sent.

	- **Idempotent API:** Add an idempotency key (e.g., `reservation_id`) in the reservation API request. 
		- After the customer enters detailed information about the reservation (seat type, date, time, etc) and clicks the "continue" button, a `reservation order` is generated by the reservation service for the customer to review. 
		- The unique `reservation_id` is generated by a **globally unique ID generator** and returned as part of the API response. 
		- Once the user clicks "submit", the `reservation_id` is included as part of the request to complete the booking.
		- If a user clicks the "submit" button a second time, reservation 2 is submitted. Because `reservation_id` is the primary key of the `reservation` table, we can rely on the unique constraint of the key to ensure no double reservation happens.

40. **Multiple users try to book the same seat at the same time.** The **isolation** property in ACID means database transactions must complete their task independently from other transactions. So data changes made by transaction 1 are not visible to transaction 2 (executed at the same time) until the transaction 1 is complete. This results in the system allowing both users to book a seat, but there is only 1 seat left. The solution to this problem requires some form of locking mechanism. 

	- **Pessimistic Locking:** 

	- **Optimistic Locking:**

	- **Database Constraints:**

---
## EXTRA

- When a screen is deleted/stopped working, nothing happens to the Theatre table. Hence, the theatre table/entity does not need a field / column to present its association with the screen table/entity. There can be a unidirectional relationship between screen and theatre, where the theatre doesn’t have reference back to the screen. 

- When a movie is removed/deleted, all shows associated with that movie should be removed. Hence, we need a bidirectional relationship between show and movie.

- When a screen is deleted/stopped working, all shows associated with that screen should be removed. Hence, we need a bidirectional relationship between show and screen.

- **Bidirectional Relationship**: Fetch Movies based on its shows location. Fetch shows based on the selected movie.

- If each `Movie` object in the response contains a list of `Show` objects, and each `Show` contains a reference back to the `Movie`, this circular reference can result in unnecessarily large responses and potentially cause infinite recursion issues when serializing the objects (e.g., in JSON).

- **Perform integration tests using a test database (e.g. H2 database)** to test out the custom query methods and complex logic in the `MovieRepository` class.






 






