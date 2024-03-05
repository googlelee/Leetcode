import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (minQueue.isEmpty()) {
            minQueue.add(num);
        } else {
            if (minQueue.size() >= maxQueue.size()) {
                if (maxQueue.isEmpty()) {
                    if (num > minQueue.peek()) {
                        minQueue.add(num);
                        maxQueue.add(minQueue.poll());
                    } else {
                        maxQueue.add(num);
                    }
                }else if (num < maxQueue.peek()) {
                    maxQueue.add(num);
                } else {
                    minQueue.add(num);
                    maxQueue.add(minQueue.poll());
                }
            } else {
                if (num > minQueue.peek()) {
                    minQueue.add(num);
                } else {
                    maxQueue.add(num);
                    minQueue.add(maxQueue.poll());
                }
            }
        }

    }

    public double findMedian() {
        double res;
        if ((minQueue.size() + maxQueue.size()) % 2 == 0) {
            res = ((double) (minQueue.peek() + maxQueue.peek())) / 2.0;
        } else {
            if (maxQueue.size() > minQueue.size()) res = maxQueue.peek();
            else res = minQueue.peek();
        }
        return res;
    }
}
