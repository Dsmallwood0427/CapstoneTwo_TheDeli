package com.ps.CustomClasses;

import java.util.ArrayList;
import java.util.List;


public abstract class Product implements Pricing {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}



