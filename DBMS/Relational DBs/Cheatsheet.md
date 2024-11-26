# RDBMS Cheatsheet

- `Normalization`: process of organizing data in database.

- `Prime Attributes`: uniquely identify a row in a table -> play crucial role in connecting data.

- `Non-prime Attributes`: provide descriptive characteristics to an entity -> main purpose is to add details.

- `1NF`:

  1. using row order to convey information is not permitted.
  2. mixing data types within the same column is not permitted.
  3. having a table without a primary key is not permitted.
  4. repeating groups are not permitted.

- `2NF`:

  1. each non-key attribute must depend on the entire primary key, not to .

- `3NF`:
