package bdbt_bada_project.Stadnina_App;


public class Owners {
    private int Nr_Wlasciciela;
    private String Imie;
    private String Nazwisko;
    private String PESEL;
    private String Nr_Dokumentu;
    private String Telefon;
    private String Email;
    private int Nr_Adresu;
    private int Nr_Stadniny;
    private String Login;
    private String Haslo;
    private String pelnyAdres;

    public Owners(){

    }

    public Owners(int Nr_Wlasciciela, String Imie, String Nazwisko, String PESEL, String Nr_Dokumentu, String Telefon, String Email, int Nr_Adresu, int Nr_Stadniny, String Login, String Haslo, String pelnyAdres){
        super();
        this.Nr_Wlasciciela = Nr_Wlasciciela;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.PESEL = PESEL;
        this.Telefon=Telefon;
        this.Email = Email;
        this.Nr_Dokumentu = Nr_Dokumentu;
        this.Nr_Adresu = Nr_Adresu;
        this.Nr_Stadniny = Nr_Stadniny;
        this.Login = Login;
        this.Haslo = Haslo;
        this.pelnyAdres=pelnyAdres;
    }

    public int getNr_Wlasciciela() {
        return Nr_Wlasciciela;
    }

    public String getNr_Dokumentu() {
        return Nr_Dokumentu;
    }

    public String getTelefon() {
        return Telefon;
    }

    public int getNr_Adresu() {
        return Nr_Adresu;
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


    public int getNr_Stadniny() {
        return Nr_Stadniny;
    }

    public String getLogin() {
        return Login;
    }

    public String getHaslo() {
        return Haslo;
    }

    public String getPelnyAdres() {
        return pelnyAdres;
    }

    public void setNr_Wlasciciela(int nr_Wlasciciela) {
        Nr_Wlasciciela = nr_Wlasciciela;
    }

    public void setNr_Dokumentu(String nr_Dokumentu) {
        Nr_Dokumentu = nr_Dokumentu;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public void setNr_Adresu(int nr_Adresu) {
        Nr_Adresu = nr_Adresu;
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

    public void setNr_Stadniny(int nr_Stadniny) {
        Nr_Stadniny = nr_Stadniny;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

    public void setPelnyAdres(String pelnyAdres) {
        pelnyAdres = pelnyAdres;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "Nr_Wlasciciela=" + Nr_Wlasciciela +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", Nr_Dokumentu='" + Nr_Dokumentu + '\'' +
                ", Telefon='" + Telefon + '\'' +
                ", Email='" + Email + '\'' +
                ", Nr_Adresu=" + Nr_Adresu +
                ", Nr_Stadniny=" + Nr_Stadniny +
                ", Login='" + Login + '\'' +
                ", Haslo='" + Haslo + '\'' +
                '}';
    }
}
