package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;


public abstract class Product implements Price {
    protected String name;
    private String sandwhich;
    private String drink;
    private String bagOfChips;
    private List<AddOn> addOns;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Product(String sandwhich, String drink, String bagOfChips, String orderName) {
        this.sandwhich = sandwhich;
        this.drink = drink;
        this.bagOfChips = bagOfChips;
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
    default double getPrice() {
        return 0;
    }
}



