package D.Repository;



import D.Entities.BaseEntity;
import D.MyConnection.PostgresConnection;

import java.sql.Connection;
import java.util.List;

public interface BaseRepository<T extends BaseEntity,I> {
    Connection connection= PostgresConnection.getInstance().getConnection();
I create(T t);
T findById(I id);
List<T> findAll();
void Update(T t);
void Delete(I id);
}
