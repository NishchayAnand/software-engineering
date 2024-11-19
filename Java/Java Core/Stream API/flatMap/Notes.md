# Understanding flatMap Operation

Used to transform each element of a stream into another stream, then flatten those streams into a single stream. 

Combines the effects of `map` and `flatten`:
- Each element is transformed into a new stream (via map).
- All resulting streams are merged into one (via flatten).

```
List<List<Integer>> listOfLists = List.of(
    List.of(1, 2, 3),
    List.of(4, 5),
    List.of(6, 7, 8)
);

List<Integer> flattenedList = listOfLists.stream()
                              .flatMap(List::stream) // Convert each list to a stream and flatten
                              .collect(Collectors.toList());

System.out.println(flattenedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8]
```