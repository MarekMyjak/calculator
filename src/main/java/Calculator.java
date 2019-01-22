import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Calculator {
    double calculate(String expression, List<Operation> operationList) {
        Iterator<String> iterator = Arrays.asList(expression.split("\\s")).iterator();
        double actualResoult = Double.parseDouble(iterator.next());
        while (iterator.hasNext()) {
            final String sign = iterator.next();
            final double second = Double.parseDouble(iterator.next());
            Operation operation1 = getOperationFromSign(operationList, sign);
            actualResoult = operation1.calculate(actualResoult, second);
        }
        return actualResoult;
    }

    private Operation getOperationFromSign(List<Operation> operationList, String sign) {
        return operationList
                .stream()
                .filter(operation -> operation.apply(sign))
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }
}
