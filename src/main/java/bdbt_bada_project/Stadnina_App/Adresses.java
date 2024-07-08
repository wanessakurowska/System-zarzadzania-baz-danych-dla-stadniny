package bdbt_bada_project.Stadnina_App;

public class Adresses {
    private int Nr_Adresu;
    private String Miejscowosc;
    private String Ulica;
    private int Nr_Lokalu;
    private int Nr_Poczty;

    public Adresses(){

    }

    public Adresses(int nr_Adresu, String Miejscowosc, String Ulica, int Nr_lokalu, int Nr_poczty) {
        this.Nr_Adresu = nr_Adresu;
        this.Miejscowosc = Miejscowosc;
        this.Ulica = Ulica;
        this.Nr_Lokalu = Nr_lokalu;
        this.Nr_Poczty = Nr_poczty;
    }

    public int getNr_Adresu() {
        return Nr_Adresu;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public String getUlica() {
        return Ulica;
    }

    public int getNr_Lokalu() {
        return Nr_Lokalu;
    }

    public int getNr_Poczty() {
        return Nr_Poczty;
    }

    public void setNr_Adresu(int nr_Adresu) {
        Nr_Adresu = nr_Adresu;
    }

    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public void setNr_Lokalu(int nr_Lokalu) {
        Nr_Lokalu = nr_Lokalu;
    }

    public void setNr_Poczty(int nr_Poczty) {
        Nr_Poczty = nr_Poczty;
    }

    @Override
    public String toString() {
        return "Adresses{" +
                "Nr_Adresu=" + Nr_Adresu +
                ", Miejscowosc='" + Miejscowosc + '\'' +
                ", Ulica='" + Ulica + '\'' +
                ", Nr_Lokalu=" + Nr_Lokalu +
                ", Nr_Poczty=" + Nr_Poczty +
                '}';
    }
}
