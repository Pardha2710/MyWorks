package com.example.mobileshopping;

import java.io.Serializable;

public class ListItem implements Serializable {
    private String plan;


    public ListItem(String paln) {
        this.plan = paln;

    }

    public String getPlan() {
        return plan;
    }


}
