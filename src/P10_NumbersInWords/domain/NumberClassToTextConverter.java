package P10_NumbersInWords.domain;

import P10_NumbersInWords.dictionary.NumberDictionary;
import P10_NumbersInWords.services.CountObject;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberClassToTextConverter {
    private NumberDictionary numberDictionary;
    private PhraseBuilder phraseBuilder;
    private NumberDigitToTextConverter numberDigitToTextConverter;
    private NumberDigitHandler numberDigitHandler;

    public NumberClassToTextConverter(NumberDictionary numberDictionary, PhraseBuilder phraseBuilder) {
        this.numberDictionary = numberDictionary;
        this.phraseBuilder = phraseBuilder;
        this.numberDigitHandler = new NumberDigitHandler();
        this.numberDigitToTextConverter = new NumberDigitToTextConverter(
                numberDictionary, phraseBuilder, this.numberDigitHandler);

    }

    public String convert(int number, CountObject countObject) {
        //todo заменить строку на stringBuilder
        String numberInWords = "";

        if (number == 0) {
            return numberInWords;
        }

        AtomicBoolean executionFlag = new AtomicBoolean(false);
        while (!executionFlag.get()) {
            String numberDigitNumberInWords =
                    this.numberDigitToTextConverter.convert(number, countObject, executionFlag);

            numberInWords = this.phraseBuilder.concatenate(numberInWords, numberDigitNumberInWords);

            number = this.numberDigitHandler.deleteHighestDigit(number);
        }

        return numberInWords;
    }

}
