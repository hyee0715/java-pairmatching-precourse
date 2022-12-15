package pairmatching.view;

import jdk.swing.interop.SwingInterOpUtils;
import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;

import java.util.Arrays;

public class OutputView {
    private final String INPUT_PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
    private final String INPUT_PAIR_CHECK_MESSAGE = "2. 페어 조회";
    private final String INPUT_PAIR_INITIALIZATION_MESSAGE = "3. 페어 초기화";
    private final String INPUT_QUIT_MESSAGE = "Q. 종료";

    private final String SHARP_SEPARATER = "#############################################";
    private final String COURSE_MESSAGE = "과정: ";
    private final String MISSION_MESSAGE = "미션: ";

    private final int ZERO_COUNT = 0;
    private final String SEPARATOR = " | ";
    private final String COLON = ": ";
    private final String LINE_BREAK = "\n";
    private final String LEVEL_BAR = "  - ";

    public void printFunctionSelectionMessage() {
        System.out.println(INPUT_PAIR_MATCHING_MESSAGE);
        System.out.println(INPUT_PAIR_CHECK_MESSAGE);
        System.out.println(INPUT_PAIR_INITIALIZATION_MESSAGE);
        System.out.println(INPUT_QUIT_MESSAGE);
    }

    public void printCourseAndMission() {
        System.out.println(SHARP_SEPARATER);
        printCourse();
        printLevel();
        System.out.println(SHARP_SEPARATER);
    }

    public void printCourse() {
        System.out.print(COURSE_MESSAGE);

        Course[] courses = Course.values();
        for (int courseCount = ZERO_COUNT; courseCount < courses.length; courseCount++) {
            System.out.print(courses[courseCount].getName());

            if (courseCount != courses.length - 1) {
                System.out.print(SEPARATOR);
                continue;
            }

            System.out.print(LINE_BREAK);
        }
    }

    public void printLevel() {
        System.out.println(MISSION_MESSAGE);
        Level[] levels = Level.values();
        for (Level level : levels) {
            System.out.print(LEVEL_BAR + level.getName() + COLON);

            if (handleMissionEmpty(level.getMission())) {
                continue;
            }
            printMission(level.getMission());
        }
    }

    public void printMission(String[] mission) {
        for (int missionCount = ZERO_COUNT; missionCount < mission.length; missionCount++) {
            System.out.print(mission[missionCount]);

            if (missionCount != mission.length - 1) {
                System.out.print(SEPARATOR);
                continue;
            }

            System.out.print(LINE_BREAK);
        }
    }

    public boolean handleMissionEmpty(String[] mission) {
        if (mission.length == 0) {
            System.out.print(LINE_BREAK);
            return true;
        }

        return false;
    }
}
