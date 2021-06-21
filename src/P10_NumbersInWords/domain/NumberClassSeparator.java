package P10_NumbersInWords.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberClassSeparator {

    public List<Integer> getNumbersByClass(long number) {
        List<Integer> numberGroupsByClasses = new ArrayList<>();
        while (number > 0) {
            numberGroupsByClasses.add((int) (number % 1000));
            number = number / 1000;
        }
        return numberGroupsByClasses;
    }

}
