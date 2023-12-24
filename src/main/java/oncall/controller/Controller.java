package oncall.controller;

import oncall.model.Matching;
import oncall.model.Worker;
import oncall.util.Validator;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class Controller {

    private Matching matching;
    private Worker worker;

    public Controller() {

    }

    public void startProgram() {
        requestReadMonth();
        requestReadWorker();
        requestMatching();
    }

    public void requestReadMonth(){
        while (true) {
            try {
                List<String> input = InputView.readMonth();
                this.matching = new Matching(Validator.validateInteger(input.get(0)), input.get(1));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void requestReadWorker(){
        while (true) {
            try {
                worker= new Worker(InputView.readWeekdayWorker(), InputView.readWeekendWorker());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void requestMatching(){
        matching.matchingLogic(worker);
        OutputView.printMatching(this.matching);
    }
}