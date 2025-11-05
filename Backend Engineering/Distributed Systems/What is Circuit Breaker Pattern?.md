
The CircuitBreaker uses a sliding window to store and aggregate the outcome of calls. You can choose between a count-based sliding window and a time-based sliding window. The count-based sliding window aggregates the outcome of the last N calls. The time-based sliding window aggregates the outcome of the calls of the last N seconds.

The state of the CircuitBreaker changes from `CLOSED` to `OPEN` when the failure rate is equal or greater than a configurable threshold. For example when more than 50% of the recorded calls have failed.

The CircuitBreaker also changes from `CLOSED` to `OPEN` when the percentage of slow calls is equal or greater than a configurable threshold. For example when more than 50% of the recorded calls took longer than 5 seconds. This helps to reduce the load on an external system before it is actually unresponsive.

> **NOTE:** The failure rate and slow call rate can only be calculated, if a minimum number of calls were recorded. For example, if the minimum number of required calls is 10, then at least 10 calls must be recorded, before the failure rate can be calculated. If only 9 calls have been evaluated the CircuitBreaker will not trip open even if all 9 calls have failed.

---

