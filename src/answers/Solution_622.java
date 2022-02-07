package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_622 {
    List<Integer> list;
    int limit;
    int head, tail;
    int volume;

    public Solution_622(int k) {
        this.limit = k;
        this.volume = 0;
        this.list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(0);
        }
        this.head = this.tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        else {
            if (volume != 0) {
                tail = next(tail);
            }
            list.set(tail, value);
            volume++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        else {
            if (volume != 1) {
                head = next(head);
            }
            volume--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(head);
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(tail);
    }

    public boolean isEmpty() {
        return volume == 0;
    }

    public boolean isFull() {
        return volume >= limit;
    }

    private int next(int idx) {
        return (idx + 1) % limit;
    }
}
