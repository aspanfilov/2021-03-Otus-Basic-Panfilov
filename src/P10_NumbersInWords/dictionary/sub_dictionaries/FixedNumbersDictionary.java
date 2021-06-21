package P10_NumbersInWords.dictionary.sub_dictionaries;

import P10_NumbersInWords.services.Lang;

import java.util.HashMap;
import java.util.Map;

public class FixedNumbersDictionary {
    private Map<Integer, String> fixedNumbers;

    public FixedNumbersDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadFixedNumbersDictionaryRussian();
            case ENGLISH -> loadFixedNumbersDictionaryEnglish();
            default -> throw new IllegalArgumentException("There is no fixed numbers dictionary loader for lang " + lang);
        }
    }

    private void loadFixedNumbersDictionaryRussian() {
        this.fixedNumbers = new HashMap<>();
        this.fixedNumbers.put(10, "десять");
        this.fixedNumbers.put(11, "одиннадцать");
        this.fixedNumbers.put(12, "двенадцать");
        this.fixedNumbers.put(13, "тринадцать");
        this.fixedNumbers.put(14, "четырнадцать");
        this.fixedNumbers.put(15, "пятнадцать");
        this.fixedNumbers.put(16, "шестнадцать");
        this.fixedNumbers.put(17, "семнадцать");
        this.fixedNumbers.put(18, "восемнадцать");
        this.fixedNumbers.put(19, "девятнадцать");
    }

    private void loadFixedNumbersDictionaryEnglish() {
        this.fixedNumbers = new HashMap<>();
        this.fixedNumbers.put(10, "ten");
        this.fixedNumbers.put(11, "eleven");
        this.fixedNumbers.put(12, "twelve");
        this.fixedNumbers.put(13, "thirteen");
        this.fixedNumbers.put(14, "fourteen");
        this.fixedNumbers.put(15, "fifteen");
        this.fixedNumbers.put(16, "sixteen");
        this.fixedNumbers.put(17, "seventeen");
        this.fixedNumbers.put(18, "eighteen");
        this.fixedNumbers.put(19, "nineteen");
    }

    public String getFixedNumberName(int fixedNumber) {
        String fixedNumberName = this.fixedNumbers.get(fixedNumber);
        if (fixedNumberName == null) {
            fixedNumberName = "";
        }
        return fixedNumberName;
    }

}
