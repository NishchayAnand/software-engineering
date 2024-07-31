# Understanding MongoDB

MongoDB is a document database. Document databases reverted back to the hierarchical model in one aspect: **storing nested records (one-to-many relationships) within their parent record than in a separate table.**

However, when it comes to representing **many-to-one** and **many-to-many** relationships, relational and document databases are not fundamentally different. In both cases, the related item is referenced by a unique identifier, which is called a `foreign key` in the relational model and a `document reference` in the document model. That identifier is resolved at read time by using a join or follow-up queries.

The main arguments in favor of the document data model are:

- **Schema Flexibility**
- Better performance due to **Locality**
- **Closeness to the data structures used by some applications**.

## When to use Document Model?

If the data in your application has a document-like structure (i.e., a tree of one-to-many relationships, where typically the entire tree is loaded at once), then it’s probably a good idea to use a document model.

The relational technique of splitting a document-like structure into multiple tables (e.g. Likes, Shares, Comments) can lead to cumbersome schemas and unnecessarily complicated application code.

A document is stored as a single continuous string, encoded as JSON, XML, or a binary variant thereof (such as MongoDB's BSON). If your application often needs to access the entire document (e.g. render it on a web page), there is a performance advantage to this **storage locality**. The locality advantage only applies if you need large parts of the document at the same time. The database typically needs to load the entire document, even if you access only a small portion of it, which can be wasteful on large documents.

**CRUX: Document databases target use cases where data comes in self-contained documents and relationships between one document and another are rare.**

## Limitations

- **You cannot refer directly to a nested item within a document.** For example, to get the list of `Comment` on a `Thread`, we need to get the owner (`User`) of the `Thread`, then find the required `Thread`, and finally get the list of `Comment` on that `Thread` (much like an access path in the hierarchical model). Also, in document model, to get the list of comments posted by a `User` would be a complicated operation, we may need to loop through each `User`, then each of their `Thread`, then loop over each `Comment` and check if the `Comment` is done by the required `User`. In relational model, each ay have a separate table `Comment` allowing us to easily query the list of `Commnet` done by the required `User`.

  ```
  User(userId)
        - List of Threads(threadId, userId -> owner of the thread)
            - List of Comments(commentId, threadId, userId -> not the owner of the thread)
  ```

- The poor support for joins in document databases may or may not be a problem, depending on the application. For example, **many-to-many relationships may never be needed in an analytics application that uses a document database to record which events occurred at which time.** However, if your application does use **many-to-many relationships (Students and Courses)**, the document model becomes less appealing. It’s possible to reduce the need for joins by denormalizing, but then the application code needs to do additional work to keep the denormalized data consistent. Joins can be emulated in application code by making multiple requests to the database, but that also moves complexity into the application and is usually slower than a join performed by specialized code inside the database. In such cases, using a document model can lead to significantly more complex application code and worse performance.

- On updates to a document, the entire document usually needs to be rewritten (only modifications that don’t change the encoded size of a document can easily be performed in place). For these reasons, it is generally recommended that you keep documents fairly small and avoid writes that increase the size of a document.

## EXTRA

- MongoDB is a transactional database which means you means you can use mongoDB for your transactional applications.

- Some MongoDB drivers automatically resolve database references (effectively performing a client-side join, although this is likely to be slower than a join performed in the database since it requires additional network round-trips and is less optimized).
