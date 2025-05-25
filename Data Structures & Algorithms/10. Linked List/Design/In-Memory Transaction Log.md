
Design an **in-memory transaction log** using a **singly linked list**, which supports the following operations:

You must implement a class `TransactionLog` with the following methods:

```
class TransactionLog:
    def add(self, command: str) -> None
    def rollback(self, steps: int) -> List[str]
    def get_current_log() -> List[str]
```

- `add(command: str)` — Adds a new command (e.g., "SET key value", "DELETE key") to the transaction log.
    
- `rollback(steps: int)` — Rolls back the last `steps` commands and removes them from the log. Returns a list of the **removed commands in reverse order** (most recent first).
    
- `get_current_log()` — Returns a list of the current commands in the log (from earliest to latest).
    
Your implementation must use a **singly linked list** internally to manage the transaction history.

---

## ✅ Constraints:

- All operations must run in **O(1)** or **O(k)** time, where `k` is the number of steps to rollback.
    
- `1 <= command.length <= 100`
    
- `0 <= steps <= current log size`
    
- Maximum of 10⁴ commands
    

---

## 📌 Example:

```
log = TransactionLog()

log.add("SET a 10")
log.add("SET b 20")
log.add("DELETE a")
log.add("INCR b")

log.rollback(2) 
# Returns ["INCR b", "DELETE a"]

log.get_current_log()
# Returns ["SET a 10", "SET b 20"]

log.add("INCR b")
log.get_current_log()
# Returns ["SET a 10", "SET b 20", "INCR b"]
```

---
## 🔍 Follow-Up:

- How would you handle nested transactions with support for **SAVEPOINTs**?
    
- Can you optimise space by using a doubly linked list or a command pool?

---
