package lab01.tdd.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListIteratorImpl implements CircularListIterator {
    private final List<Integer> list = new ArrayList<>();
    private int position = -1;
    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                position++;
                if (position == list.size()) {
                    position = 0;
                }
                return list.get(position);
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                position--;
                if (position <= -1) {
                    position = list.size() - 1;
                }
                return list.get(position);
            }
        };
    }
}
