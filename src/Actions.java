public class Actions {

    public static String calculate(Number first, Number second, String action) throws Exception {

        int result;

            switch (action) {
                case "+":
                    result = first.getValue() + second.getValue();
                    break;
                case "-":
                    result = first.getValue() - second.getValue();
                    break;
                case "*":
                    result = first.getValue() * second.getValue();
                    break;
                case "/":
                    result = first.getValue() / second.getValue();
                    break;
                default:
                    throw new Exception("Не правильно введен символ операции, используйте только +, -, *, /");
            }

            if (first.getType() == NumberType.ROMAN) {
                return Converter.intToRomanV2(result);
            } else return String.valueOf(result);
    }
}