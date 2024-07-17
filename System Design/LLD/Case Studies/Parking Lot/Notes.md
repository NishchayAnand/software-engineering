# Design a Parking Lot System

A **parking lot** is a designated area for parking vehicles and is a feature found in almost all popular venues such as shopping malls, sports stadiums, offices, etc.

## General Observations

- A fixed number of parking spots are available for different vehicles types.
- Each vehicle is charged according to the time the vehicle has been parked in the parking lot.
- The parking time is tracked with the parking ticket issued to the vehicle at the entrance of the parking lot.
- Once the vehicle is ready to exit, it can either pay at the automatic exit panel or to the parking agent at the exit using a card or cash payment method.

## Use Case Diagram: A visual representation of how users interact with a system

## Requirements

- **What should be the capacity of the parking lot?** We can assume that the parking lot has the capacity to park 4000 vehicles (4 floors each with a capacity to park 1000 vehicles).

- **What different types of vehicles can the parking lot park?** We can assume that the parking lot can accomodate 2 types of vehicles: `Cars: SUVs, Sedans, Hatchbacks`, `Motorcycles`.

- **Does the parking lot has multiple entry and exit points?** We can assume that the parking lot has 2 entry points and 2 exit points.

## How Payment System at parking lot works?

- Different vehicle types will be charged differently. Will the pricing be same for different vehicle types?
- Should we charge different rates for each hour?

## How to keep track of available parking spots?

- Parking lot could have multiple floors.
- The parking lot should have a display board that shows free parking spots for each parking spot type.

## How will capacity be allocated for different vehicle types?
