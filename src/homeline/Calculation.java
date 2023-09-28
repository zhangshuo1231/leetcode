package homeline;

import homeline.model.Event;
import homeline.model.EventType;
import homeline.model.State;

import java.time.LocalDate;
import java.util.*;

public class Calculation {
    public static void main(String[] args) {
        System.out.println("Hi Shawn");
        LocalDate start = LocalDate.parse("2022-11-30");
        LocalDate end = LocalDate.parse("2023-01-06");

        LocalDate curr = start;
        State state = new State(864729.09f, 5.05f, 0.0f);

        List<Event> list = new ArrayList<>();


        list.add(new Event(LocalDate.parse("2022-12-06"), EventType.PRE_PAY, 0.0f, 370000.0f, 0.0f));
        list.add(new Event(LocalDate.parse("2022-12-07"), EventType.SET_RATE, 0.0f, 0.0f, 5.55f));
        list.add(new Event(LocalDate.parse("2022-12-14"), EventType.PRE_PAY, 0.0f, 420000.0f, 0.0f));
        list.add(new Event(LocalDate.parse("2022-12-14"), EventType.REGULAR, 1676.65f, 0.0f, 0.0f));
        list.add(new Event(LocalDate.parse("2022-12-27"), EventType.PRE_PAY, 0.0f, 420000.0f, 0.0f));
        list.add(new Event(LocalDate.parse("2022-12-29"), EventType.REGULAR, 1676.65f, 0.0f, 0.0f));
        int evtIdx = 0;
        // list.sort(Comparator.comparing(Event::getDate));

        while (curr.isBefore(end)) {
            if (evtIdx < list.size() && curr.isEqual(list.get(evtIdx).getDate())) {
                switch (list.get(evtIdx).getType()) {
                    case REGULAR:
                        Utils.regularPay(state, list.get(evtIdx).getRegular_payment());
                        System.out.println(curr + ": " + state);
                        break;
                    case PRE_PAY:
                        Utils.prePay(state, list.get(evtIdx).getPrepay_payment());
                        System.out.println(curr + ": " + state);
                        break;
                    case SET_RATE:
                        Utils.setRate(state, list.get(evtIdx).getNewRate());
                        System.out.println(curr + ": " + state);
                        break;
                    default:
                        throw new RuntimeException("EventType invalid");
                }
                evtIdx++;
            }

            if (evtIdx == 0 || evtIdx == list.size() || !list.get(evtIdx).getDate().isEqual(list.get(evtIdx - 1).getDate())) {
                curr = curr.plusDays(1L);
                Utils.dayPass(state);
            }
        }
        System.out.println(curr + ": " + state);
    }
}
