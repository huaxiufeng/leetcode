package algorithm.java;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by huaxiufeng on 19/1/7.
 */
public class LC284PeekingIterator {

    static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iter;
        private Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            if (iter.hasNext()) {
                next = iter.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer result = next;
            if (iter.hasNext()) {
                next = iter.next();
            } else {
                next = null;
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }

    public static void main(String[] args) {
        PeekingIterator solution = new PeekingIterator(Arrays.asList(1, 2, 3, 4, 5).iterator());
        while (solution.hasNext()) {
            System.out.println(solution.peek());
            System.out.println(solution.next());
        }
    }
}
