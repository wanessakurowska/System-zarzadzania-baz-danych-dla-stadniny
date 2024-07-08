package bdbt_bada_project.Stadnina_App;

public class Employees {
    private int Nr_Pracownika;
    private String Imie;
    private String Nazwisko;
    private String PESEL;
    private String Email;
    private String Nr_Dokumentu_Pracownika;
    private String Nr_Konta;
    private String Data_Zatrudnienia;
    private int Nr_Stadniny;
    private int Nr_Stanowiska;
    private String Login;
    private String Haslo;
    private String Stanowisko;


    public Employees(){

    }

    public Employees(int nr_Pracownika, String imie, String nazwisko, String PESEL, String email, String nr_Dokumentu_Pracownika, String nr_Konta, String data_Zatrudnienia, int nr_Stadniny, int nr_Stanowiska, String Login, String Haslo, String Stanowisko) {
        super();
        this.Nr_Pracownika = nr_Pracownika;
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.Email = email;
        this.Nr_Dokumentu_Pracownika = nr_Dokumentu_Pracownika;
        this.Nr_Konta = nr_Konta;
        this.Data_Zatrudnienia = data_Zatrudnienia;
        this.Nr_Stadniny = nr_Stadniny;
        this.Nr_Stanowiska = nr_Stanowiska;
        this.Login = Login;
        this.Haslo = Haslo;
        this.Stanowisko = Stanowisko;
    }

    public int getNr_Pracownika() {
        return Nr_Pracownika;
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getEmail() {
        return Email;
    }

    public String getNr_Dokumentu_Pracownika() {
        return Nr_Dokumentu_Pracownika;
    }

    public String getNr_Konta() {
        return Nr_Konta;
    }

    public String getData_Zatrudnienia() {
        return Data_Zatrudnienia;
    }

    public int getNr_Stadniny() {
        return Nr_Stadniny;
    }

    public int getNr_Stanowiska() {
        return Nr_Stanowiska;
    }

    public String getLogin() {
        return Login;
    }

    public String getHaslo() {
        return Haslo;
    }

    public String getStanowisko() {
        return Stanowisko;
    }

    public void setNr_Pracownika(int nr_Pracownika) {
        Nr_Pracownika = nr_Pracownika;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNr_Dokumentu_Pracownika(String nr_Dokumentu_Pracownika) {
        Nr_Dokumentu_Pracownika = nr_Dokumentu_Pracownika;
    }

    public void setNr_Konta(String nr_Konta) {
        Nr_Konta = nr_Konta;
    }

    public void setData_Zatrudnienia(String data_Zatrudnienia) {
        Data_Zatrudnienia = data_Zatrudnienia;
    }

    public void setNr_Stadniny(int nr_Stadniny) {
        Nr_Stadniny = nr_Stadniny;
    }

    public void setNr_Stanowiska(int nr_Stanowiska) {
        Nr_Stanowiska = nr_Stanowiska;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

    public void setStanowisko(String stanowisko) {
        Stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "Nr_Pracownika=" + Nr_Pracownika +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", Email='" + Email + '\'' +
                ", Nr_Dokumentu_Pracownika='" + Nr_Dokumentu_Pracownika + '\'' +
                ", Nr_Konta='" + Nr_Konta + '\'' +
                ", Data_Zatrudnienia='" + Data_Zatrudnienia + '\'' +
                ", Nr_Stadniny=" + Nr_Stadniny +
                ", Nr_Stanowiska=" + Nr_Stanowiska +
                ", Login='" + Login + '\'' +
                ", Haslo='" + Haslo + '\'' +
                '}';
    }
}
