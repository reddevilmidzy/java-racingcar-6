package racingcar.model.car;

import racingcar.constant.message.Message;
import racingcar.service.Accelerator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

//TODO: 허무맹랑할 수 있는 이야기이지만, 자동차 경주에 말이 들어온다면?? 해당 경우도 한번 고민해보기
public class Car {

    protected final String name;
    protected Long currentPosition;

    private Car(String name, Long currentPosition) {
        validate(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car ofStartingPoint(String name) {
        return new Car(name, 0L);
    }

    public void move() {
        if (Accelerator.canMoveForward()) {
            currentPosition++;
        }
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    //TODO: 게터 지양
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(Message.NAME_POSITION_SEPARATOR);
        for (long i = 0; i < this.currentPosition; i++) {
            stringBuilder.append(Message.MARK);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return this.currentPosition.equals(car.currentPosition);
    }
}
