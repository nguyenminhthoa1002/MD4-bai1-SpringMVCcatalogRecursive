package ra.model.service;

import java.util.List;

public interface IShopService<T,V> {
    List<T> findAll();
    T getByID(V id);
    boolean insert(T t);
    boolean update(T t);
    boolean delete(V id);
}
