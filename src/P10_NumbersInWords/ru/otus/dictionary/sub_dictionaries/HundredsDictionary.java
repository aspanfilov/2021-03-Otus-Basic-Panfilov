package P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries;

import P10_NumbersInWords.ru.otus.services.Lang;

import java.util.HashMap;
import java.util.Map;

public class HundredsDictionary {

    private Map<Integer, String> hundreds;

    public HundredsDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadHundredsDictionaryRussian();
            case ENGLISH -> loadHundredsDictionaryEnglish();
            default -> throw new IllegalArgumentException("There is no tens dictionary loader for lang " + lang);
        }
    }

    private void loadHundredsDictionaryRussian() {
        this.hundreds = new HashMap<>();
        this.hundreds.put(1, "сто");
        this.hundreds.put(2, "двести");
        this.hundreds.put(3, "триста");
        this.hundreds.put(4, "четыреста");
        this.hundreds.put(5, "пятьсот");
        this.hundreds.put(6, "шестьсот");
        this.hundreds.put(7, "семьсот");
        this.hundreds.put(8, "восемьсот");
        this.hundreds.put(9, "девятьсот");
    }

    private void loadHundredsDictionaryEnglish() {
        this.hundreds = new HashMap<>();
        this.hundreds.put(1, "one hundred");
        this.hundreds.put(2, "two hundreds");
        this.hundreds.put(3, "three hundreds");
        this.hundreds.put(4, "four hundreds");
        this.hundreds.put(5, "five hundreds");
        this.hundreds.put(6, "six hundreds");
        this.hundreds.put(7, "seven hundreds");
        this.hundreds.put(8, "eight hundreds");
        this.hundreds.put(9, "nine hundreds");
    }

    public String getHundredNameByDigit(int digit) {
        if (digit == 0) return "";

        String hundredName = this.hundreds.get(digit);
        if (hundredName == null) {
            String msg = "digit " + digit + " was not found among hundreds";
            throw new IndexOutOfBoundsException(msg);
        }
        return hundredName;
    }

    public String getHundredNameByNumber(int number) {
        int digit = number / 100;
        return getHundredNameByDigit(digit);
    }

}
