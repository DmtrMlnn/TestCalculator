public class Number {
    private int value;
    private NumberType type;

    Number(int value, NumberType type) {
        this.value = value;
        this.type = type;
    }

    int getValue() {
        return this.value;
    }

    NumberType getType() {
        return this.type;
    }

    static Number parse(String symbol) throws Exception {
        int value;
        NumberType type;
        try {
            value = Integer.parseInt(symbol);
            type = NumberType.ARABIC;
        } catch (NumberFormatException var4) {
            value = Converter.romanToInt(symbol);
            type = NumberType.ROMAN;
        }

        if (value >= 1 && value <= 10) {
            return new Number(value, type);
        } else {
            throw new Exception("Используйте числа от 1 до 10 включительно");
        }
    }

    static Number parse(String symbol, NumberType type) throws Exception {
        Number number = parse(symbol);
        if (number.getType() != type) {
            throw new Exception("Числа разных типов, используйте один тип вводимых значений");
        } else {
            return number;
        }
    }
}
