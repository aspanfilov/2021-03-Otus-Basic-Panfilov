package P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries;

import P10_NumbersInWords.ru.otus.services.CountObject;
import P10_NumbersInWords.ru.otus.services.Lang;

import java.util.HashMap;
import java.util.Map;

public class CountObjectQuantitativeFormSelector {
    //число, номер множественной формы существительного применяемого для числа>
    private Map<Integer, Integer> quantitativeFormSelectRules;
    private int quantitativeFormCount;

    public CountObjectQuantitativeFormSelector(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadQuantitativeFormSelectRulesRussian();
            case ENGLISH -> loadQuantitativeFormSelectRulesEnglish();
            default -> throw new IllegalArgumentException("There is no quantitative form select rule for lang " + lang);
        }
    }

    private void loadQuantitativeFormSelectRulesRussian() {
        //Правила задаются для всех множественных форм существительных, кроме последней
        //Последняя форма подбирается методом исключения
        this.quantitativeFormCount = 3;
        this.quantitativeFormSelectRules = new HashMap<>();
        this.quantitativeFormSelectRules.put(1, 1);
        this.quantitativeFormSelectRules.put(2, 2);
        this.quantitativeFormSelectRules.put(3, 2);
        this.quantitativeFormSelectRules.put(4, 2);
    }

    private void loadQuantitativeFormSelectRulesEnglish() {
        this.quantitativeFormCount = 2;
        this.quantitativeFormSelectRules = new HashMap<>();
        this.quantitativeFormSelectRules.put(1, 1);
    }

    public int getQuantitativeFormId(int number) {
        Integer quantitativeFormId = this.quantitativeFormSelectRules.get(number);
        if (quantitativeFormId == null) {
            quantitativeFormId = this.quantitativeFormCount;
        }
        return quantitativeFormId;
    }

    public String getQuantitativeForm(CountObject countObject, int number) {
        if (countObject == null) {
            String msg = "count object is null";
            throw new IllegalArgumentException(msg);
        }
        int quantitativeFormId = getQuantitativeFormId(number);
        return countObject.getQuantitativeForm(quantitativeFormId);
    }
}
