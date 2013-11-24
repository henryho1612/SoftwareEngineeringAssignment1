package vn.edu.rmit.common.model;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/23/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Drug {

    String name;
    int quantity;
    int length;

    public Drug (String name, int quantity, int length)
    {
        this.name = name;
        this.quantity = quantity;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString()
    {
        return name + "-" + quantity + "-" + length;
    }
}
