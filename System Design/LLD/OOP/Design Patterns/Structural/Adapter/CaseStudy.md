# Use Case: Duck-Turkey

We have Ducks and Turkeys. Let's say we are short on Ducks and would like to use some Turkey in their place.

## Interfaces and their Implementations

1. Duck: `MallardDuck`
2. Turkey: `WildDuck`

## Requirement

Let `Turkey` be treated like a `Duck`.

## Solution

Create a `TurkeyAdapter` that adapts the `Turkey` object (adaptee interface) to behave like a `Duck` object (target interface).

> **NOTE:** The Adaptor will implement the target interface and hold the reference of the Adaptee interface.

The `Turkey` class does not have the same methods as `Duck`, but the Adapter can take duck method calls and turn around and invoke methods on the `Turkey` class.
