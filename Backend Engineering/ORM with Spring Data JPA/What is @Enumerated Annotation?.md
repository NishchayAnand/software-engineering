
This annotation tells JPA **how to persist your enum value** into the database.

There are two strategies:

|Strategy|Stored in DB|Example|
|---|---|---|
|`EnumType.ORDINAL`|The enum’s index (integer)|`0`, `1`, `2`|
|✅ `EnumType.STRING`|The enum’s name (string)|`"SINGLE"`, `"DOUBLE"`|

✅ **Why STRING is better:**  
If you reorder or add enum constants later, the stored values won’t break — whereas ORDINAL would store numbers that could get mismatched.