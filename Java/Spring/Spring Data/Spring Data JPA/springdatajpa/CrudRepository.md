# Understanding CrudRepository

```
public interface CrudRepository<T, ID> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    <S extends T> Iterables<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    void deleteById(ID id);

}
```
