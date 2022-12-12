package ra.model.service;

import ra.model.entity.Catalog;

import java.util.List;

public interface ICatalogService<T,V> extends IShopService<T,V>{
    List<T> searchByName(String searchName);
    List<T> getCatalogForCreate();
    int getEndPage();
    List<Catalog> getListPagingCatalog(int index);
    int getEndPageForSearch(String searchName);
    List<Catalog> getCatalogForSearchPages(String searchName, int index);
}
