# Movie Ticket Booking System Low Level Design

An online platform or application that allows users to browse, select, and purchase (book) tickets for movies currently showing in theaters. For example, `BookMyShow`, `PayTMInsider`.

## Key Features and Services

- **User Registration and Login:** Should allow users to create an account and authenticate themselves to access the platform's services.

- **Movie Listings:** Displays the list of currently running and upcoming movies along with details like genre, duration, rating, and trailers.

- **Theater and Showtime Selection:** Users should be able to view all available theaters and their showtimes based on their preferred date and location.

- **Seat Selection:** Shows a seat map for the selected theater and allows users to choose their preferred seats, with real-time availability updates.

- **Pricing:** Provides ticket pricing based on factors like seat location and time of show.

- **Payment:** Integrates with payment gateways to allow secure transactions via credit/debit cards, digital wallets, or net banking.

- **Notification:** Generates a booking confirmation after successful payment, often with a digital ticket (QR code), sent via email, SMS, or within the app.

## Functional Requirement

Assume the logic that allows system to display the list of currently showing movies is already implemented. You are requirement to implement the `Seat Selection`, `Pricing`, `Payment` and `Notification` services.

## Use Cases

- A `Customer` selects a `Movie` based on his/her preferred **location** and **date**. The frontend client (browser or mobile application) sends a **GET request** to the `MovieService.getShows(Movie)` to fetch the `List<Show>` for the selected `Movie` and displays it the `Customer`.

- The `Customer` selects a `Show`. The frontent clients sends a **GET request** to the `MovieService.getAvailableSeats(Show)` to fetch the `Map<seatId, isBooked>` and display the theater seating layout showing available and booked seats to the `Customer`. 

- The `Customer` selects his/her preferred `List<Seat>`. The frontend client sends a **POST request** to the `MovieService.bookTickets(Show, List<Seat>)` to book the selected `List<Seat>` in the selected `Show` for the selected `Movie`.

- The `MovieService.bookTickets(Show, List<Seat>)` functionality calculates the total cost based on the `size(List<Seat>)` and `SeatType` and sends a call to the `PaymentService`.

## Entities and their Relationships



