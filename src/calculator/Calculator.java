package calculator;

class Calculator {

    String calculate(String[] expression) {
        double result = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i = i + 2) {
            String op = expression[i];
            double b = Double.parseDouble(expression[i + 1]);
            switch (op) {
                case "+":
                    result += b; // result=result + b
                    break;
                case "-":
                    result -= b; // result=result - b
                    break;
                case "*":
                    result *= b; // result=result * b
                    break;
                case "/":
                    result /= b; // result=result / b
                    break;
                default:
                    return "ERROR";
            }
        }
        return String.valueOf(result);
    }
}
