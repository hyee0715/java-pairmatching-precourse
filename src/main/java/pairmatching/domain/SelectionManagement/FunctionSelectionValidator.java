package pairmatching.domain.SelectionManagement;

public class FunctionSelectionValidator {
    private static final String EMPTY_FUNCTION_SELECTION_ERROR_MESSAGE = "[ERROR] 기능 선택 번호가 입력되지 않았습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자가 아니거나 숫자가 아닌 문자가 포함되어 있습니다.";
    private static final String FUNCTION_SELECTION_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 기능 선택 번호는 1부터 3 사이의 숫자여야 합니다.";

    private static final int FUNCTION_SELECTION_RANGE_FIRST_VALUE = 1;
    private static final int FUNCTION_SELECTION_RANGE_LAST_VALUE = 3;

    public static void validate(String functionSelection) {
        validateEmptyFunctionSelection(functionSelection);

        validateOnlyNumber(functionSelection);

        validateFunctionSelectionRange(functionSelection);
    }

    public static void validateEmptyFunctionSelection(String functionSelection) {
        if (functionSelection.isEmpty() || functionSelection == null) {
            throw new IllegalArgumentException(EMPTY_FUNCTION_SELECTION_ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumber(String functionSelection) {
        try {
            Integer.parseInt(functionSelection);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateFunctionSelectionRange(String functionSelection) {
        int size = Integer.parseInt(functionSelection);

        if (size < FUNCTION_SELECTION_RANGE_FIRST_VALUE || size > FUNCTION_SELECTION_RANGE_LAST_VALUE) {
            throw new IllegalArgumentException(FUNCTION_SELECTION_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
