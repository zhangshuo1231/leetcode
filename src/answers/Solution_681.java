package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_681 {
    class Time {
        int hour;
        int min;
        Set<Character> set = new HashSet<>();

        Time() {}

        Time (String str) {
            String[] strs = str.split(":");
            this.hour = Integer.valueOf(strs[0]);
            this.min = Integer.valueOf(strs[1]);
            for (char c : str.toCharArray()) {
                set.add(c);
            }
        }

        Time next() {
            Time time = new Time();
            time.min = (this.min + 1) % 60;
            time.hour = time.min == 0 ? this.hour + 1 : this.hour;
            if (time.hour == 24) {
                time.hour = 0;
            }
            for (char c : time.toString().toCharArray()) {
                time.set.add(c);
            }
            return time;
        }

        boolean contains(Time another) {
            return this.set.containsAll(another.set);
        }

        @Override
        public String toString() {
            String hour = this.hour < 10 ? "0" + this.hour : "" + this.hour;
            String min = this.min < 10 ? "0" + this.min : "" + this.min;
            return hour + ":" + min;
        }
    }

    public String nextClosestTime(String time) {
        Time start = new Time(time);
        Time next = start.next();
        while (!start.contains(next)) {
            next = next.next();
        }
        return next.toString();
    }
}
