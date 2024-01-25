import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // создаем сканнер
        String inputWithSpase = sc.nextLine();// сканируем нашу строку
        String input = inputWithSpase.replaceAll("\\s", ""); //убираем пробелы между знаков,если они есть
        System.out.println(calc(input)); // выводим на печать готовый результат решения через метод calc строки input
                                         //полученной через сканнер
    }
    public static String calc (String input) throws Exception {
        int a;
        int b;
        String rezult;
        String operator;
        String[] operation = input.split("[+\\-*/]"); // делим нашу строку оператором +,-,/,*
        if (operation.length!=2) throw new Exception("throws Exception");
        operator = findoperator(input); // определяем оператор (+,-,* или/) из метода "findoperator"
        if (operator==null) throw  new Exception("throws Exception"); // если оператора нет, то выдаем исключение
        a = Integer.parseInt(operation[0]);
        b = Integer.parseInt(operation[1]);
        if (a<1 || a>10 || b<1 || b>10) throw new Exception("throws Exception"); // если операнды не от 1 до 10,
                                                                                // то выбрасываем исключение
        int intRezult = calculation(a, b, operator); // выводим результат в интовом виде из метода calculation
        rezult = String.valueOf(intRezult); // переводим интовый формат в String
        return rezult;
    }
    static String findoperator(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("/")) return "/";
        else if (input.contains("*")) return "*";
        else return null;
    }
    static int calculation(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> a * b;
        };
    }
}