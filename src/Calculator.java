import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        startCalc();

        while(true) {
            System.out.println("Введите число: ");
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                closeCalc();
                break;
            }

            try {
                String[] sym = line.split(" ");
                if (sym.length != 3) {
                    throw new Exception("Что-то пошло не так, попробуйте еще раз");
                }

                Number firstNumber = Number.parse(sym[0]);
                Number secondNumber = Number.parse(sym[2], firstNumber.getType());
                String result = Actions.calculate(firstNumber, secondNumber, sym[1]);
                System.out.println("Результат: " + result);
            } catch (Exception var7) {
                System.out.println(var7.getMessage());
                closeCalc();
                break;
            }
        }
    }

    private static void startCalc() {
        System.out.println("Товарищ, добро пожаловать в это - ");
        System.out.println("Калькулятор V1.0 .");
        System.out.println("Пример вводимых значений - \"1 + 1\" или \"I + I\"!!!");
        System.out.println("Операции могут быть только +, -, *, /!!!");
        System.out.println("По обе стороны от оператора вставляй пробелы, т.е." +
                " левый операнд --> пробел --> оператор --> пробел --> правый операнд. Далее жми ENTER. Успехов!");
    }

    private static void closeCalc() {
        System.out.println("ХорошегоДняТоварищ");
    }
}
