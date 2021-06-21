package P10_NumbersInWords.services;

import java.util.HashMap;
import java.util.Map;

public class CountObject {
//todo сделать количество форм определяемым по настройке

    private Map<Integer, String> quantitativeForms;
    private Gender gender;

    public CountObject(Gender gender, String firstForm) {
        this.gender = gender;
        this.quantitativeForms = new HashMap<>();
        this.quantitativeForms.put(1, firstForm);
    }

    public CountObject(Gender gender, String firstForm, String secondForm) {
        this.gender = gender;
        this.quantitativeForms = new HashMap<>();
        this.quantitativeForms.put(1, firstForm);
        this.quantitativeForms.put(2, secondForm);
    }

    public CountObject(Gender gender, String firstForm, String secondForm, String thirdForm) {
        this.gender = gender;
        this.quantitativeForms = new HashMap<>();
        this.quantitativeForms.put(1, firstForm);
        this.quantitativeForms.put(2, secondForm);
        this.quantitativeForms.put(3, thirdForm);
    }

    public Gender getGender() {
        return gender;
    }

    public String getQuantitativeForm(int formId) {
        String quantitativeForm = this.quantitativeForms.get(formId);
        if (quantitativeForm == null) {
            String msg = "quantitativeForms.size=" + this.quantitativeForms.size() +
                    " index=" + formId;
            throw new IndexOutOfBoundsException(msg);
        }
        return quantitativeForm;
    }

}
