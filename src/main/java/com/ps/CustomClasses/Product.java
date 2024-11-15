package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;


public abstract class Product implements Pricing {
    protected String orderName;
    private List<AddOn> addOns;

    public Product(String name) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }


    public Product(String sandwhich, String drink, String bagOfChips, String orderName) {
        this.orderName = orderName;
        for (AddOn addOn : this.addOns = new ArrayList<>()) {

        }
    }

  public String getOrderName() {
       return orderName;
    }

   public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
    }

    public List<AddOn> getAddOns() {
        return this.addOns;
    }

    public void removeAddOn(AddOn addOn) {
        addOns.remove(addOn);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}



