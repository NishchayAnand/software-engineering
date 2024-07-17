# Understanding Sorting in Python

In Python, the `sorted()` function is used to sort iterable objects (like lists, tuples, strings, etc.).

## Basic Usage

```
numbers = [5, 2, 9, 1, 5, 6]
sorted_numbers = sorted(numbers)
print(sorted_numbers)  # Output: [1, 2, 5, 5, 6, 9]
```

## Sort in Reverse Order

```
numbers = [5, 2, 9, 1, 5, 6]
sorted_numbers_desc = sorted(numbers, reverse=True)
print(sorted_numbers_desc)  # Output: [9, 6, 5, 5, 2, 1]
```

## Sorting by Key

You can use the `key` parameter to sort by a specific criterion. For example, sort files in a directory based on the last modified date.

```
directory_path = 'C:\sampleFiles'
file_list = os.listdir(directory_path)
sorted_file_list = sorted(file_list, key = lambda x : os.path.getmtime(os.path.join(directory_path, x)) )
```
