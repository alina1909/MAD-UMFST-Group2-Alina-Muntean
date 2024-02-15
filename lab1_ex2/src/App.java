import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti numarul de elemente:");
        int numere = sc.nextInt();

        double[] array = new double[numere];

        System.out.println("Introduceti elementele:");
        for (int i = 0; i < numere; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = sc.nextDouble();
        }

        sc.close();

        double suma = 0;
        for (int i = 0; i < numere; i++) {
            suma += array[i];
        }

        double medie = suma / numere;
        System.out.println("Valoarea medie a elementelor este: " + medie);
    }
}
