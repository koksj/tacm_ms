package za.co.tacm.model;

import java.io.Serializable;


public class Farmer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;   

    private String id;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String mobileNumber;
    private String physicalAddress;
    private String email;
    private String businessName;
    private String companyRegistrationNumber;
    private String province;
    private String officeNumber;
    private String alternativeContactNumber;
    private String alternativeEmailAddress;
    private String vatNumber;
    private String primaryHeadOfficeContactNumber;
    private String headOfficePhysicalAddress;
    private String nameOfBusinessRepresentative;
    private String businessRepresentativeContactNumber;
    private String businessRepresentativeEmailAddress;

    public Farmer() {
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

}
