package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private Cars cars;
    private final InputView inputView;

    public RacingGame() {
        this.inputView = new InputView();
    }

    public void run() {
        String carNames = inputView.readCarNames();
        this.cars = new Cars(carNames);
        int tryCount = inputView.readTryCount();
        moveCars(tryCount);
        printWinners();
    }

    private void moveCars(final int cnt) {
        System.out.println("실행 결과");
        IntStream.range(0, cnt).forEach(i -> {
            cars.moveAll();
            System.out.println();
        });
    }

    private void printWinners() {
        List<String> winners = cars.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
