# Understanding Repository Interface

The central interface astracting the Spring Data repository is named exactly `Repository<T, ID>`.

The `Repository` interface is a marker interface. It is an interface with no methods to be implemented and defines no constants. It just marks the object so that the compiler and JVM have the additional information.
