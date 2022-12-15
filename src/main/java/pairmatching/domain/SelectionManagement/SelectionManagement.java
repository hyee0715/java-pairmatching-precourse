package pairmatching.domain.SelectionManagement;

import pairmatching.view.InputView;

public class SelectionManagement {
    public static String getFunctionSelection() {
        InputView inputView = new InputView();

        return inputView.readFunctionSelection();
    }
}
