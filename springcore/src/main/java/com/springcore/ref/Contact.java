package com.springcore.ref;

public class Contact {
    private long phone;
    private String email;
    private String address;

    public Contact() {
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
