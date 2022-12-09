package ra.model.DAO;

import java.util.List;

public interface ICatalogDAO<T,V> extends IShopDAO<T,V>{
    List<T> searchByName(String searchName);
    List<T> getCatalogForCreate();
}
