public class Solver {
    public CalculationResult solve(double parameter1, double parameter2) {
        double result = parameter1 + parameter2;
        return new CalculationResult(parameter1, parameter2, result);
    }
}