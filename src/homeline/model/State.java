package homeline.model;

public class State {
    float principal;
    float rate;
    float interest;

    public State(float principal, float rate, float interest) {
        this.principal = principal;
        this.rate = rate;
        this.interest = interest;
    }

    public float getPrincipal() {
        return principal;
    }

    public void setPrincipal(float principal) {
        this.principal = principal;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "State{" +
                "principal=" + principal +
                ", rate=" + rate +
                ", interest=" + interest +
                '}';
    }
}
