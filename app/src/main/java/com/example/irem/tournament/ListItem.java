package com.example.irem.tournament;

import android.app.Activity;

/**
 * Created by cemdeniz on 5.07.2017.
 */

public class ListItem {


    private String head;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;
    public ListItem(String s){
        this.head=s;
    }

    public ListItem() {
    }

    public String getHead(){
        return head;
    }


}


