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

## Functional Requirement

Assume the logic that allows system to display the list of currently running movies is already implemented. You are required to implement the **Show Selection**, **Seat Selection**, **Pricing**, **Payment** and **Notification** services.

## Use Cases

1. The **customer** selects his/her preferred **location**. A **GET request** is sent to **fetch the list of movies currently showing in the theatres near the preferred location**.

2. The **customer** selects a **movie** and his/her preferred **date** and **location**. A **GET request** is sent to **fetch the list of available shows for the selected movie on the preferred date**.

3. The **Customer** selects a **show**. A **GET request** is sent to **fetch the lits of available seats for the selected show**. 

4. The **customer** selects his/her preferred **seats**. A **POST request** is sent to **book the selected seats**.

## Services

1. `MovieService`:

    - **Private Data Members**: `MovieDAO` movieDAO, `ShowDAO` showDAO, `SeatDAO` seatDAO, `PaymentService` paymentService, `NotificationService` notificationService, `BookingDAO` bookingDAO.

    - **Public Member Functions**: 

        - `List<Movie>` getMovies(`Location` location): fetch the list of movies currently showing in the theatres near the preferred location.

        - `List<Show>` getShows(`Movie` movie, `LocalDate` date): fetch the list of available shows for the selected movie on the preferred date.

        - `List<Seat>` getAvailableSeats(`Show` show): fetch the list of available seats for the selected show.

        - `Booking` bookSeats(`Customer` customer, `Show` show, `List<Seat>` seats): book the selected seats for the customer in the selected show. 

2. `PaymentService`:

    - **Public Member Functions**: 

        - `boolean` processPayment(`Customer` customer, `double` amount)

3. `NotificationService`:

    - **Public Member Functions**:

        - notifySeatUnavailable(`Customer` customer, `Seat` seat) 

        - notifyPaymentFailure(`Customer` customer)

        - sendBookingConfirmation(`Customer` customer, `Booking` booking)


## Data Tranfer Objects (DTOs)

1. `Customer`:

    - **Private Data Members**: `int` customerId, `String` name, `Location` location, `String` email, `String` phone, `List<Booking>` bookings.

    - **Public Member Functions**: All Getters and Setters.

2. `Location`:

    - **Private Data Members**: `String` street, `String` city, `String` state, `String` country, `String` postalCode.

    - **Public Member Functions**: All Getters and Setters.

3. `Movie`:

    - **Private Data Members**: `int` movieId, `String` title, `String` genre, `String` releaseDate, `int` duration.

    - **Public Member Functions**: All Getters and Setters.

4. `Show`:

    - **Private Data Members**: `int` showId, `Movie` movie, `Theatre` theatre, `Screen` screen, `LocalDateTime` showTime.

    - **Public Member Functions**: All Getters and Setters. 

5. `Screen`:

    - **Private Data Members**: `int` screenId, `String` screenName, `Theatre` theatre.

    - **Public Member Functions**: All Getters and Setters. 

6. `Theatre`:

    - **Private Data Members**: `int` theatreId, `Location` location.

    - **Public Member Functions**: All Getters and Setters.

7. `Seat`:

    - **Private Data Members**: int `seatId`, `String` seatNumber, `SeatType` seatType, `boolean` isBooked. 

    - **Public Member Functions**: All Getters and Setters.

8. `Booking`:

    - **Private Data Members**: `int` bookingId, `Customer` customer, `Show` show, `List<Seat>` bookedSeats, `double` totalAmount, `BookingStatus` status.

    - **Public Member Functions**: All Getters and Setters.

**NOTE:**

- Do not include `Show` directly in the `Seat` class. Instead, use a `Booking` class to manage the relationship between Seats and Shows.

## Enums

1. `SeatType`: NORMAL(price: 250), PREMIUM(price: 400), VIP(price: 550).

2. `BookingStatus`: CONFIRMED, CANCELED.

## Data Access Objects (DAOs)

1. `MovieDAO`:

    - **Public Member Functions**:

        - `List<Movie>` getMoviesByLocation(`String` city, `String` state): SELECT DISTINCT m.movieId, m.title, m.genre, m.releaseDate, m.duration FROM movie m JOIN show s ON m.movieId = s.movieId JOIN theatre t ON s.theatreId = t.theatreId WHERE t.city = ? and t.state = ?.

        - `Movie` getMovieById(`int` movieId): SELECT * FROM movie WHERE movieId = ?.

2. `ShowDAO`:

    - **Private Data Members**: `MovieDAO` movieDAO, `ScreenDAO` screenDAO. 

    - **Public Member Functions**:

        - `List<Show>` getShowsByMovieIdAndDate(int movieId, LocalDate date): SELECT * FROM show WHERE movieId = ? and showTime = ?.

3. `ScreenDAO`:

    - **Public Member Functions**:

        - `Screen` getScreenById(`int` screenId): SELECT * FROM screen WHERE screenId = ?.

4. `SeatDAO`:

    - **Public Member Functions**:

        - `List<Seat>` getSeatsByShowId(`int` showId): SELECT * FROM seat WHERE showId = ?.

        - `boolean` updateSeatBookingStatus(`int` seatId, `boolean` isBooked): UPDATE seat SET isBooked = ? WHERE seatId = ?.

5. `BookingDAO`:

    - **Public Member Functions**: 

        - addBooking(`Booking` booking): INSERT INTO booking (bookingId, customerId, showId, amount, status) VALUES (?,?,?,?,?).
        
## Entities (Database Schema)

1. `customer`: `int` customerId, `varchar` name, `varchar` city, `varchar` state, `varchar` country, `varchar` email, `varchar` phone.

2. `movie`: `int` movieId, `varchar` title, `varchar` genre, `date` releaseDate, `int` duration.

3. `show`: `int` showId, `int` movieId, `int` theatreId, `int` screenId, `date` showTime.

4. `theatre`: `int` theatreId, `varchar` street, `varchar` city, `varchar` state, `varchar` country, `varchar` postalCode.

5. `screen`: `int` screenId, `varchar` screenName, `int` theatreId. 

6. `seat`: `int` seatId, `varchar` seatNumber, `varchar` seatType, `int` showId, `boolean` isBooked.

7. `booking`: `int` bookingId, `int` customerId, `int` showId, `int` totalAmount, `varchar` status.

**Constraints:**

- When a theatre is removed from the `theatre` table, all the screens belonging to that theatre should also be removed from the `screen` table.

- When a movie is removed from the `movie` table, all the shows corresponding to that movie should also be removed from the `show` table.

- When a theatre is removed from the `theatre` table, all the shows running in that theatre should also be removed from the `show` table. 

## Non-Functional Requirements

1. **Handle Concurrency:** The `MovieService.bookSeats(customer, show, seats)` functionality can leverage database transactions and locking mechanisms (e.g. pessimistic locking) to ensure data consistency when multiple customers attempt to book the same seats simultaneously.

2. **Error Handling:** If any part of the booking process fails (e.g., payment or seat update), the method throws an exception, ensuring the transaction is rolled back.

3. **Improve Maintenance:** Adopting the singleton pattern for service and DAO classes reduces the overhead of creating and managing resources, ensures thread safety, maintains consistency in business logic or database operations, minimizes dependency management complexity, and simplifies the overall code structure.

4. **Maintain Data Integrity:** We cannot have two shows running on a screen in a theatre at same time. You use a **trigger** at the database level to catch overlapping shows for ultimate data integrity (guarantees integrity no matter the source of data insertion). Alternatively, you can implement checks in your service layer or DAO to ensure no overlapping shows are added.

## EXTRA

- When a screen is deleted/stopped working, nothing happens to the Theatre table. Hence, the theatre table/entity does not need a field / column to present its association with the screen table/entity. There can be a unidirectional relationship between screen and theatre, where the theatre doesn’t have reference back to the screen. 

- When a movie is removed/deleted, all shows associated with that movie should be removed. Hence, we need a bidirectional relationship between show and movie.

- When a screen is deleted/stopped working, all shows associated with that screen should be removed. Hence, we need a bidirectional relationship between show and screen.

- **Bidirectional Relationship**: Fetch Movies based on its shows location. Fetch shows based on the selected movie.

- If each `Movie` object in the response contains a list of `Show` objects, and each `Show` contains a reference back to the `Movie`, this circular reference can result in unnecessarily large responses and potentially cause infinite recursion issues when serializing the objects (e.g., in JSON).

- **Perform integration tests using a test database (e.g. H2 database)** to test out the custom query methods and complex logic in the `MovieRepository` class.




 




