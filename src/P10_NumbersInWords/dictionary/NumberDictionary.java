package P10_NumbersInWords.dictionary;

import P10_NumbersInWords.dictionary.sub_dictionaries.*;
import P10_NumbersInWords.services.Currency;
import P10_NumbersInWords.services.Lang;

public class NumberDictionary {

    private final DigitsDictionary digitsDictionary;
    private final FixedNumbersDictionary fixedNumbersDictionary;
    private final TensDictionary tensDictionary;
    private final HundredsDictionary hundredsDictionary;
    private final NumberClassesDictionary numberClassesDictionary;
    private final CurrencyDictionary currencyDictionary;
    private final CountObjectQuantitativeFormSelector countObjectQuantitativeFormSelector;
    private Lang lang;

    public NumberDictionary(Lang lang) {
        this.digitsDictionary = new DigitsDictionary(lang);
        this.fixedNumbersDictionary = new FixedNumbersDictionary(lang);
        this.tensDictionary = new TensDictionary(lang);
        this.hundredsDictionary = new HundredsDictionary(lang);

        this.numberClassesDictionary = new NumberClassesDictionary(lang);
        this.currencyDictionary = new CurrencyDictionary(lang);
        this.countObjectQuantitativeFormSelector = new CountObjectQuantitativeFormSelector(lang);
    }

    public DigitsDictionary getDigitsDictionary() {
        return digitsDictionary;
    }

    public FixedNumbersDictionary getFixedNumbersDictionary() {
        return fixedNumbersDictionary;
    }

    public TensDictionary getTensDictionary() {
        return tensDictionary;
    }

    public HundredsDictionary getHundredsDictionary() {
        return hundredsDictionary;
    }

    public NumberClassesDictionary getNumberClassesDictionary() {
        return numberClassesDictionary;
    }

    public CurrencyDictionary getCurrencyDictionary() {
        return currencyDictionary;
    }

    public CountObjectQuantitativeFormSelector getCountObjectQuantitativeFormSelector() {
        return countObjectQuantitativeFormSelector;
    }

    public Lang getLang() {
        return this.lang;
    }
}
