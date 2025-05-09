
A **stack** is the ideal data structure here because it follows the **Last-In-First-Out (LIFO)** principle, which naturally mirrors how **folder navigation works**:

|Operation|What It Means|Stack Behavior|
|---|---|---|
|`"x/"`|Move into a folder|`push("x/")` onto the stack|
|`"../"`|Go up one folder level|`pop()` the last folder from the stack|
|`"./"`|Stay in the current directory|Do nothing|
