package bdbt_bada_project.Stadnina_App;


public class Horses {
    private int Nr_Konia;
    private String Imie;
    private String Plec;
    private String Data_urodzenia;
    private int Nr_Stajni;
    private int Nr_Rasy;

    public Horses(){

    }

    public Horses(int Nr_Konia, String Imie, String Plec, String Data_urodzenia, int Nr_Stajni, int Nr_Rasy){
        super();
        this.Nr_Konia = Nr_Konia;
        this.Imie = Imie;
        this.Plec = Plec;
        this.Data_urodzenia = Data_urodzenia;
        this.Nr_Stajni = Nr_Stajni;
        this.Nr_Rasy = Nr_Rasy;
    }

    public int getNr_Konia() {
        return Nr_Konia;
    }

    public String getImie() {
        return Imie;
    }

    public String getPlec() {
        return Plec;
    }
    public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public int getNr_Stajni() {
        return Nr_Stajni;
    }

    public int getNr_Rasy() {
        return Nr_Rasy;
    }

    public void setNr_Konia(int nr_Konia) {
        Nr_Konia = nr_Konia;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public void setPlec(String plec) {
        Plec = plec;
    }
    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public void setNr_Stajni(int nr_Stajni) {
        Nr_Stajni = nr_Stajni;
    }

    public void setNr_Rasy(int nr_Rasy) {
        Nr_Rasy = nr_Rasy;
    }

    @Override
    public String toString() {
        return "Horses{" +
                "Nr_Konia=" + Nr_Konia +
                ", Imie='" + Imie + '\'' +
                ", Plec='" + Plec + '\'' +
                ", Data_urodzenia='" + Data_urodzenia + '\'' +
                ", Nr_Stajni=" + Nr_Stajni +
                ", Nr_Rasy=" + Nr_Rasy +
                '}';
    }
}
