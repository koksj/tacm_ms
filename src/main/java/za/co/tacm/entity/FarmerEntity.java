package za.co.tacm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name =  "farmer", indexes = {
    @Index(name = "farmerUniqueIdIndex", columnList = "id", unique = true)
})
@NamedQueries({
    @NamedQuery(name = "Farmer.findFarmerById",query = "SELECT f FROM FarmerEntity AS f WHERE f.id = :id")
    })
public class FarmerEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;   

    @Id
    @SequenceGenerator(name = "farmerSeq", sequenceName = "farmer_pk_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "farmerSeq")
    private Long farmer_pk;

    @Column(name =  "id", unique = true)
    private String id; //The uuid  assosciated  with the farmer

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "identity_number",nullable = false)
    private String identityNumber;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "physical_address", nullable = false)
    private String physicalAddress;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "business_name", nullable = true)
    private String businessName;

    @Column(name = "company_registration_number", nullable = true)
    private String companyRegistrationNumber;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "office_number", nullable = true)
    private String officeNumber;

    @Column( name = "alternative_contact_number", nullable = true)
    private String alternativeContactNumber;

    @Column(name = "alternative_email_address", nullable =  true)
    private String alternativeEmailAddress;

    @Column(name = "vat_number", nullable = true)
    private String vatNumber;

    @Column(name = "primary_head_office_contact_number", nullable = true)
    private String primaryHeadOfficeContactNumber;

    @Column(name = "head_office_physical_address", nullable =  true)
    private String headOfficePhysicalAddress;

    @Column(name = "name_of_business_representative", nullable = true)
    private String nameOfBusinessRepresentative;

    @Column(name = "business_representative_contact_number", nullable = true )
    private String businessRepresentativeContactNumber;

    @Column(name = "business_representative_email_address", nullable = true)
    private String businessRepresentativeEmailAddress;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<AgentEntity> agents = new ArrayList<>();

    public FarmerEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getAlternativeContactNumber() {
        return alternativeContactNumber;
    }

    public void setAlternativeContactNumber(String alternativeContactNumber) {
        this.alternativeContactNumber = alternativeContactNumber;
    }

    public String getAlternativeEmailAddress() {
        return alternativeEmailAddress;
    }

    public void setAlternativeEmailAddress(String alternativeEmailAddress) {
        this.alternativeEmailAddress = alternativeEmailAddress;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPrimaryHeadOfficeContactNumber() {
        return primaryHeadOfficeContactNumber;
    }

    public void setPrimaryHeadOfficeContactNumber(String primaryHeadOfficeContactNumber) {
        this.primaryHeadOfficeContactNumber = primaryHeadOfficeContactNumber;
    }

    public String getHeadOfficePhysicalAddress() {
        return headOfficePhysicalAddress;
    }

    public void setHeadOfficePhysicalAddress(String headOfficePhysicalAddress) {
        this.headOfficePhysicalAddress = headOfficePhysicalAddress;
    }

    public String getNameOfBusinessRepresentative() {
        return nameOfBusinessRepresentative;
    }

    public void setNameOfBusinessRepresentative(String nameOfBusinessRepresentative) {
        this.nameOfBusinessRepresentative = nameOfBusinessRepresentative;
    }

    public String getBusinessRepresentativeContactNumber() {
        return businessRepresentativeContactNumber;
    }

    public void setBusinessRepresentativeContactNumber(String businessRepresentativeContactNumber) {
        this.businessRepresentativeContactNumber = businessRepresentativeContactNumber;
    }

    public String getBusinessRepresentativeEmailAddress() {
        return businessRepresentativeEmailAddress;
    }

    public void setBusinessRepresentativeEmailAddress(String businessRepresentativeEmailAddress) {
        this.businessRepresentativeEmailAddress = businessRepresentativeEmailAddress;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void addProduct(ProductEntity productEntity) {        
        this.products.add(productEntity);
        productEntity.setFarmer(this);
    }

    public void removeProduct(ProductEntity productEntity) {
        this.products.remove(productEntity);
        productEntity.setFarmer(null);
    }

    public void removeAgent(AgentEntity agentEntity) {
        this.agents.remove(agentEntity);
        agentEntity.setFarmer(null);
    }

    public Long getFarmer_pk() {
        return farmer_pk;
    }

    public void setFarmer_pk(Long farmer_pk) {
        this.farmer_pk = farmer_pk;
    }

    public List<AgentEntity> getAgents() {
        return agents;
    }

    public void setAgents(List<AgentEntity> agents) {
        this.agents = agents;
    }

}
