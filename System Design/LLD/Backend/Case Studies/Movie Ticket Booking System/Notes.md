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

1. The **customer** selects his/her preferred **location**. A **GET request** is sent to **fetch the list of movies that have shows in the current week in the theatres near the preferred location**.

2. The **customer** selects a **movie** and his/her preferred **date** and **location**. A **GET request** is sent to **fetch the list of available shows for the selected movie on the preferred date**.

3. The **Customer** selects a **show**. A **GET request** is sent to **fetch the details of booked and available seats for the selected show**. 

4. The **customer** selects his/her preferred **seats**. A **POST request** is sent to **book the selected seats**.

## Data Tranfer Objects (DTOs)

1. `Customer`:
    - **Private Data Members**: `String` name, `Location` location, `String` email, `String` phone, `List<Booking>` bookings.
    - **Public Member Functions**: All Getters and Setters.

2. `Location`:
    - **Private Data Members**: `String` street, `String` city, `String` state, `String` country, `String` postalCode.
    - **Public Member Functions**: All Getters and Setters.

3. `Movie`:
    - **Private Data Members**: `String` title, `String` genre, `String` releaseDate, `int` duration, `List<Show>` shows.
    - **Public Member Functions**: All Getters and Setters.

4. `Show`:
    - **Private Data Members**: `Movie` movie, `Screen` screen, `LocalDateTime` showTime.
    - **Public Member Functions**: All Getters and Setters. 

5. `Screen`:
    - **Private Data Members**: `String` screenName, `Theatre` theatre, `List<Seat>` seats, `List<Show>` shows.
    - **Public Member Functions**: All Getters and Setters. 

6. `Theatre`:
    - **Private Data Members**: `Location` location, `List<Screen>` screens.
    - **Public Member Functions**: All Getters and Setters.

7. `Seat`:
    - **Private Data Members**: `int` seatNumber, `Screen` screen, `SeatType` seatType, `boolean` isBooked. 
    - **Public Member Functions**: All Getters and Setters.

8. `Booking`:
    - **Private Data Members**: `Customer` customer, `Show` show, `List<Seat>` bookedSeats, `double` totalAmount, `PaymentStatus` paymentStatus, `BookingStatus` bookingStatus.
    - **Public Member Functions**: All Getters and Setters.

## Enums

1. `SeatType`: NORMAL(price: 250), PREMIUM(price: 400), VIP(price: 550).
2. `PaymentStatus`: PENDING, COMPLETED, FAILED.
3. `BookingStatus`: COMPLETED, CANCELED.

## Services

1. `MovieService`:
    - **Public Member Functions**: `List<Movie>` getMovies(`Location` customerLocation), `List<Show>` getAvailableShows(`Movie` movie, `LocalDate` date), `Booking` bookSeats(`Customer` customer, `List<Seat>` seats).

## Entities

1. `Customer`: `int` customerId, `varchar` name, `varchar` city, `varchar` state, `varchar` country, `varchar` email, `varchar` phone.
2. `Movie`: `int` movieId, `varchar` title, `varchar` genre, `date` releaseDate, `int` duration.
3. `Show`: `int` showId, `int` movieId, `int` screenId, `date` showTime.
4. `Theatre`: `int` theatreId, `varchar` street, `varchar` city, `varchar` state, `varchar` country, `varchar` postalCode.
5. `Screen`: `int` screenId, `varchar` screenName, `int` theatreId. 

## Non-Functional Requirements

1. Ids should be auto-generated. 
2. Should bookings attribute in Customer class be final?
3. How to handle concurrency when multiple Customers try to book a same Seat?
4. **How to get instance of TheatreDAO and ShowDAO in MovieService class? Should instance of TheatreDAO and ShowDAO be final in MovieService class?**
5. How to map RelationalEntity(showId, movieId, screenId, showTime) to Show(showId, Movie, Screen, showTime)?
