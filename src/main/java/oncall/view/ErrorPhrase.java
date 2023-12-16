package oncall.view;

public enum ErrorPhrase {
    EXIST_DAY("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    NAME_LENGTH("사용자의 이름은 최대 5자입니다. 다시 입력해 주세요."),
    WORKER_LENGTH("인원은 최소 5명 최대 35명입니다. 다시 입력해 주세요."),
    STRING_TO_INTEGER("정수를 입력해야 합니다. 다시 입력해 주세요."),
    NAME_DUPLACATE("사용자의 이름이 중복되면 안됩니다. 다시 입력해 주세요.");

    private String phrase;
    private static String error = "[ERROR]";

    ErrorPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return error+" "+this.phrase;
    }
}