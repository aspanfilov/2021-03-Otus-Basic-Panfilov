package P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries;

import P10_NumbersInWords.ru.otus.services.Lang;

import java.util.HashMap;
import java.util.Map;

public class TensDictionary {

    private Map<Integer, String> tens;

    public TensDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadTensDictionaryRussian();
            case ENGLISH -> loadTensDictionaryEnglish();
            default -> throw new IllegalArgumentException("There is no tens dictionary loader for lang " + lang);
        }
    }

    private void loadTensDictionaryRussian() {
        this.tens = new HashMap<>();
        this.tens.put(2, "двадцать");
        this.tens.put(3, "тридцать");
        this.tens.put(4, "сорок");
        this.tens.put(5, "пятьдесят");
        this.tens.put(6, "шестьдесят");
        this.tens.put(7, "семьдесят");
        this.tens.put(8, "восемьдесят");
        this.tens.put(9, "девяносто");
    }

    private void loadTensDictionaryEnglish() {
        this.tens = new HashMap<>();
        this.tens.put(2, "twenty");
        this.tens.put(3, "thirty");
        this.tens.put(4, "forty");
        this.tens.put(5, "fifty");
        this.tens.put(6, "sixty");
        this.tens.put(7, "seventy");
        this.tens.put(8, "eighty");
        this.tens.put(9, "ninty");
    }

    public String getTenNameByDigit(int digit) {
        if (digit == 0) return "";

        String tenName = this.tens.get(digit);
        if (tenName == null) {
            String msg = "digit " + digit + " was not found among tens";
            throw new IndexOutOfBoundsException(msg);
        }
        return tenName;
    }

    public String getTenNameByNumber(int number) {
        int digit = number / 10;
        return getTenNameByDigit(digit);
    }
}
