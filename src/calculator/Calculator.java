package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    String calculate(String[] expression) {
        List<String> tmp = new ArrayList<>(); // izveidojām jaunu saraksu. darbojās kā masīvs, bet ir ērtāks. Masīvs vienmēr ir statisks, List var papildināt, jo tas ir dinamiskss

        double a = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i += 2) {
            String op = expression[i];
            double b = Double.parseDouble(expression[i + 1]);
            switch (op) {
                case "+":
                case "-":
                    tmp.add(String.valueOf(a));
                    tmp.add(op);
                    a = b;
                    break;
                case "*":
                    a *= b;
                    break;
                case "/":
                    a /= b;
                    break;
            }
        }
        tmp.add(String.valueOf(a));

        System.out.println(tmp);

        double result = Double.parseDouble(tmp.get(0));
        for (int i = 1; i < tmp.size(); i = i + 2) {
            String op = tmp.get(i);
            double b = Double.parseDouble(tmp.get(i + 1));
            switch (op) {
                case "+":
                    result += b; // result=result + b
                    break;
                case "-":
                    result -= b; // result=result - b
                    break;
//                case "*":
//                    result *= b; // result=result * b
//                    break;
//                case "/":
//                    result /= b; // result=result / b
//                    break;
                default:
                    return "ERROR";
            }
        }
        return String.valueOf(result);
    }
}
