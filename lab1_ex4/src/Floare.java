public class Floare {
    private String nume;
    private double pret;

    public Floare(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(double pret) {
         this.pret = pret;
    }

    public static void main(String[] args) {
        Floare trandafir = new Floare("Trandafir rosu", 15.5);

        System.out.println("Informatii floare:");
        System.out.println("Nume: " + trandafir.getNume());
        System.out.println("Pret: " + trandafir.getPret());

        trandafir.setNume("Trandafir alb");
        trandafir.setPret(20.0);

        System.out.println("\nUpdate informatii floare:");
        System.out.println("Nume: " + trandafir.getNume());
        System.out.println("Pret: " + trandafir.getPret());
    }
}