package P10_NumbersInWords.ru.otus.services;

import java.util.HashMap;
import java.util.Map;

public class GenderNumber {

    private Map<Gender, String> genderNames;

    public GenderNumber(String maleName, String femaleName, String neuterName) {
        this.genderNames = new HashMap<>();
        this.genderNames.put(Gender.MALE, maleName);
        this.genderNames.put(Gender.FEMALE, femaleName);
        this.genderNames.put(Gender.NEUTER, neuterName);
    }

    public String getGenderName(Gender gender) {
        return genderNames.get(gender);
    }
}
