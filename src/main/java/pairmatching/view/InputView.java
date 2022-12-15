package pairmatching.view;

public class InputView {
    private final String INPUT_FUNCTION_SELECTION_MESSAGE = "기능을 선택하세요.";

    private final String LINE_BREAK = "\n";

    public void readFunctionSelection() {
        OutputView outputView = new OutputView();
        System.out.println(INPUT_FUNCTION_SELECTION_MESSAGE);
        outputView.printFunctionSelectionMessage();
    }
}
