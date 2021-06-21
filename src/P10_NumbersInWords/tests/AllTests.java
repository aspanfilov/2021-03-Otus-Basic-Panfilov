package P10_NumbersInWords.tests;

import P10_NumbersInWords.tests.assertions.TestExecutor;
import P10_NumbersInWords.tests.unit.NumberInTextConverterTest;

public class AllTests {
    public static void main(String[] args) {

        TestExecutor.doTest("Тест перевода в пропись 0 рублей",
                () -> new NumberInTextConverterTest().testConvert0Rubles());

        TestExecutor.doTest("Тест перевода в пропись 2 рублей",
                () -> new NumberInTextConverterTest().testConvert2Rubles());

        TestExecutor.doTest("Тест перевода в пропись 101 рубля",
                () -> new NumberInTextConverterTest().testConvert101Ruble());

        TestExecutor.doTest("Тест перевода в пропись 99000011 рублей",
                () -> new NumberInTextConverterTest().testConvert99000011Rubles());


    }
}
