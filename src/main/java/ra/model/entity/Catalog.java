package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Catalog {
    private int catalogID;
    private String catalogName;
    private String catalogDescription;
    private int catalogParentID;
    private String catalogParentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date catalogCreateDate;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogID, String catalogName, String catalogDescription, int catalogParentID, String catalogParentName, Date catalogCreateDate, boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.catalogDescription = catalogDescription;
        this.catalogParentID = catalogParentID;
        this.catalogParentName = catalogParentName;
        this.catalogCreateDate = catalogCreateDate;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public int getCatalogParentID() {
        return catalogParentID;
    }

    public void setCatalogParentID(int catalogParentID) {
        this.catalogParentID = catalogParentID;
    }

    public String getCatalogParentName() {
        return catalogParentName;
    }

    public void setCatalogParentName(String catalogParentName) {
        this.catalogParentName = catalogParentName;
    }

    public Date getCatalogCreateDate() {
        return catalogCreateDate;
    }

    public void setCatalogCreateDate(Date catalogCreateDate) {
        this.catalogCreateDate = catalogCreateDate;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
