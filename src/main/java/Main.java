import java.util.Scanner;

public class Main {
  static float num1, num2;
  static float sum, diff1, diff2, prod, quot1, quot2;

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.println("Введіть перше число: ");
    num1 = userInput.nextFloat();
    System.out.println("Введіть друге число: ");
    num2 = userInput.nextFloat();

    sum = num1 + num2;
    diff1 = num1 - num2;
    diff2 = num2 - num1;
    prod = num1 * num2;
    quot1 = num1 / num2;
    quot2 = num2 / num1;

    System.out.println(num1 + " + " + num2 + " = " + sum);
    System.out.println(num1 + " - " + num2 + " = " + diff1);
    System.out.println(num2 + " - " + num1 + " = " + diff2);
    System.out.println(num1 + " * " + num2 + " = " + prod);
    System.out.println(num1 + " / " + num2 + " = " + quot1);
    System.out.println(num2 + " / " + num1 + " = " + quot2);
  }
}