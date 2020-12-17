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

@Entity
@Table(name = "agent", indexes = {
     @Index(name = "agentUniqueIdIndex", columnList = "aid", unique = true) 
    })
@NamedQueries({
    @NamedQuery(name = "Agent.findAgentByAgentId",query = "SELECT a FROM AgentEntity AS a WHERE a.aid = :aid")
    })
public class AgentEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "agentSeq", sequenceName = "agent_pk_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "agentSeq")
    private Long agent_pk;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private FarmerEntity farmer;
        
    @Column(name =  "aid", unique = true) 
    private String aid; // Agent id

    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "delivery_address", nullable = true)
    private String deliveryAddress;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "identity_number",nullable = true)
    private String identityNumber;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "physical_address", nullable = true)
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
   
    public AgentEntity() {

    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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
 
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getAgent_pk() {
        return agent_pk;
    }

    public void setAgent_pk(Long agent_pk) {
        this.agent_pk = agent_pk;
    }

    public FarmerEntity getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerEntity farmer) {
        this.farmer = farmer;
    }

}
