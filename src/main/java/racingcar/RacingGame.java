package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private List<Car> cars;

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int cnt = Integer.parseInt(Console.readLine());

        generateCars(input);
        moveCars(cnt);
        printWinners();
    }

    private void generateCars(final String input) {
        this.cars = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void moveCars(final int cnt) {
        IntStream.range(0, cnt).forEach(i -> {
            cars.forEach(Car::move);
            System.out.println();
        });
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    private List<String> getWinners(final int maxDistance) {
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void printWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = getWinners(maxDistance);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
