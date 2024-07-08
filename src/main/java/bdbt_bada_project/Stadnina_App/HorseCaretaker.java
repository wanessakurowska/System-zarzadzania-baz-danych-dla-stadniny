package bdbt_bada_project.Stadnina_App;

public class HorseCaretaker {
    private int Nr_Konia;
    private int Nr_Pracownika;

    public HorseCaretaker(){

    }

    public HorseCaretaker(int nr_Konia, int nr_Pracownika) {
        super();
        this.Nr_Konia = nr_Konia;
        this.Nr_Pracownika = nr_Pracownika;
    }

    public int getNr_Konia() {
        return Nr_Konia;
    }

    public int getNr_Pracownika() {
        return Nr_Pracownika;
    }

    public void setNr_Konia(int nr_Konia) {
        Nr_Konia = nr_Konia;
    }

    public void setNr_Pracownika(int nr_Pracownika) {
        Nr_Pracownika = nr_Pracownika;
    }

    @Override
    public String toString() {
        return "HorseCaretaker{" +
                "Nr_Konia=" + Nr_Konia +
                ", Nr_Opiekuna=" + Nr_Pracownika +
                '}';
    }
}
