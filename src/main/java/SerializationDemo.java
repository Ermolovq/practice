import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        // Створення екземпляра класу Solver
        Solver solver = new Solver();
        double param1 = 10.5;
        double param2 = 20.7;

        // Виклик методу solve для обчислення результату
        CalculationResult result = solver.solve(param1, param2);

        // Серіалізація результату
        serializeResult(result);

        // Відновлення результату з файлу
        CalculationResult restoredResult = deserializeResult();

        // Виведення відновленого результату
        System.out.println("Відновлений результат:");
        System.out.println("Параметр 1: " + restoredResult.getParameter1());
        System.out.println("Параметр 2: " + restoredResult.getParameter2());
        System.out.println("Результат: " + restoredResult.getResult());
    }

    private static void serializeResult(CalculationResult result) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("result.ser"))) {
            outputStream.writeObject(result);
            System.out.println("Результат серіалізовано");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CalculationResult deserializeResult() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("result.ser"))) {
            CalculationResult result = (CalculationResult) inputStream.readObject();
            System.out.println("Результат десеріалізовано");
            return result;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}