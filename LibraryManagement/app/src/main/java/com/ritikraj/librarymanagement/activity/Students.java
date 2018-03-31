package com.ritikraj.librarymanagement.activity;

/**
 * Created by Ritik Raj Srivastava on 09-10-2017.
 */

public class Students {

    String id;
    String USN;
    String Name;
    String email;

    Students(){


    }

    public Students(String id,String email, String usn, String name) {
        this.id =id;
        this.USN = USN;
        Name = name;
        this.email = email;

    }

    public String getId()
    {
        return id;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
