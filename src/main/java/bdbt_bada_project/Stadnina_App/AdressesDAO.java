package bdbt_bada_project.Stadnina_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdressesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdressesDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate= jdbcTemplate;
    }

    public List<Adresses> list() {
        String sql = "SELECT * FROM Adresy";
        List<Adresses> listAdresses = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresses.class));
        return listAdresses;
    }


    public void save(Adresses adress) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Adresy").usingColumns("Nr_adresu", "Miejscowosc", "Ulica", "Nr_lokalu", "Nr_poczty");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adress);
        insertActor.execute(param);
    }

    public Adresses get(int Nr_Adresu) {
        String sql = "SELECT * FROM Adresy WHERE Nr_Adresu = ?";
        Object[] args = {Nr_Adresu};
        Adresses adress = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Adresses.class));
        return adress;
    }

    public Adresses get1(int Nr_Adresu){
        Object[] args = {Nr_Adresu};
        String sql = "SELECT * FROM Adresy WHERE Nr_Adresu = " + args[0];
        Adresses adress = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Adresses.class));
        return adress;
    }

    public void update(Adresses adress) {
        String sql = "UPDATE Adresy SET Miejscowosc=:Miejscowosc, Ulica=:Ulica, Nr_Lokalu=:Nr_Lokalu, Nr_Poczty=:Nr_Poczty WHERE Nr_Adresu=:Nr_Adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adress);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_Adresu) {
        String sql = "DELETE FROM Adresy WHERE Nr_Adresu = ?";
        jdbcTemplate.update(sql,Nr_Adresu);
    }
}
