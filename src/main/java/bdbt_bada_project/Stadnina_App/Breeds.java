package bdbt_bada_project.Stadnina_App;

public class Breeds {
    private int Nr_Rasy;
    private String Nazwa;
    private String Opis;

    public Breeds(){
    }

    public Breeds(int Nr_Rasy, String Nazwa, String Opis){
        super();
        this.Nr_Rasy= Nr_Rasy;
        this.Nazwa = Nazwa;
        this.Opis = Opis;
    }

    public int getNr_Rasy() {
        return Nr_Rasy;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public String getOpis() {
        return Opis;
    }

    public void setNr_Rasy(int nr_Rasy) {
        Nr_Rasy = nr_Rasy;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    @Override
    public String toString() {
        return "Breeds{" +
                "Nr_Rasy=" + Nr_Rasy +
                ", Nazwa='" + Nazwa + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
