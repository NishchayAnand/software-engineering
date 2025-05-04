# Understanding Serializability

What we demand from a threadsafe data type is that when clients call its atomic operations concurrently, the results are consistent with some sequential ordering of the calls. This property is called serializability: for any set of operations executed concurrently, the result (the values and state observable by clients) must be a result given by some sequential ordering of those operations.
