package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int move_count = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            this.move_count++;
        }
        System.out.print(name + " : ");
        for (int i = 0; i < move_count; ++i) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
