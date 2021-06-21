package P10_NumbersInWords.domain;

public class PhraseBuilder {

    public String concatenate(String firstString, String secondString) {
        if (firstString.isEmpty() && secondString.isEmpty()) {
            return "";
        } else if (firstString.isEmpty()) {
            return secondString;
        } else if (secondString.isEmpty()) {
            return firstString;
        } else {
            return firstString + " " + secondString;
        }
    }
}
