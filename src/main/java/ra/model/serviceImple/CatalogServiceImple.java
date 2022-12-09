package ra.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.DAO.ICatalogDAO;
import ra.model.entity.Catalog;
import ra.model.service.ICatalogService;

import java.util.List;
@Service
public class CatalogServiceImple implements ICatalogService<Catalog,Integer> {
    @Autowired
    private ICatalogDAO catalogDAO;
    @Override
    public List<Catalog> searchByName(String searchName) {
        return catalogDAO.searchByName(searchName);
    }

    @Override
    public List<Catalog> getCatalogForCreate() {
        return catalogDAO.getCatalogForCreate();
    }

    @Override
    public List<Catalog> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public Catalog getByID(Integer id) {
        return (Catalog) catalogDAO.getByID(id);
    }

    @Override
    public boolean insert(Catalog catalog) {
        return catalogDAO.insert(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDAO.update(catalog);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDAO.delete(id);
    }
}