
Throw a domain exception (e.g., `PaymentFailedException`) instead of silently returning a failed DTO from the service. That keeps service behavior explicit, lets `ControllerAdvice` map it to the correct HTTP status, and centralizes error handling.

If the intent of the method is **“create a payment order”** and you discover that the **payment is already confirmed**, the _best course of action_ is: **Return a normal success response indicating the payment is already confirmed — _not_ throw an exception.**

