package pairmatching.view;

public class OutputView {
    private final String INPUT_PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
    private final String INPUT_PAIR_CHECK_MESSAGE = "2. 페어 조회";
    private final String INPUT_PAIR_INITIALIZATION_MESSAGE = "3. 페어 초기화";
    private final String INPUT_QUIT_MESSAGE = "Q. 종료";

    public void printFunctionSelectionMessage() {
        System.out.println(INPUT_PAIR_MATCHING_MESSAGE);
        System.out.println(INPUT_PAIR_CHECK_MESSAGE);
        System.out.println(INPUT_PAIR_INITIALIZATION_MESSAGE);
        System.out.println(INPUT_QUIT_MESSAGE);
    }
}
