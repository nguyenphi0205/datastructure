package model.entities;

/**
 *
 * @author : Pham Tuan Ngoc
 *
 * this is class define the Product
 */
public class Product {

    private String pcode;
    private String proName;
    private int quantity;
    private int saled;
    private double price;

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the saled
     */
    public int getSaled() {
        return saled;
    }

    /**
     * @param saled the saled to set
     */
    public void setSaled(int saled) {
        this.saled = saled;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
