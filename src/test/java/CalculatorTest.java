import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void GivenDefaultOperationShouldReturnCorrectResult() {
//        when
        double result = calculator.calculate("5 + 2 + 5 + 1 - 1 - 1 + 2", Arrays.asList(new Addition(), new Subtraction()));
//        then
        Assert.assertEquals(13.0, result, 0.0001);
    }

    @Test
    public void givenNewMultiplicationOperatorShouldReturnCorrectResult() {
//        given
        Operation multiplication = crateMultiplicationOperation();
//        when
        double result = calculator.calculate("5 * 3 * 2", Collections.singletonList(multiplication));
//        then
        Assert.assertEquals(30.0, result, 0.0001);
    }

    private Operation crateMultiplicationOperation() {
        return new Operation() {
            private final String SIGN = "*";

            @Override
            public boolean apply(String operatorSign) {
                return SIGN.equals(operatorSign);
            }

            @Override
            public double calculate(double a, double b) {
                return a * b;
            }
        };
    }
}
