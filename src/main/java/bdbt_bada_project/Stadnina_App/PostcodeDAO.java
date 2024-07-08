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
public class PostcodeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostcodeDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate= jdbcTemplate;
    }

    public List<Postcode> list() {
        String sql = "SELECT * FROM Poczta";
        List<Postcode> listPostcode = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Postcode.class));
        return listPostcode;
    }

    // Zapisz nową pocztę
    public void save(Postcode postcode) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Poczta").usingColumns("Nr_poczty", "Kod_poczty", "Miejscowosc");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(postcode);
        insertActor.execute(param);
    }


    public Postcode get(int Nr_Poczty) {
        String sql = "SELECT * FROM Poczta WHERE Nr_poczty = ?";
        Object[] args = {Nr_Poczty};
        Postcode postcode = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Postcode.class));
        return postcode;
    }

    public Postcode get1(int Nr_Poczty){
        Object[] args = {Nr_Poczty};
        String sql = "SELECT * FROM Poczta WHERE Nr_poczty = " + args[0];
        Postcode postcode = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Postcode.class));
        return postcode;
    }

    public void update(Postcode postcode) {
        String sql = "UPDATE Poczta SET Kod_poczty=:Kod_Poczty, Miejscowosc=:Miejscowosc WHERE Nr_poczty=:Nr_Poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(postcode);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_Poczty) {
        String sql = "DELETE FROM Poczta WHERE Nr_poczty = ?";
        jdbcTemplate.update(sql,Nr_Poczty);
    }
}
