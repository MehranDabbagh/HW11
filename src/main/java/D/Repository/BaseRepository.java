package D.Repository;



import java.util.List;

public interface BaseRepository<T ,I> {
void create(T t);
T findByUsername(I id);
List<T> findAll();
void Update(T t);
void Delete(T t);
}
