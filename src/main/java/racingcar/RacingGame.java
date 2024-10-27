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

        this.cars = Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        IntStream.range(0, cnt).forEach(i -> {
            cars.forEach(Car::move);
            System.out.println();
        });
    }
}
