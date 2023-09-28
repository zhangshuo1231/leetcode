package homeline;

import homeline.model.State;

public class Utils {
    public static void dayPass(State curr) {
        if (curr.getPrincipal() <= 0.0f) throw new RuntimeException("Paid off!");
        float oneDayInterest = curr.getPrincipal() * curr.getRate() / 100.0f / 365.0f;
        curr.setInterest(curr.getInterest() + oneDayInterest);
    }

    public static void regularPay(State curr, float payment) {
        float currInterest = curr.getInterest();
        if (payment < currInterest) throw new RuntimeException("Payment must cover interest");
        curr.setPrincipal(curr.getPrincipal() - (payment - currInterest));
        curr.setInterest(0.0f);
    }

    public static void prePay(State curr, float payment) {
        curr.setPrincipal(curr.getPrincipal() - payment);
    }

    public static void setRate(State curr, float newRate) {
        curr.setRate(newRate);
    }
}
