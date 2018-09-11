package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    String calculate(String[] expression) {
        List<String> tmp = new ArrayList<>(List.of(expression)); // nokonvertējām masīvu uz List. List<String> var aizvietot ar VAR.

        int brOpenIndx;
        do {
            brOpenIndx = -1;
            for (int i = 0; i < tmp.size(); i++) {
                String a = tmp.get(i);
                if (a.equals("(")) {
                    brOpenIndx = i;
                } else if (a.equals(")")) {
                    var inBracket = tmp.subList(brOpenIndx + 1, i);
                    var result = calculate(inBracket);

                    tmp.subList(brOpenIndx, i + 1).clear();  // brOpenIndx - ukazivaet na otkrytuju skobku; i+1 ukazivaet na zakryvajushuju skovku; .clear - udalaet bvyrazenie v skobkah
                    tmp.add(brOpenIndx, result); // rezultat, kotoryj poluchilsja v skobkah my dobavim v na mesto pervoj skobki.
                    break;
                }
            }
        } while (brOpenIndx != -1);

        return calculate(tmp); // ar šo kalkulātoram jasāk strādat kā līdz šim. Ar jaunu tmp un metodes pasludināšanu mēs esam sagatavojušies iekavām.
    }

    String calculate(List<String> expression) {
        List<String> tmp = new ArrayList<>(); // izveidojām jaunu saraksu. darbojās kā masīvs, bet ir ērtāks. Masīvs vienmēr ir statisks, List var papildināt, jo tas ir dinamiskss

        double a = Double.parseDouble(expression.get(0)); // ar .get mēs izsaucām list
        for (int i = 1; i < expression.size(); i += 2) {
            String op = expression.get(i);
            double b = Double.parseDouble(expression.get(i + 1));
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
