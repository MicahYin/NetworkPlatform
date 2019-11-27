package com.guet.domain;

/**
 * @author MicahYin
 * @date 2019/11/27 15:14
 */
public class Department {
    private String id;
    private String departName;
    //单位类型
    private Role departType;

    private String address;
    private String departCharge;
    private String phone;
    private String SecurityOfficer;
    private String SecurityOfficerPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Role getDepartType() {
        return departType;
    }

    public void setDepartType(Role departType) {
        this.departType = departType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartCharge() {
        return departCharge;
    }

    public void setDepartCharge(String departCharge) {
        this.departCharge = departCharge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecurityOfficer() {
        return SecurityOfficer;
    }

    public void setSecurityOfficer(String securityOfficer) {
        SecurityOfficer = securityOfficer;
    }

    public String getSecurityOfficerPhone() {
        return SecurityOfficerPhone;
    }

    public void setSecurityOfficerPhone(String securityOfficerPhone) {
        SecurityOfficerPhone = securityOfficerPhone;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                ", departType=" + departType +
                ", address='" + address + '\'' +
                ", departCharge='" + departCharge + '\'' +
                ", phone='" + phone + '\'' +
                ", SecurityOfficer='" + SecurityOfficer + '\'' +
                ", SecurityOfficerPhone='" + SecurityOfficerPhone + '\'' +
                '}';
    }
}
