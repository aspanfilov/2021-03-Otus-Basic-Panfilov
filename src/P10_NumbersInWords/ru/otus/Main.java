package P10_NumbersInWords.ru.otus;

import P10_NumbersInWords.ru.otus.dictionary.NumberDictionary;
import P10_NumbersInWords.ru.otus.domain.NumberToTextConverter;
import P10_NumbersInWords.ru.otus.services.Currency;
import P10_NumbersInWords.ru.otus.services.Lang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NumberDictionary numberDictionary = new NumberDictionary(Lang.ENGLISH);

        NumberToTextConverter numberConverter = new NumberToTextConverter(numberDictionary);

        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        String numberInText = numberConverter.convert(number, Currency.RUBLE);

        System.out.println(numberInText);

    }

}





