package answers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_295 {
    PriorityQueue<Integer> asc;
    PriorityQueue<Integer> dsc;

    public Solution_295() {
        asc = new PriorityQueue<>();
        dsc = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        dsc.add(num);
        asc.add(dsc.poll());
        if(asc.size()> dsc.size()){
            dsc.add(asc.poll());
        }
        System.out.println("asc: " + asc);
        System.out.println("dsc: " + dsc);
        System.out.println("---");
    }

    public double findMedian() {
        if(asc.size()== dsc.size())
            return (double) (dsc.peek() + asc.peek()) * 0.5 ;
        else
            return (double) dsc.peek();
    }
}
