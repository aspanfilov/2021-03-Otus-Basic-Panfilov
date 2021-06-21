package P10_NumbersInWords.dictionary.sub_dictionaries;

import P10_NumbersInWords.services.Lang;
import P10_NumbersInWords.services.Gender;
import P10_NumbersInWords.services.CountObject;

import java.util.HashMap;
import java.util.Map;

public class NumberClassesDictionary {
    private Map<Integer, CountObject> numberClasses;

    public NumberClassesDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadNumberClassesRussian();
            case ENGLISH -> loadNumberClassesEnglish();
            default -> throw new IllegalArgumentException("There is no tens dictionary loader for lang " + lang);
        }
    }

    private void loadNumberClassesRussian() {
        this.numberClasses = new HashMap<>();

        this.numberClasses.put(1,
                new CountObject(Gender.FEMALE, "тысяча", "тысячи", "тысяч"));
        this.numberClasses.put(2,
                new CountObject(Gender.MALE, "миллион", "миллиона", "миллионов"));
        this.numberClasses.put(3,
                new CountObject(Gender.MALE, "миллиард", "миллиарда", "миллиардов"));
        this.numberClasses.put(4,
                new CountObject(Gender.MALE, "триллион", "триллиона", "триллионов"));
        this.numberClasses.put(5,
                new CountObject(Gender.MALE, "квадриллион", "квадриллиона", "квадриллионов"));
        this.numberClasses.put(6,
                new CountObject(Gender.MALE, "квинтиллион", "квинтиллиона", "квинтиллионов"));
        this.numberClasses.put(7,
                new CountObject(Gender.MALE, "секстиллион", "секстиллиона", "секстиллионов"));
    }

    private void loadNumberClassesEnglish() {
        this.numberClasses = new HashMap<>();

        this.numberClasses.put(1,
                new CountObject(Gender.MALE, "thousand", "thousands"));
        this.numberClasses.put(2,
                new CountObject(Gender.MALE, "million", "millions"));
        this.numberClasses.put(3,
                new CountObject(Gender.MALE, "billion", "billions"));
        this.numberClasses.put(4,
                new CountObject(Gender.MALE, "trillion", "trillions"));
        this.numberClasses.put(5,
                new CountObject(Gender.MALE, "quadrillion", "quadrillions"));
        this.numberClasses.put(6,
                new CountObject(Gender.MALE, "quintillion", "quintillions"));
        this.numberClasses.put(7,
                new CountObject(Gender.MALE, "sextillion", "sextillions"));
    }

    public CountObject getNumberClass(int numberClassId) {
        CountObject numberClass = this.numberClasses.get(numberClassId);
        if (numberClass == null) {
            String msg = "numberClasses.size: " + this.numberClasses.size() + " index: " + numberClassId;
            throw new IndexOutOfBoundsException(msg);
        }
        return numberClass;
    }

    public String getNumberClassName(int numberClassId, int formId) {
        CountObject numberClass = getNumberClass(numberClassId);
        return numberClass.getQuantitativeForm(formId);
    }

}
