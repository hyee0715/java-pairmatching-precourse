package pairmatching.controller;

import pairmatching.domain.selectionManagement.SelectionManagement;

public class PairMatchingController {
    public void run() {
        String functionSelection = SelectionManagement.getFunctionSelection();
        System.out.println(functionSelection);
    }
}
