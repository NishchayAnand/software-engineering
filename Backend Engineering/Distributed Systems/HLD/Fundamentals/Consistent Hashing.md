# Consistent Hashing

To achieve horizontal scaling, it is important to distribute requests/data efficiently and evenly across servers. Consistent Hashing is a commonly used technique to achieve this goal.

Consistent Hashing is a special kind of hashing such that when a hash table is re-sized and consistent hashing is used, only `k/n` keys need to be remapped on average, where k is the number of keys, and n is the number of slots. **In contrast, in most traditional hash tables, a change in the number of array slots causes nearly all keys to be remapped.**
