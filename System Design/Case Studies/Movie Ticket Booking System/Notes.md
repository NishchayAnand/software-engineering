# Movie Ticket Booking System

An online platform or application that allows users to browse, select, and book tickets for movies currently showing in theaters. For example, **BookMyShow**.

## Key Features and Services

- **User Registration and Login:** Should allow users to create an account and authenticate themselves to access the platform's services.

- **Movie Listings:** Displays the list of currently running movies along with details like genre, duration, rating, and trailers.

- **Show Selection:** Users should be able to view all available theaters and their showtimes based on their selected movie, preferred date and location.

- **Seat Selection:** Shows a seat map for the selected theater and allows users to choose their preferred seats, with real-time availability updates.

- **Pricing:** Provides ticket pricing based on factors like seat type.

- **Payment:** Integrates with payment gateways to allow secure transactions via credit/debit cards, digital wallets, or net banking.

- **Notification:** Generates a booking confirmation after successful payment, often with a digital ticket (for example, QR code), sent via email, SMS, or within the app.

## Use Cases

1. The **customer** selects his/her preferred **location**. A **GET request** is sent to **fetch the list of movies currently showing in the theatres near the preferred location**.

2. The **customer** selects a **movie** and his/her preferred **date** and **location**. A **GET request** is sent to **fetch the list of available shows for the selected movie on the preferred date**.

3. The **Customer** selects a **show**. A **GET request** is sent to **fetch the lits of available seats for the selected show**. 

4. The **customer** selects his/her preferred **seats**. A **POST request** is sent to **book the selected seats**.

## Functional Requirements

Assume the logic that allows system to display the list of currently running movies is already implemented. You are required to implement the **Show Selection**, **Seat Selection**, **Pricing**, **Payment** and **Notification** services.

## Non-Functional Requirements

5. **High Concurrency**: At peak times, for example, on the release day, multiple customer may try to book the same ticket. 
6. **Moderate Latency:** It's ideal to have a fast response time when a user makes a reservation, but it's okay if the system takes a few seconds to process the reservation requests. 

## Services

7. `MovieService`: Provides detailed information on Movies, Theatres, Screens, Shows. Theatres and screens are generally static, so can be easily cached. 

    - **Private Data Members**: `MovieDAO` movieDAO, `ShowDAO` showDAO, `SeatDAO` seatDAO, `PaymentService` paymentService, `NotificationService` notificationService, `BookingDAO` bookingDAO.

    - **Public Member Functions**: 

        - `List<Movie>` getMovies(`Location` location): fetch the list of movies currently showing in the theatres near the preferred location.

        - `List<Show>` getShows(`Movie` movie, `LocalDate` date): fetch the list of available shows for the selected movie on the preferred date.

        - `List<Seat>` getAvailableSeats(`Show` show): fetch the list of available seats for the selected show.

8. `ReservationService`: Receives reservation requests and reserves the movie show. This service also tracks seat inventory as tickets are reserved or bookings are cancelled.

	- **Private Data Members**: `BookingDAO` bookingDAO.

	- **Public Member Functions**: 

        - `Booking` bookSeats(`Customer` customer, `Show` show, `List<Seat>` seats): book the selected seats for the customer in the selected show. 

9. `RateService`

10. `PaymentService`: executes payment from a customer and updates the reservation status to `paid` once the payment transaction succeeds, or `rejected` if the transaction fails.

    - **Public Member Functions**: 

        - `boolean` processPayment(`Customer` customer, `double` amount)

11. `NotificationService`:

    - **Public Member Functions**:

        - notifySeatUnavailable(`Customer` customer, `Seat` seat) 

        - notifyPaymentFailure(`Customer` customer)

        - sendBookingConfirmation(`Customer` customer, `Booking` booking)


## Data Tranfer Objects (DTOs)

12. `Customer`:

    - **Private Data Members**: `int` customerId, `String` name, `Location` location, `String` email, `String` phone, `List<Booking>` bookings.

    - **Public Member Functions**: All Getters and Setters.

13. `Location`:

    - **Private Data Members**: `String` street, `String` city, `String` state, `String` country, `String` postalCode.

    - **Public Member Functions**: All Getters and Setters.

14. `Movie`:

    - **Private Data Members**: `int` movieId, `String` title, `String` genre, `String` releaseDate, `int` duration.

    - **Public Member Functions**: All Getters and Setters.

15. `Show`:

    - **Private Data Members**: `int` showId, `Movie` movie, `Theatre` theatre, `Screen` screen, `LocalDateTime` showTime.

    - **Public Member Functions**: All Getters and Setters. 

16. `Screen`:

    - **Private Data Members**: `int` screenId, `String` screenName, `Theatre` theatre.

    - **Public Member Functions**: All Getters and Setters. 

17. `Theatre`:

    - **Private Data Members**: `int` theatreId, `Location` location.

    - **Public Member Functions**: All Getters and Setters.

18. `Seat`:

    - **Private Data Members**: int `seatId`, `String` seatNumber, `SeatType` seatType, `boolean` isBooked. 

    - **Public Member Functions**: All Getters and Setters.

> NOTE: Seat numbers are assigned when a customer books a ticket. 

19. `Booking`:

    - **Private Data Members**: `int` bookingId, `Customer` customer, `Show` show, `List<Seat>` bookedSeats, `double` totalAmount, `BookingStatus` status.

    - **Public Member Functions**: All Getters and Setters.

**NOTE:**

- Do not include `Show` directly in the `Seat` class. Instead, use a `Booking` class to manage the relationship between Seats and Shows.

## Enums

20. `SeatType`: NORMAL(price: 250), PREMIUM(price: 400), VIP(price: 550).

21. `BookingStatus`: CONFIRMED, CANCELED.

## Data Access Objects (DAOs)

22. `MovieDAO`:

    - **Public Member Functions**:

        - `List<Movie>` getMoviesByLocation(`String` city, `String` state): SELECT DISTINCT m.movieId, m.title, m.genre, m.releaseDate, m.duration FROM movie m JOIN show s ON m.movieId = s.movieId JOIN theatre t ON s.theatreId = t.theatreId WHERE t.city = ? and t.state = ?.

        - `Movie` getMovieById(`int` movieId): SELECT * FROM movie WHERE movieId = ?.

23. `ShowDAO`:

    - **Private Data Members**: `MovieDAO` movieDAO, `ScreenDAO` screenDAO. 

    - **Public Member Functions**:

        - `List<Show>` getShowsByMovieIdAndDate(int movieId, LocalDate date): SELECT * FROM show WHERE movieId = ? and showTime = ?.

24. `ScreenDAO`:

    - **Public Member Functions**:

        - `Screen` getScreenById(`int` screenId): SELECT * FROM screen WHERE screenId = ?.

25. `SeatDAO`:

    - **Public Member Functions**:

        - `List<Seat>` getSeatsByShowId(`int` showId): SELECT * FROM seat WHERE showId = ?.

        - `boolean` updateSeatBookingStatus(`int` seatId, `boolean` isBooked): UPDATE seat SET isBooked = ? WHERE seatId = ?.

26. `BookingDAO`:

    - **Public Member Functions**: 

        - addBooking(`Booking` booking): INSERT INTO booking (bookingId, customerId, showId, amount, status) VALUES (?,?,?,?,?).
        
## Entities (Database Schema)

27. `customer`: `int` customerId, `varchar` name, `varchar` city, `varchar` state, `varchar` country, `varchar` email, `varchar` phone.

28. `movie`: `int` movieId, `varchar` title, `varchar` genre, `date` releaseDate, `int` duration.

29. `show`: `int` showId, `int` movieId, `int` theatreId, `int` screenId, `date` showTime.

30. `theatre`: `int` theatreId, `varchar` street, `varchar` city, `varchar` state, `varchar` country, `varchar` postalCode.

31. `screen`: `int` screenId, `varchar` screenName, `int` theatreId. 

32. `seat`: `int` seatId, `varchar` seatNumber, `varchar` seatType, `int` showId, `boolean` isBooked.

33. `booking`: `int` bookingId, `int` customerId, `int` showId, `int` totalAmount, `varchar` status.

**Constraints:**

- When a theatre is removed from the `theatre` table, all the screens belonging to that theatre should also be removed from the `screen` table.

- When a movie is removed from the `movie` table, all the shows corresponding to that movie should also be removed from the `show` table.

- When a theatre is removed from the `theatre` table, all the shows running in that theatre should also be removed from the `show` table. 

## Non-Functional Requirements

34. **Handle Concurrency:** The `MovieService.bookSeats(customer, show, seats)` functionality can leverage database transactions and locking mechanisms (e.g. pessimistic locking) to ensure data consistency when multiple customers attempt to book the same seats simultaneously.

35. **Maintain Data Integrity:** We cannot have two shows running on a screen in a theatre at same time. You use a **trigger** at the database level to catch overlapping shows for ultimate data integrity (guarantees integrity no matter the source of data insertion). Alternatively, you can implement checks in your service layer or DAO to ensure no overlapping shows are added.

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

36. **View Upcoming / Showing Movies Detail Page:** Users browse this page (query).
37. **View Booking Page:** Users can confirm the booking details, such as dates, number of tickets, payment details before booking (query).
38. **Reserve the Tickets:** Users click the "book" button to book the movie tickets and the tickets are reserved (transaction).

Assuming only 10% of the user reach the final and 90% of the user drop before reaching the final step.

39. **QPS of View Upcoming / Showing Movies Detail Page:** 300 QPS
40. **QPS of View Booking Page:** 30 QPS
41. **QPS (TPS) of Reserve the Tickets:** 3 QPS

---

Q. Understand Data Access Patterns.

For a booking movie system, we need to support the following queries:

42. View detailed information about a movie.
43. Find available shows for a given date range.
44. Record a reservation.

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
## EXTRA

- When a screen is deleted/stopped working, nothing happens to the Theatre table. Hence, the theatre table/entity does not need a field / column to present its association with the screen table/entity. There can be a unidirectional relationship between screen and theatre, where the theatre doesn’t have reference back to the screen. 

- When a movie is removed/deleted, all shows associated with that movie should be removed. Hence, we need a bidirectional relationship between show and movie.

- When a screen is deleted/stopped working, all shows associated with that screen should be removed. Hence, we need a bidirectional relationship between show and screen.

- **Bidirectional Relationship**: Fetch Movies based on its shows location. Fetch shows based on the selected movie.

- If each `Movie` object in the response contains a list of `Show` objects, and each `Show` contains a reference back to the `Movie`, this circular reference can result in unnecessarily large responses and potentially cause infinite recursion issues when serializing the objects (e.g., in JSON).

- **Perform integration tests using a test database (e.g. H2 database)** to test out the custom query methods and complex logic in the `MovieRepository` class.






 




