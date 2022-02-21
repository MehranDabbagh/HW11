package D.Repository;

import D.Entities.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity,I> {
void create(T t);
T findById(I id);
List<T> findAll();
void Update(T t);
void Delete(T t);
}
