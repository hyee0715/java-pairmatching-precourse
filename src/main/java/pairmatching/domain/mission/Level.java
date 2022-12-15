package pairmatching.domain.mission;

public enum Level {
    LEVEL1("레벨1", new String[] {"자동차경주", "로또", "숫자야구게임"}),
    LEVEL2("레벨2", new String[] {"장바구니", "결제", "지하철노선도"}),
    LEVEL3("레벨3", new String[] {}),
    LEVEL4("레벨4", new String[] {"성능개선", "배포"}),
    LEVEL5("레벨5", new String[] {});

    private String name;
    private String[] mission;

    public String getName() {
        return name;
    }

    public String[] getMission() {
        return mission;
    }

    Level(String name, String[] mission) {
        this.name = name;
        this.mission = mission;
    }
}