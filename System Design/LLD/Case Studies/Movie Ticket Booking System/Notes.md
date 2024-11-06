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
    - **Private Data Members**: `int` customerId, `String` name, `String`email, `String` location, `String`  phone, `List<Booking>` bookings

    - **Public Member Functions**: All Getters and Setters, 

2. `Movie`:
    - **Private Data Members**: movieId(`int`), title(`String`), genre(`String`), releaseDate(`String`), duration(`String`), languages(`List<String>`), shows(`List<Show>`).

    - **Public Member Functions**: All Getters and Setters

3. `Show`:
    - **Private Data Members**: showId(`int`), movie(`Movie`), theatre(`Theatre`), screen(`Screen`), date(`datetime`), showTime(`datetime`), seats(`List<Seat>`)

    - **Public Member Functions**: All Getters and Setters, `List<Seat>` getAvailableSeats(), `List<Seat>` getBookedSeats()

4. `Theatre`:

5. `Screen`:

6. `Seat`:

## Services

1. `MovieService`:
    - **Public Member Functions**: `List<Show>` getShows(movieId, date, location)



