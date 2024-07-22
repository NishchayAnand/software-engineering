# Design a Parking Lot System

A **parking lot** is a designated area for parking vehicles and is a feature found in almost all popular venues such as shopping malls, sports stadiums, offices, etc.

## General Observations

- A fixed number of parking spots are available for different vehicles types.
- Each vehicle is charged according to the time the vehicle has been parked in the parking lot.
- The parking time is tracked with the parking ticket issued to the vehicle at the entrance of the parking lot.
- Once the vehicle is ready to exit, it can either pay at the automatic exit panel or to the parking agent at the exit using a card or cash payment method.

## Requirements

- **What should be the capacity of the parking lot?** We can assume that the parking lot has the capacity to park 4000 vehicles (4 floors each with a capacity to park 1000 vehicles).

- **What different types of vehicles can the parking lot park?** We can assume that the parking lot can accomodate 2 types of vehicles: `Cars: SUVs, Sedans, Hatchbacks`, `Motorcycles`.

- **Does the parking lot has multiple entry and exit points?** We can assume that the parking lot has 2 entry points and 2 exit points.

## Use Case Diagram

**System:** Parking Lot System

**Primary Actors:** `Customer` and `Parking Agent: Assist Customer with parking ticket and payment`

**Secondary Actors:** `Admin: can update a spot, agent, extry/exit points` and `Display Board: Gives details of parking spot availability`

**Use Cases:**

- `Customer`: take ticket, scan ticket, pay ticket, park vehicle.
- `Parking Agent`: give ticket, take ticket, scan ticket, pay ticket.
- `Admin`: add spot, remove spot, add agent, remove agent, update entry/exit points.
- `Display Board`: tell parking slot availability.

**Relationships:**

- The `Parking Agent` has a generalization relationship with the `Customer` since the parking agent can perform all those tasks that a customer can perform.

- `Pay using Cash` and `Pay using Credit/Debit card` use cases are used for payments. Hence, both have a generalization relationship with the `Pay ticket` use case.

## Class Diagram

**Components:**

- The `Vehicle` can be a `Car` or a `Motorcycle`. The `Vehicle` can be represented as an **abstract class** in the system. `Car` and `Motorcycle` will represent the derived child classes for the `Vehicle` class.

- The Parking Lot will have Parking Spots for each Vehicle type. The `ParkingSpot` can be represented as an **abstract class** in the system. `CarParkingSpot` and `MotorcycleParkingSpot` will represent the derived child classes for the `ParkingSpot` class.

- Multiple Display Boards will exist in the Parking Lot to display the availability of each parking slot type. `DisplayBoard` can be represented as a simple **class**.

- A Parking Ticket keeps track of the entrance and exit times of the vehicles, the amount, and the payment status. `ParkingTicket` can be represented as a simple **class**.

- `Payment` can be done using `Cash` or `Card`. `Payment` can be represented as an **abstract class**. `Cash` and `Card` will represent the derived child classes for the `Payment class`.

**Relationships:**

- Each `Vehicle` **will HAVE** a `ParkingSpot` assigned to it. The `ParkingSpot` has a **one-way association** with `Vehicle`.

- Each `ParkingTicket` **will HAVE** a `Vehicle` assigned to it. The `Vehicle` has a **one-way association** with `ParkingTicket`.

- `Car` and `Motorcycle` **IS a** type of `Vehicle`. `Car` and `Motorcycle` are inherited from the `Vehicle` abstract class.

- `Cash` and `Card` **IS a** mode of `Payment`. `Cash` and `Card` are inherited from the `Payment` abstract class.

## Sequence Diagram

## Activity Diagram

## EXTRA

**Q. How Payment System at parking lot works?**

- Different vehicle types will be charged differently. Will the pricing be same for different vehicle types?
- Should we charge different rates for each hour?

**Q. How to keep track of available parking spots?**

- Parking lot could have multiple floors.
- The parking lot should have a display board that shows free parking spots for each parking spot type.

**Q. How will capacity be allocated for different vehicle types?**
