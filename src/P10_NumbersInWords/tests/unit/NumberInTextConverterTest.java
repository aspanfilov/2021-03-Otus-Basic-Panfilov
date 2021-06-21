package P10_NumbersInWords.tests.unit;

import P10_NumbersInWords.ru.otus.dictionary.NumberDictionary;
import P10_NumbersInWords.ru.otus.domain.NumberToTextConverter;
import P10_NumbersInWords.ru.otus.services.Currency;
import P10_NumbersInWords.ru.otus.services.Lang;
import P10_NumbersInWords.tests.assertions.Assertions;

public class NumberInTextConverterTest {

    NumberDictionary numberDictionary = new NumberDictionary(Lang.RUSSIAN);
    private NumberToTextConverter numberToTextConverter = new NumberToTextConverter(numberDictionary);

    public void testConvert0Rubles() {
        String actual = numberToTextConverter.convert(0, Currency.RUBLE);
        Assertions.assertEquals("ноль рублей", actual);
    }

    public void testConvert2Rubles() {
        String actual = numberToTextConverter.convert(2, Currency.RUBLE);
        Assertions.assertEquals("два рубля", actual);
    }

    public void testConvert101Ruble() {
        String actual = numberToTextConverter.convert(101, Currency.RUBLE);
        Assertions.assertEquals("сто один рубль", actual);
    }

    public void testConvert99000011Rubles() {
        String actual = numberToTextConverter.convert(99000011, Currency.RUBLE);
        Assertions.assertEquals("девяносто девять миллионов одиннадцать рублей", actual);
    }
}
