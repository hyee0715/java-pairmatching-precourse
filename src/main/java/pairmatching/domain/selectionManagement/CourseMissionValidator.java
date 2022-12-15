package pairmatching.domain.selectionManagement;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseMissionValidator {
    private static final String EMPTY_COURSE_MISSION_ERROR_MESSAGE = "[ERROR] 과정, 레벨, 미션이 입력되지 않았습니다.";
    private static final String NOT_CONTAINS_COMMA_ERROR_MESSAGE = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (입력된 값에 콤마(,)가 존재하지 않습니다.)";
    private static final String CONSECUTIVE_COMMAS_ERROR_MESSAGE = "[ERROR] 입력된 값이 형식에 맞지 않습니다. (콤마(,)가 연속으로 입력되었습니다.)";
    private static final String ONE_EMPTY_ERROR_MESSAGE = "[ERROR] 형식에 맞게 정확히 콤마와 띄어쓰기로 구분하여 3가지로 입력되어야 합니다.";
    private static final String NOT_MISSION_ERROR_MESSAGE = "[ERROR] 존재하지 않는 값이 입력되었습니다.";

    private static final String COMMA_DELIMITER = ",";
    private static final String SPACE = " ";
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final int TWO_INDEX = 2;


    public static void validate(String courseMission) {
        validateEmptyCourseMission(courseMission);
        validateContainsComma(courseMission);
        validateConsecutiveCommas(courseMission);
        validateOneEmpty(courseMission);
        validateNotMission(courseMission);
    }

    public static void validateEmptyCourseMission(String courseMission) {
        if (courseMission.isEmpty() || courseMission.equals("") || courseMission == null) {
            throw new IllegalArgumentException(EMPTY_COURSE_MISSION_ERROR_MESSAGE);
        }
    }

    public static void validateContainsComma(String courseMission) {
        if (!courseMission.contains(COMMA_DELIMITER)) {
            throw new IllegalArgumentException(NOT_CONTAINS_COMMA_ERROR_MESSAGE);
        }
    }

    public static void validateConsecutiveCommas(String courseMission) {
        for (int i = 0; i < courseMission.length() - 1; i++) {
            String firstLetter = String.valueOf(courseMission.charAt(i));
            String secondLetter = String.valueOf(courseMission.charAt(i + 1));

            if (firstLetter.equals(secondLetter) && firstLetter.equals(COMMA_DELIMITER)) {
                throw new IllegalArgumentException(CONSECUTIVE_COMMAS_ERROR_MESSAGE);
            }
        }
    }

    public static void validateOneEmpty(String courseMission) {
        String[] mission = courseMission.split(COMMA_DELIMITER + SPACE);

        if (mission.length != 3) {
            throw new IllegalArgumentException(ONE_EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateNotMission(String courseMission) {
        String[] mission = courseMission.split(COMMA_DELIMITER + SPACE);

        String userCourse = mission[ZERO_INDEX];
        String userLevel = mission[ONE_INDEX];
        String userMission = mission[TWO_INDEX];

        if (!findCourse(userCourse) || !findLevel(userLevel) || !findMission(userMission)) {
            throw new IllegalArgumentException(NOT_MISSION_ERROR_MESSAGE);
        }
    }

    public static boolean findCourse(String userCourse) {
        Course[] courses = Course.values();
        Set<String> finder = Arrays.stream(courses)
                .map(Course::getName)
                .collect(Collectors.toSet());

        if (!finder.contains(userCourse)) {
            return false;
        }
        return true;
    }

    public static boolean findLevel(String userLevel) {
        Level[] levels = Level.values();

        Set<String> finder = Arrays.stream(levels)
                .map(Level::getName)
                .collect(Collectors.toSet());

        if (!finder.contains(userLevel)) {
            return false;
        }
        return true;
    }

    public static boolean findMission(String userMission) {
        Level[] levels = Level.values();
        List<String[]> missions = Arrays.stream(levels)
                .map(Level::getMission)
                .collect(Collectors.toList());

        Set<String> finder = setUpFinderForMission(missions);
        if (!finder.contains(userMission)) {
            return false;
        }
        return true;
    }

    public static Set<String> setUpFinderForMission(List<String[]> missions) {
        Set<String> finder = new HashSet<>();

        for (String[] mission : missions) {
            finder.addAll(Arrays.asList(mission));
        }

        return finder;
    }
}
