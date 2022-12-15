package pairmatching.domain.selectionManagement;

import pairmatching.view.InputView;

public class SelectionManagement {
    private static final String LINE_BREAK = "\n";

    public static String getFunctionSelection() {
        InputView inputView = new InputView();
        String functionSelection = inputView.readFunctionSelection();

        try {
            FunctionSelectionValidator.validate(functionSelection);
            return functionSelection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + LINE_BREAK);
            return getFunctionSelection();
        }
    }

    public static String getCourseMissionSelection() {
        InputView inputView = new InputView();
        String courseMissionSelection = inputView.readCourseMissionSelection();

        return courseMissionSelection;
    }
}
