package lab01.tdd.filtered;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CircularListFilteredImpl implements CircularListFiltered {

    List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if (list.stream().filter(predicate).findFirst().isEmpty()) {
            return Optional.empty();
        } else {
            return list.stream().filter(predicate).findFirst();
        }
    }
}
