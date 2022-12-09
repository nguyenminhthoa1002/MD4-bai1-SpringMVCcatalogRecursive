package ra.model.DAO;

import java.util.List;

public interface IShopDAO<T,V> {
    List<T> findAll();
    T getByID(V id);
    boolean insert(T t);
    boolean update(T t);
    boolean delete(V id);
}
