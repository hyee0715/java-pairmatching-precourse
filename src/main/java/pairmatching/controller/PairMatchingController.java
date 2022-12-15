package pairmatching.controller;

import pairmatching.domain.selectionManagement.SelectionManagement;
import pairmatching.view.OutputView;

public class PairMatchingController {
    public void run() {
        selectFunction();

        selectCourseAndMission();
    }

    public void selectFunction() {
        String functionSelection = SelectionManagement.getFunctionSelection();
    }

    public void selectCourseAndMission() {
        OutputView outputView = new OutputView();
        outputView.printCourseAndMission();

        String courseMission = SelectionManagement.getCourseMissionSelection();
    }
}
