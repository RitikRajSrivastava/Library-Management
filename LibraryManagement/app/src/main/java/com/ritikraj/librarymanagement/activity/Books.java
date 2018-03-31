package com.ritikraj.librarymanagement.activity;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

public class Books {

    String id;
    String name;
    int year;
    int quantity;

    Books()
    {

    }

    public Books(String id, String name, int year, int quantity) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }
}
