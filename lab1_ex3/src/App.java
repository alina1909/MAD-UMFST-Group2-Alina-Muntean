public class App {

    public static void main(String[] args) {
        System.out.println("Numere prime gemene mai mici decat 100:");
        findPrime(100);
    }

    private static boolean ePrim(int numar) {
        if (numar <= 1) {
            return false;
        }
        for (int i = 2; i < numar; i++) {
            if (numar % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void findPrime(int limita) {
        for (int i = 2; i < limita - 1; i++) {
            if (ePrim(i) && ePrim(i + 2)) {
                System.out.println("(" + i + "," + (i + 2) + ")");
            }
        }
    }
}
