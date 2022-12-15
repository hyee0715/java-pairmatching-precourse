package pairmatching.controller;

import pairmatching.domain.selectionManagement.SelectionManagement;
import pairmatching.view.OutputView;

public class PairMatchingController {
    public void run() {
        String functionSelection = SelectionManagement.getFunctionSelection();

        OutputView outputView = new OutputView();
        outputView.printCourseAndMission();
    }
}
