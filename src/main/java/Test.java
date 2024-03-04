public class Test {
    public static void main(String[] args) {
        // Створення екземпляра класу Solver
        Solver solver = new Solver();
        double param1 = 50.5;
        double param2 = 82.4;

        // Виклик методу solve для обчислення результату
        CalculationResult result = solver.solve(param1, param2);

        // Виведення результату
        System.out.println("Результат:");
        System.out.println("Параметр 1: " + result.getParameter1());
        System.out.println("Параметр 2: " + result.getParameter2());
        System.out.println("Результат: " + result.getResult());

        // Серіалізація та десеріалізація
        serializeAndDeserializeResult(result);
    }

    private static void serializeAndDeserializeResult(CalculationResult result) {
        // Серіалізація результату
        byte[] serializedResult = SerializationUtils.serialize(result);

        // Десеріалізація результату
        CalculationResult deserializedResult = SerializationUtils.deserialize(serializedResult);

        // Виведення десеріалізованого результату
        System.out.println("Десеріалізований результат:");
        System.out.println("Параметр 1: " + deserializedResult.getParameter1());
        System.out.println("Параметр 2: " + deserializedResult.getParameter2());
        System.out.println("Результат: " + deserializedResult.getResult());
    }
}