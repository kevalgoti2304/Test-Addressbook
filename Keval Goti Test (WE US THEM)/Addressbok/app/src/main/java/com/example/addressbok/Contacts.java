package com.example.addressbok;

public class Contacts {

    int id;
    String name;
    String mail;
    String phonenumber;
    String contacttype;

    public Contacts() {
    }

    public Contacts(int id, String name, String mail, String phonenumber, String contacttype) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phonenumber = phonenumber;
        this.contacttype = contacttype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype;
    }
}
