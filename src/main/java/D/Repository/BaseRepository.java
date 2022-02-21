package D.Repository;

import java.util.List;

public interface BaseRepository<T,I> {
void create(T t);
T findById(I id);
List<T> findAll();

}
