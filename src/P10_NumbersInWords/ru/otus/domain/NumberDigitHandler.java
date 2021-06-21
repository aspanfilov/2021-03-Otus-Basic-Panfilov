package P10_NumbersInWords.ru.otus.domain;

public class NumberDigitHandler {

    public int getHighestDigitNumber(int number) {
        if (number > 99 && number < 1000) {
            return 3;
        } else if (number > 9) {
            return 2;
        } else if (number >= 0){
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteHighestDigit(int number) {
        if (number > 99) {
            return number % 100;
        } else if (number > 9) {
            return number % 10;
        } else {
            return 0;
        }
    }

}
