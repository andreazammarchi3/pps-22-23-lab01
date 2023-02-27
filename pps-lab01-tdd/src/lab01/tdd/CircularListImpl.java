package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CircularListImpl implements CircularList {
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
    public Optional<Integer> next() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            position++;
            if (position == list.size()) {
                position = 0;
            }
            return Optional.ofNullable(list.get(position));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            position--;
            if (position <= -1) {
                position = list.size() - 1;
            }
            return Optional.ofNullable(list.get(position));
        }
    }

    @Override
    public void reset() {
        position = -1;
    }
}
