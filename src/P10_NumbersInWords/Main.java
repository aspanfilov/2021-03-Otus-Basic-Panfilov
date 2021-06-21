package P10_NumbersInWords;

import P10_NumbersInWords.dictionary.NumberDictionary;
import P10_NumbersInWords.domain.NumberToTextConverter;
import P10_NumbersInWords.services.CountObject;
import P10_NumbersInWords.services.Currency;
import P10_NumbersInWords.services.Gender;
import P10_NumbersInWords.services.Lang;

import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NumberDictionary numberDictionary = new NumberDictionary(Lang.RUSSIAN);
//        NumberDictionary numberDictionary = new NumberDictionary(Lang.ENGLISH);

        NumberToTextConverter numberConverter = new NumberToTextConverter(numberDictionary);

        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        String numberInText = numberConverter.convert(number, Currency.RUBLE);

        System.out.println(numberInText);

    }

}





