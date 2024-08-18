# Understanding Time Slicing

When there are more threads than processors, concurrency is simulated by time slicing, which means that the processor switches between threads.

On most systems, time slicing happens unpredictably and nondeterministically, meaning that a thread may be paused or resumed at any time.
