package pairmatching.controller;

import pairmatching.domain.SelectionManagement.SelectionManagement;

public class PairMatchingController {
    public void run() {
        String functionSelection = SelectionManagement.getFunctionSelection();
        System.out.println(functionSelection);
    }
}
