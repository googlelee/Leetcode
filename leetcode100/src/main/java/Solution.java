import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}