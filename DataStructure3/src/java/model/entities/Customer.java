package model.entities;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * this is class define Customer
 */
public class Customer {

    private String ccode;
    private String cusName;
    private String phone;


    public String getCcode() {
        return ccode;
    }

  
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCusName() {
        return cusName;
    }

   
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

   
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
