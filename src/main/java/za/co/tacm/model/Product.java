package za.co.tacm.model;

import java.io.Serializable;

public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String farmer_id;
    private String productCode;        
    private String productDescription;
    private String cropInformation;
    private String grade;
    private String variety;
    private String size;
    private String weightPerPacking;
    private String quantityAvailable;
    private String dateQtyAvailable;
    private String addititonalComment;

    public Product() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCropInformation() {
        return cropInformation;
    }

    public void setCropInformation(String cropInformation) {
        this.cropInformation = cropInformation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeightPerPacking() {
        return weightPerPacking;
    }

    public void setWeightPerPacking(String weightPerPacking) {
        this.weightPerPacking = weightPerPacking;
    }

    public String getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(String quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getDateQtyAvailable() {
        return dateQtyAvailable;
    }

    public void setDateQtyAvailable(String dateQtyAvailable) {
        this.dateQtyAvailable = dateQtyAvailable;
    }

    public String getAddititonalComment() {
        return addititonalComment;
    }

    public void setAddititonalComment(String addititonalComment) {
        this.addititonalComment = addititonalComment;
    }

    public String getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }
}