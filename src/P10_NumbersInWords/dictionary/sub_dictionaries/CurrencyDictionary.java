package P10_NumbersInWords.dictionary.sub_dictionaries;

import P10_NumbersInWords.services.CountObject;
import P10_NumbersInWords.services.Currency;
import P10_NumbersInWords.services.Gender;
import P10_NumbersInWords.services.Lang;

import java.util.HashMap;
import java.util.Map;

public class CurrencyDictionary {
    private Map<Currency, CountObject> countObjects;

    public CurrencyDictionary(Lang lang) {
        if (lang == null) {
            String msg = "lang is null";
            throw new IllegalArgumentException(msg);
        }
        switch (lang) {
            case RUSSIAN -> loadCurrencyDictionaryRussian();
            case ENGLISH -> loadCurrencyDictionaryEnglish();
            default -> throw new IllegalArgumentException("There is no currency dictionary loader for lang " + lang);
        }
    }

    private void loadCurrencyDictionaryRussian() {
        this.countObjects = new HashMap<>();
        this.countObjects.put(Currency.RUBLE,
                new CountObject(Gender.MALE, "рубль", "рубля", "рублей"));
        this.countObjects.put(Currency.DOLLAR,
                new CountObject(Gender.MALE, "доллар", "доллара", "долларов"));
        this.countObjects.put(Currency.POINT,
                new CountObject(Gender.NEUTER, "очко", "очка", "очков"));
    }

    private void loadCurrencyDictionaryEnglish() {
        this.countObjects = new HashMap<>();
        this.countObjects.put(Currency.RUBLE,
                new CountObject(Gender.MALE, "ruble", "rubles"));
        this.countObjects.put(Currency.DOLLAR,
                new CountObject(Gender.MALE, "dollar", "dollars"));
        this.countObjects.put(Currency.POINT,
                new CountObject(Gender.NEUTER, "point", "points"));
    }

    public CountObject getCountObject(Currency currency){
        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }

        CountObject countObject = countObjects.get(currency);

        if (countObject == null) {
            String msg = "There is no count object for currency: " + currency;
            throw new IndexOutOfBoundsException(msg);
        }
        return countObject;
    }
}
