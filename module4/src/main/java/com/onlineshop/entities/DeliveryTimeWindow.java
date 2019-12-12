package com.onlineshop.entities;

import java.time.LocalDate;

public class DeliveryTimeWindow {

    private LocalDate start;
    private LocalDate end;

    public DeliveryTimeWindow(LocalDate start, LocalDate end){
        this.start = start;
        this.end = end;
    }

    private DeliveryTimeWindow(){
        LocalDate now = LocalDate.now();
        this.start = now;
        this.end = now;
    }


    public static DeliveryTimeWindow deliveryTimeWindow(){
        return new DeliveryTimeWindow();
    }

    public DeliveryTimeWindow startInDays(int daysNum) {
        this.start = getStart().plusDays(daysNum);
        return this;
    }

    public DeliveryTimeWindow endInDays(int daysNum) {
        this.end = getEnd().plusDays(daysNum);
        return this;
    }

    public void setStart(LocalDate start){
        this.start = start;
    }

    public void setEnd(LocalDate end){
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }



}
