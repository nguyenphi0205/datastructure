package model.entities;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * this class define the order
 */
public class Order {

    private String pcode;
    private String ccode;
    private int quantity;

   
    public String getPcode() {
        return pcode;
    }

  
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }


    public String getCcode() {
        return ccode;
    }

  
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

  
    public int getQuantity() {
        return quantity;
    }

  
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
