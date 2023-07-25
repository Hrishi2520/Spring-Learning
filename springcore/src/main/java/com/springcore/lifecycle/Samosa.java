package com.springcore.lifecycle;

public class Samosa {

    private double price;

    public Samosa() {
    }

    public Samosa(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    First bean method init
    public void init(){
        System.out.println("Entered in init method: hey");
    }

//    second bean method destroy
    public void destroy(){
        System.out.println("Entered in destroy method: Bye Bye");
    }

    @Override
    public String toString() {
        return "Samosa [" +
                "price=" + price +
                ']';
    }
}
