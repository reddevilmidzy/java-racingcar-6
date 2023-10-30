package racingcar.model;

import racingcar.constant.message.Message;
import racingcar.model.car.Car;
import racingcar.model.car.OrderByPosition;
import racingcar.model.car.OrderStrategy;
import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racer {

    private final List<Car> racer;

    private Racer(String value) {
        validate(value);
        this.racer = Arrays.stream(value.split(Message.NAME_SEPARATOR))
                .map(String::trim)
                .map(Car::ofStartingPoint)
                .toList();
    }

    public static Racer of(String value) {
        return new Racer(value);
    }

    public void play(Accelerator accelerator) {
        racer.forEach(car -> car.move(accelerator));
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    public String winnerToString() {
        return getWinner(new OrderByPosition())
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(Message.NAME_SEPARATOR + " "));
    }

    private List<Car> getWinner(OrderStrategy orderStrategy) {
        Car first = racer.stream()
                .max(orderStrategy)
                .orElseThrow();
        return racer.stream()
                .filter(car -> car.equals(first))
                .toList();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Racer target)) {
            return false;
        }
        return racer.equals(target.racer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : racer) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
