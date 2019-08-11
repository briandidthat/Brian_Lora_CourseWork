package com.company;

/*Task:
 *
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private boolean isRewardsMember;
    private Address shippingAddress;
    private Address billingAddress;

    public Customer(String firstName, String lastName, String email, int phoneNumber, boolean isRewardsMember,
                    Address shippingAddress, Address billingAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isRewardsMember = isRewardsMember;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public Customer() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRewardsMember(boolean rewardsMember) {
        isRewardsMember = rewardsMember;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    // GETTERS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isRewardsMember() {
        return isRewardsMember;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

}
