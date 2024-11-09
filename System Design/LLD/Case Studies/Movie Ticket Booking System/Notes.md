# Movie Ticket Booking System

An online platform or application that allows users to browse, select, and book tickets for movies currently showing in theaters. For example, `BookMyShow`, `PayTMInsider`.

## Key Features and Services

- **User Registration and Login:** Should allow users to create an account and authenticate themselves to access the platform's services.

- **Movie Listings:** Displays the list of currently running movies along with details like genre, duration, rating, and trailers.

- **Show Selection:** Users should be able to view all available theaters and their showtimes based on their selected movie, preferred date and location.

- **Seat Selection:** Shows a seat map for the selected theater and allows users to choose their preferred seats, with real-time availability updates.

- **Pricing:** Provides ticket pricing based on factors like seat location and time of show.

- **Payment:** Integrates with payment gateways to allow secure transactions via credit/debit cards, digital wallets, or net banking.

- **Notification:** Generates a booking confirmation after successful payment, often with a digital ticket (for example, QR code), sent via email, SMS, or within the app.

## Functional Requirement

Assume the logic that allows system to display the list of currently running movies is already implemented. You are required to implement the **Seat Selection**, **Pricing**, **Payment** and **Notification** services.

## Use Cases

1. The **customer** selects his/her preferred **location**. A **GET request** is sent to **fetch the list of movies currently running** in the theatres.

2. The **customer** selects a **movie** and his/her preferred **date**. A **GET request** is sent to **fetch the list of available shows for the selected movie on the preferred date**.

3. The **Customer** selects a **show**. A **GET request** is sent to **fetch the details of booked and available seats for the selected show**. 

4. The **customer** selects his/her preferred **seats**. A **POST request** is sent to **book the selected seats**.

## Entities

1. `Customer`:
    - **Private Data Members**: `int` customerId, `String` name, `String`email, `String` address, `String`  phone, `List<Booking>` bookings.
    - **Public Member Functions**: All Getters and Setters.

2. `Movie`:
    - **Private Data Members**: `int` movieId, `String` title, `String` genre, `String` releaseDate, `int` duration, `List<Show>` shows.
    - **Public Member Functions**: All Getters and Setters.

3. `Show`:
    - **Private Data Members**: `int` showId, `Movie` movie, `Screen` screen, `LocalDateTime` showTime, `List<Seat>` bookedSeats.
    - **Public Member Functions**: All Getters and Setters.

> NOTE: 

4. `Screen`:
    - **Private Data Members**: `int` screenId, `Theatre` theatre, `List<Seat>` seats.
    - **Public Member Functions**: All Getters and Setters. 

5. `Theatre`:
    - **Private Data Members**: `int` theatreId, `String` address, `List<Screen>` screens.
    - **Public Member Functions**: All Getters and Setters.

6. `Seat`:
    - **Private Data Members**: `int` seatId, `int` theatreId, `int` screenId. 
    - **Public Member Functions**: All Getters and Setters.





7. `Booking`:
    - **Private Data Members**: `int` bookingId, `int` showId.
    - **Public Member Functions**: All Getters and Setters.

## Services

1. `MovieService`:
    - **Public Member Functions**: `List<Show>` getShows(movieId, date, location), `Map<Seat, isBooked>` getAvailableSeats(`Show`), bookTickets(`Show`, `List<Seat>`).

2. `PaymentService`:
    - **Public Member Functions**: `String` processPayment(paymentAmount).

3. `NotificationService`:
    - **Public Member Functions**: sendConfirmation(`Customer`, `Booking`), notifyFailure(`Customer`).

## Relationships (optional)

1. A `Customer` can have multiple `Booking`. A `Booking` is associated to a single `Customer`. 
2. A `Movie` can have multiple `Show`. A `Show` is associated to a single `Movie`.

