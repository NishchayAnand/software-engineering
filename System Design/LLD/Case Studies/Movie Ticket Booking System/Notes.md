# Movie Ticket Booking System 

A system that allows customers to book movies online. For example, **BookMyShow**, **PayTM Insider**.  

## Functional Requirements

- User a.k.a Customer should be able to:
    - search a movie,
    - reserve a seat,
    - pay for the booking.

- System should be able to: 
    - display the show availablility, 
    - display the seating layout highlighting all the booked and available seats,
    - sends a booking confirmation notification.  

## Non-Functional Requirements

- The system needs to make sure no two users can book the same seat.    

## Storage Requirements

- Should hold information of all cinemas across the catered regions.
- Should maintain a movies' database.

## Use Case Diagram

- Customer can search for a particular movie based on the following criterias: `title`, `language`, `genre`, `release date`.
- Customer can book one or more movie tickets for any movie. 
- Customer can cancel the booking. 
- Customer can pay via `Credit Card`, `Debit Card,` or `UPI`. 

## Class Diagram

- **Abstract Classes**:

    - `Seat`: 
        - -seatNo: string,
        - -rate: double, 
        - -isAvailable: boolean; 
        - +isAvailable(): boolean;

- **Concrete Classes**:

    - `NormalSeat` extends `Seat`

    - `PremiumSeat` extends `Seat`
    
    - `Show`:
        - -showID: int,
        - -startTime: datetime
        - -date: date
        - -duration: int
        - -seats: List(Seats);
        - +showAvailableSeats(): void

    - `Hall`:
        - -hallId: int,
        - shows: List(Show);

    - `Cinema`:
        - cinemaID: int,
        - halls: list(Hall),
        - state: string,
        - city: string,
        - address: string,
        - pinCode: string;

    - `Movie`:
        - 

    


## Sequence Diagram

## Activity Diagram

