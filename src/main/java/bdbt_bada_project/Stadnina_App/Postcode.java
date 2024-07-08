package bdbt_bada_project.Stadnina_App;

public class Postcode {
    private int Nr_Poczty;
    private String Kod_Poczty;
    private String Miejscowosc;

    public Postcode() {
    }

    public Postcode(int Nr_Poczty, String Kod_Poczty, String Miejscowosc) {
        this.Nr_Poczty = Nr_Poczty;
        this.Kod_Poczty = Kod_Poczty;
        this.Miejscowosc = Miejscowosc;
    }

    public int getNr_Poczty() {
        return Nr_Poczty;
    }

    public String getKod_Poczty() {
        return Kod_Poczty;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public void setNr_Poczty(int nr_Poczty) {
        Nr_Poczty = nr_Poczty;
    }

    public void setKod_Poczty(String kod_Poczty) {
        Kod_Poczty = kod_Poczty;
    }

    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
    }

    @Override
    public String toString() {
        return "Postcode{" +
                "Nr_Poczty=" + Nr_Poczty +
                ", Kod_Poczty='" + Kod_Poczty + '\'' +
                ", Miejscowosc='" + Miejscowosc + '\'' +
                '}';
    }
}
