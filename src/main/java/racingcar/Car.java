package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int moveCount = 0;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            this.moveCount++;
        }
        System.out.println(name + " : " + "-".repeat(moveCount));
    }
}
