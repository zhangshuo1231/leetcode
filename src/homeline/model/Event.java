package homeline.model;

import java.time.LocalDate;

public class Event {
    LocalDate date;
    EventType type;
    float regular_payment;
    float prepay_payment;
    float newRate;

    public Event(LocalDate date, EventType type, float regular_payment, float prepay_payment, float newRate) {
        this.date = date;
        this.type = type;
        this.regular_payment = regular_payment;
        this.prepay_payment = prepay_payment;
        this.newRate = newRate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public float getRegular_payment() {
        return regular_payment;
    }

    public void setRegular_payment(float regular_payment) {
        this.regular_payment = regular_payment;
    }

    public float getPrepay_payment() {
        return prepay_payment;
    }

    public void setPrepay_payment(float prepay_payment) {
        this.prepay_payment = prepay_payment;
    }

    public float getNewRate() {
        return newRate;
    }

    public void setNewRate(float newRate) {
        this.newRate = newRate;
    }
}
