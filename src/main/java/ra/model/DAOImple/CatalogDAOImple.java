package ra.model.DAOImple;

import org.springframework.stereotype.Repository;
import ra.model.DAO.ICatalogDAO;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CatalogDAOImple implements ICatalogDAO<Catalog, Integer> {
    @Override
    public List<Catalog> searchByName(String searchName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listSearchCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchCatalogByName(?)}");
            callSt.setString(1, searchName);
            ResultSet rs = callSt.executeQuery();
            listSearchCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogID"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCatalogParentID(rs.getInt("catalogParentId"));
                cat.setCatalogParentName(rs.getString("catalogParentName"));
                cat.setCatalogCreateDate(rs.getDate("catalogCreateDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listSearchCatalog.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listSearchCatalog;
    }

    @Override
    public List<Catalog> getCatalogForCreate() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalogForCreate = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getCatalogForCreat()}");
            ResultSet rs = callSt.executeQuery();
            listCatalogForCreate = new ArrayList<>();
            while (rs.next()) {
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                listCatalogForCreate.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCatalogForCreate;
    }

    @Override
    public int getEndPage() {
        Connection conn = null;
        CallableStatement callSt = null;
        int totalCat = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_countTotalCatalog()}");
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                totalCat = rs.getInt("count(*)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        int endPage = totalCat / 10;
        if (totalCat % 3 != 0) {
            endPage++;
        }
        return endPage;
    }

    @Override
    public List<Catalog> getListPagingCatalog(int index) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listPagingCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_phanTrang(?)}");
            callSt.setInt(1, (index - 1) * 10);
            ResultSet rs = callSt.executeQuery();
            listPagingCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogID"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCatalogParentID(rs.getInt("catalogParentId"));
                cat.setCatalogParentName(rs.getString("catalogParentName"));
                cat.setCatalogCreateDate(rs.getDate("catalogCreateDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listPagingCatalog.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listPagingCatalog;
    }

    @Override
    public int getEndPageForSearch(String searchName) {
        Connection conn = null;
        CallableStatement callSt = null;
        int totalCatSearch = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call Proc_countCatalogInListSearch(?)}");
            callSt.setString(1, searchName);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                totalCatSearch = rs.getInt("count(*)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        int endPage = totalCatSearch / 10;
        if (totalCatSearch % 10 != 0) {
            endPage++;
        }
        return endPage;
    }

    @Override
    public List<Catalog> getCatalogForSearchPages(String searchName, int index) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatForSearchPage = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_phanTrangSearch(?,?)}");
            callSt.setString(1,searchName);
            callSt.setInt(2,index);
            ResultSet rs = callSt.executeQuery();
            listCatForSearchPage = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogID"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCatalogParentID(rs.getInt("catalogParentId"));
                cat.setCatalogParentName(rs.getString("catalogParentName"));
                cat.setCatalogCreateDate(rs.getDate("catalogCreateDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listCatForSearchPage.add(cat);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCatForSearchPage;
    }

    @Override
    public List<Catalog> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAll()}");
            ResultSet rs = callSt.executeQuery();
            listCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog cat = new Catalog();
                cat.setCatalogID(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCatalogParentID(rs.getInt("catalogParentID"));
                cat.setCatalogParentName(rs.getString("catalogParentName"));
                cat.setCatalogCreateDate(rs.getDate("catalogCreateDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listCatalog.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCatalog;
    }

    @Override
    public Catalog getByID(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Catalog cat = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getCatalogByID(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            cat = new Catalog();
            if (rs.next()) {
                cat.setCatalogID(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogDescription(rs.getString("catalogDescription"));
                cat.setCatalogParentID(rs.getInt("catalogParentID"));
                cat.setCatalogParentName(rs.getString("catalogParentName"));
                cat.setCatalogCreateDate(rs.getDate("catalogCreateDate"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return cat;
    }

    @Override
    public boolean insert(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertCatalog(?,?,?,?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getCatalogDescription());
            callSt.setInt(3, catalog.getCatalogParentID());
            callSt.setDate(4, new Date(catalog.getCatalogCreateDate().getTime()));
            callSt.setBoolean(5, catalog.isCatalogStatus());
            callSt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateCatalog(?,?,?,?,?,?)}");
            callSt.setInt(1, catalog.getCatalogID());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getCatalogDescription());
            callSt.setInt(4, catalog.getCatalogParentID());
            callSt.setDate(5, new Date(catalog.getCatalogCreateDate().getTime()));
            callSt.setBoolean(6, catalog.isCatalogStatus());
            callSt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_deleteCatalog(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

}
