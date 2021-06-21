package P10_NumbersInWords.dictionary.sub_dictionaries;

import P10_NumbersInWords.services.Lang;
import P10_NumbersInWords.services.Gender;
import P10_NumbersInWords.services.GenderNumber;

import java.util.HashMap;
import java.util.Map;

public class DigitsDictionary {
    private Map<Integer, GenderNumber> digits;

    public DigitsDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadDigitsDictionaryRussian();
            case ENGLISH -> loadDigitsDictionaryEnglish();
            default -> throw new IllegalArgumentException("There is no digit dictionary loader for lang=" + lang);
        }
    }

    private void loadDigitsDictionaryRussian() {
        this.digits = new HashMap<>();
        this.digits.put(1, new GenderNumber("один", "одна", "одно"));
        this.digits.put(2, new GenderNumber("два", "две", "два"));
        this.digits.put(3, new GenderNumber("три", "три", "три"));
        this.digits.put(4, new GenderNumber("четыре", "четыре", "четыре"));
        this.digits.put(5, new GenderNumber("пять", "пять", "пять"));
        this.digits.put(6, new GenderNumber("шесть", "шесть", "шесть"));
        this.digits.put(7, new GenderNumber("семь", "семь", "семь"));
        this.digits.put(8, new GenderNumber("восемь", "восемь", "восемь"));
        this.digits.put(9, new GenderNumber("девять", "девять", "девять"));
    }

    private void loadDigitsDictionaryEnglish() {
        this.digits = new HashMap<>();
        this.digits.put(1, new GenderNumber("one", "one", "one"));
        this.digits.put(2, new GenderNumber("two", "two", "two"));
        this.digits.put(3, new GenderNumber("three", "three", "three"));
        this.digits.put(4, new GenderNumber("four", "four", "four"));
        this.digits.put(5, new GenderNumber("five", "five", "five"));
        this.digits.put(6, new GenderNumber("six", "six", "six"));
        this.digits.put(7, new GenderNumber("seven", "seven", "seven"));
        this.digits.put(8, new GenderNumber("eight", "eight", "eight"));
        this.digits.put(9, new GenderNumber("nine", "nine", "nine"));
    }

    public String getDigitName(int digit, Gender gender) {
        if (digit == 0) return "";

        GenderNumber genderNumber = this.digits.get(digit);
        if (genderNumber == null) {
            String msg = "number " + digit + " was not found among digits";
            throw new IndexOutOfBoundsException(msg);
        }
        return genderNumber.getGenderName(gender);
    }

}
