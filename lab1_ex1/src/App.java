import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti un numar:");
        int numar = sc.nextInt();
        sc.close();

        if(numar>0){
            System.out.println("Numarul e pozitiv.");
         } 
        else if(numar<0){ 
            System.out.println("Numarul este negativ.");
        }
        else {
            System.out.println("Numarul este 0.");
        }

    }
}
