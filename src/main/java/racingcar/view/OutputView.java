package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class OutputView {

    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(final Cars cars) {
        cars.getCars().forEach(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())));
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
