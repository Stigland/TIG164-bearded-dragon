package com.example.leand.tig164_beardeddragon.Contacts;

/**
 * Created by edvin on 2016-05-04.
 */
public class Contact {

    private int contactID;
    private String name;
    private String email;
    private String messengerURI;
    private String phone;

    public Contact(int contactID, String name, String email, String messengerURI, String phone){

        super();
        this.contactID = contactID;
        this.name = name;
        this.email = email;
        this.messengerURI = messengerURI;
        this.phone = phone;

    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessengerURI() {
        return messengerURI;
    }

    public void setMessengerURI(String messengerURI) {
        this.messengerURI = messengerURI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}