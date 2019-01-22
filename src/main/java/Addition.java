class Addition implements Operation {

    private static final String SIGN = "+";

    public boolean apply(String operatorSign) {
        return SIGN.equals(operatorSign);
    }

    public double calculate(double a, double b) {
        return a + b;
    }
}
