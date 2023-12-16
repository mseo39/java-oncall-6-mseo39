package oncall.view;

public enum InputPhrase {
    INPUT_MONTH("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

    private String phrase;

    InputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }
}