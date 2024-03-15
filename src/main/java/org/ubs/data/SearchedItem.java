package org.ubs.data;

public class SearchedItem {

    public String price;
    public String descriptions;


    public String getPrice() {
        return price.replaceAll("-?[^\\d]", "");
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

}
