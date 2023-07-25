package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean {

    private int price;

    public Pepsi() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pepsi [" +
                "price=" + price +
                ']';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Taking Pepsi: init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("going back to shop to return the bottle: destroy");
    }
}
