package com.example.quoteapp;

import java.io.Serializable;

public class quote implements Serializable {
    private int id;
    private String Quotte;


    public quote(){   }

    public quote(int id, String Quotte){
        this.id = id;
        this.Quotte = Quotte;

    }

    public quote( String Quotte){
        this.Quotte = Quotte;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getquote(){
        return this.Quotte;
    }

    public void setquote(String Quotte){
        this.Quotte = Quotte;
    }


}
