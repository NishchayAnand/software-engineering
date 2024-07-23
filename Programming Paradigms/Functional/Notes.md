# Understanding Functional Programming Paradigm

- **perspective:** treat computation as the evaluation of mathematical functions.

- **assumptions:** data is immutable, and computations are based solely on input and output, with no side effects.

- **goal:** minimize mutable state and side effects, making programs more predictable, maintainable, and parallelizable.

- **Sample Syntax:** `numberlist.stream().filter(x -> x%2 == 0).forEach(x -> system.out.println(x))`
