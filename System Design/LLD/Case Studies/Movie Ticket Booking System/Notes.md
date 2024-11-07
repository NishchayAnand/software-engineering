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

1. A `Customer` selects a `Movie` based on his/her preferred **location** and **date**. The frontend sends a **GET request** to the `MovieService.getShows(movieId, date, location)` to fetch the `List<Show>` for the selected `Movie` and displays it to the `Customer`.

2. The `Customer` selects a `Show`. The frontend sents a **GET request** to the `MovieService.getAvailableSeats(Show)` to fetch the `Map<Seat, isBooked>` and displays the theater seating layout along with the available and booked seats to the `Customer`. 

3. The `Customer` selects his/her preferred `List<Seat>`. The frontend sends a **POST request** to the `MovieService.bookTickets(Show, List<Seat>)` to: 

    - **update the `Map<Seat, isBooked>`**: to lock `List<Seat>` for the selected `Show`,

    - **calculate the `paymentAmount`**: based on `size(List<Seat>)` and `SeatType`,

    - **call `TransactionStatus = PaymentService.processPayment(paymentAmount)`**: If **TransactionStatus == SUCCESS**, call `NotificationService.sendConfirmation(Customer, Booking)` to share `bookingId` with the `Customer`. If **TransactionStatus == Fail**, update the `Map<Seat, isBooked>` to unlock `List<Seat>` for the selected `Show` and call `NotificationService.notifyFailure(Customer)` to update the `Customer`.

## Entities

1. `Customer`:
    - **Private Data Members**: `int` customerId, `String` name, `String`email, `String` address, `String`  phone, `List<Booking>` bookings.
    - **Public Member Functions**: All Getters and Setters.

2. `Movie`:
    - **Private Data Members**: `int` movieId, `String` title, `String` genre, `String` releaseDate, `String` duration, `List<String>` languages, `List<Show>`.
    - **Public Member Functions**: All Getters and Setters.

3. `Show`:
    - **Private Data Members**: `int` showId, `int` movieId, `int` theatreId, `int` screenId, `LocalDateTime` showTime, `List<Seat>` bookedSeats.
    - **Public Member Functions**: All Getters and Setters.

4. `Seat`:
    - **Private Data Members**: `int` seatId, `int` theatreId, `int` screenId. 
    - **Public Member Functions**: All Getters and Setters.

5. `Screen`:
    - **Private Data Members**: `int` screenId, `int` theatreId, `List<Seat>` seats.
    - **Public Member Functions**: All Getters and Setters. 

6. `Theatre`:
    - **Private Data Members**: `int` theatreId, `String` address, `List<Screen>` screens.
    - **Public Member Functions**: All Getters and Setters.

7. `Booking`:
    - **Private Data Members**:
    - **Public Member Functions**:

## Services

1. `MovieService`:
    - **Public Member Functions**: `List<Show>` getShows(movieId, date, location), `Map<Seat, isBooked>` getAvailableSeats(`Show`), bookTickets(`Show`, `List<Seat>`).

2. `PaymentService`:
    - **Public Member Functions**: `String` processPayment(paymentAmount).

3. `NotificationService`:
    - **Public Member Functions**: sendConfirmation(`Customer`, `Booking`), notifyFailure(`Customer`).



