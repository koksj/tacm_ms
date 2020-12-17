package za.co.tacm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "product", indexes = { @Index(name = "productUniqueIdIndex", columnList = "product_code", unique = true) })
@NamedQueries({
        @NamedQuery(name = "Product.findProductByProductCode", query = "SELECT p FROM ProductEntity p WHERE p.productCode = :productCode"),
        @NamedQuery(name = "Product.findProductsByFarmer", query = "SELECT p FROM ProductEntity AS p WHERE  p.farmer = :farmer") })
public class ProductEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(ProductEntity.class);

    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "product_pk_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "productSeq")
    private Long poduct_pk;

    @Column(name = "product_code")
    private String productCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private FarmerEntity farmer;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "crop_information")
    private String cropInformation;

    @Column(name = "grade")
    private String grade;

    @Column(name = "variety")
    private String variety;

    @Column(name = "size")
    private String size;

    @Column(name = "weight_per_packing")
    private String weightPerPacking;

    @Column(name = "quantity_available")
    private String quantityAvailable;

    @Column(name = "date_qty_available")
    private String dateQtyAvailable;

    @Column(name = "addititonal_comment")
    private String addititonalComment;

    public ProductEntity() {
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

    public FarmerEntity getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerEntity farmer) {
        this.farmer = farmer;
    }

    @Override
    public String toString() {

        if (getFarmer() == null) {
            log.info("Farmer is null ");
        } else {
            log.info("Farmer:  " + getFarmer().getFirstName());
        }

        return "Product [productCode=" + productCode + ", productDescription=" + productDescription + "]";
    }

    public Long getPoduct_pk() {
        return poduct_pk;
    }

    public void setPoduct_pk(Long poduct_pk) {
        this.poduct_pk = poduct_pk;
    }

}