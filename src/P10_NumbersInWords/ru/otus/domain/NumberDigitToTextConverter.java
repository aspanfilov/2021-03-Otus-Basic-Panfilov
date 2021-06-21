package P10_NumbersInWords.ru.otus.domain;

import P10_NumbersInWords.ru.otus.dictionary.*;
import P10_NumbersInWords.ru.otus.dictionary.sub_dictionaries.*;
import P10_NumbersInWords.ru.otus.services.CountObject;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberDigitToTextConverter {
    private NumberDictionary numberDictionary;
    private PhraseBuilder phraseBuilder;
    private NumberDigitHandler numberDigitHandler;

    public NumberDigitToTextConverter (
            NumberDictionary numberDictionary,
            PhraseBuilder phraseBuilder,
            NumberDigitHandler numberDigitHandler) {
        this.numberDictionary = numberDictionary;
        this.phraseBuilder = phraseBuilder;
        this.numberDigitHandler = numberDigitHandler;
    }

    public String convert(int number, CountObject countObject, AtomicBoolean executionFlag) {

        DigitsDictionary digitsDictionary = this.numberDictionary.getDigitsDictionary();
        FixedNumbersDictionary fixedNumbersDictionary = this.numberDictionary.getFixedNumbersDictionary();
        TensDictionary tensDictionary = this.numberDictionary.getTensDictionary();
        HundredsDictionary hundredsDictionary = this.numberDictionary.getHundredsDictionary();
        CountObjectQuantitativeFormSelector countObjectQuantitativeFormSelector = this.numberDictionary.getCountObjectQuantitativeFormSelector();

        //Первым шагом проверяем число на вхождение в набор фиксированных числовых имен
        String numberDigitInWords = fixedNumbersDictionary.getFixedNumberName(number);
        if (!numberDigitInWords.isEmpty()) {
            numberDigitInWords = this.phraseBuilder.concatenate(numberDigitInWords,
                    countObjectQuantitativeFormSelector.getQuantitativeForm(countObject, number));
            executionFlag.set(true);
            return numberDigitInWords;
        }

        switch (this.numberDigitHandler.getHighestDigitNumber(number)) {
            case 3 -> numberDigitInWords = hundredsDictionary.getHundredNameByNumber(number);
            case 2 -> numberDigitInWords = tensDictionary.getTenNameByNumber(number);
            case 1 -> {
                numberDigitInWords = digitsDictionary.getDigitName(number, countObject.getGender());
                numberDigitInWords = this.phraseBuilder.concatenate(numberDigitInWords,
                        countObjectQuantitativeFormSelector.getQuantitativeForm(countObject, number));
                executionFlag.set(true);
            }
            default -> {
                String msg = "number=" + number + " is outside the allowed range";
                throw new IllegalArgumentException(msg);
            }
        }

        return numberDigitInWords;
    }

}
