# Understanding Observer Design Pattern

-

The Observer pattern (GoF) allows multiple objects to receive notification of events concerning an "observable" object. This can sometimes achieve the same results as AOP. However, it doesn't offer around advice, such as executing a method within a transactional context created by an advice; objects need to publish events to support it, meaning that objects aren't oblivious of the necessary plumbing; and there's no way for observers to change the course of execution flow. The Observer pattern is valuable, but it's by no means a substitute for AOP.
