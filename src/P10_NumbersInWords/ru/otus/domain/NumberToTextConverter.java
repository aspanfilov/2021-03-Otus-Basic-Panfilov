package P10_NumbersInWords.ru.otus.domain;

import P10_NumbersInWords.ru.otus.dictionary.NumberDictionary;
import P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries.CountObjectQuantitativeFormSelector;
import P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries.CurrencyDictionary;
import P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries.NumberClassesDictionary;
import P10_NumbersInWords.ru.otus.services.CountObject;
import P10_NumbersInWords.ru.otus.services.Currency;

import java.util.List;

public class NumberToTextConverter {
    private NumberDictionary numberDictionary;
    private PhraseBuilder phraseBuilder;
    private NumberClassToTextConverter numberClassToTextConverter;
    private NumberClassSeparator numberClassSeparator;

    public NumberToTextConverter(NumberDictionary numberDictionary) {
        this.numberDictionary = numberDictionary;
        this.phraseBuilder = new PhraseBuilder();
        this.numberClassToTextConverter = new NumberClassToTextConverter(numberDictionary, phraseBuilder);
        this.numberClassSeparator = new NumberClassSeparator();
    }

    //todo реализовать интерфейс Converter с методом Convert. Использовать его для всех классов конвертеров
    public String convert(long number, Currency currency) {

        NumberClassesDictionary numberClassesDictionary = this.numberDictionary.getNumberClassesDictionary();
        CountObjectQuantitativeFormSelector countObjectQuantitativeFormSelector = this.numberDictionary.getCountObjectQuantitativeFormSelector();

        CurrencyDictionary currencyDictionary = this.numberDictionary.getCurrencyDictionary();
        CountObject countObject = currencyDictionary.getCountObject(currency);

        //todo использовать стринг билдер
        String numberInWords = "";

        List<Integer> numbersByClass = this.numberClassSeparator.getNumbersByClass(number);

        if (numbersByClass.isEmpty()) {
            numberInWords = this.phraseBuilder.concatenate("ноль",
                    countObjectQuantitativeFormSelector.getQuantitativeForm(countObject, 0));
            return numberInWords;
        }

        int currentNumberClassId = numbersByClass.size();

        while (--currentNumberClassId > 0) {
            CountObject currentNumberClass = numberClassesDictionary.getNumberClass(currentNumberClassId);
            int currentNumberClassNumber = numbersByClass.get(currentNumberClassId);
            String numberClassNumberInWords = this.numberClassToTextConverter.convert(currentNumberClassNumber, currentNumberClass);

            numberInWords = this.phraseBuilder.concatenate(numberInWords, numberClassNumberInWords);
        }
        String numberClassNumberInWords = this.numberClassToTextConverter.convert(numbersByClass.get(0), countObject);
        numberInWords = this.phraseBuilder.concatenate(numberInWords, numberClassNumberInWords);

        return numberInWords;
    }


}
