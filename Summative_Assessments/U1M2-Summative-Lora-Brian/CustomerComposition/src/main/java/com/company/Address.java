package com.company;

/*Task:
 *
 */
public class Address {
    private String street1;
    private String city;
    private String state;
    private int street2;
    private int zip;

    public Address(String street1, int street2, String city, String state, int zip) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }


    public void setStreet2(int street2) {
        this.street2 = street2;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet1() {
        return street1;
    }

    public int getStreet2() {
        return street2;
    }
    
    public String getCity() {
        return city;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
