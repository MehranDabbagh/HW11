package D.Service;

import D.Entities.BaseEntity;

import java.util.List;

public interface BaseService <T extends BaseEntity,I>{
    boolean login(T t);
    I create (T t);
    T findById(I id);
    List<T> findAll();
    void Update(T t);
    void Delete(I id);
}
