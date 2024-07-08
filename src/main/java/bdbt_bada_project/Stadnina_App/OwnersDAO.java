package bdbt_bada_project.Stadnina_App;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class OwnersDAO {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public OwnersDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Owners> list(){
//        String sql="SELECT * FROM Wlasciciele_koni";
//        List<Owners> listOwners = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Owners.class));
//        return listOwners;
//    }

    public List<Owners> list() {
        String sql = "SELECT W.*, (A.Miejscowosc || ', ' || A.Ulica) AS pelnyAdres " +
                "FROM Wlasciciele_koni W " +
                "JOIN Adresy A ON W.Nr_adresu = A.Nr_adresu";
        List<Owners> listOwners = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Owners.class));
        return listOwners;
    }



    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Owners owners) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Wlasciciele_koni").usingColumns("Nr_Wlasciciela", "Imie", "Nazwisko", "PESEL",  "Nr_dokumentu", "Telefon", "Email", "Nr_adresu", "Nr_Stadniny", "Login", "Haslo");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(owners);
        insertActor.execute(param);
    }
    public Owners get(int Nr_Wlasciciela) {
        String sql = "SELECT * FROM Wlasciciele_koni WHERE Nr_Wlasciciela = ?";
        Object[] args = {Nr_Wlasciciela};
        Owners owner = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Owners.class));
        return owner;
    }

    public Owners get1(int Nr_Wlasciciela){
        Object[] args = {Nr_Wlasciciela};
        String sql = "SELECT * FROM Wlasciciele_koni WHERE Nr_Wlasciciela = " + args[0];
        Owners owner = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Owners.class));
        return owner;
    }

    public static void update(Owners owner) {
        String sql = "UPDATE Wlasciciele_koni SET Imie=:Imie, Nazwisko=:Nazwisko, Email=:Email, Nr_Adresu=:Nr_Adresu, Login=:Login, Haslo=:Haslo WHERE Nr_Wlasciciela=:Nr_Wlasciciela";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(owner);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_Wlasciciela) {
        String sql = "DELETE FROM Wlasciciele_koni WHERE Nr_Wlasciciela = ?";
        jdbcTemplate.update(sql,Nr_Wlasciciela);
    }

    public static Owners findByUsername(String username) {
        String sql = "SELECT * FROM Wlasciciele_koni WHERE Login = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, BeanPropertyRowMapper.newInstance(Owners.class));
    }
}
