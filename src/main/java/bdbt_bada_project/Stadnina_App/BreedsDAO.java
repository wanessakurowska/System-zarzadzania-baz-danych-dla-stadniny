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
public class BreedsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BreedsDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Breeds> list(){
        String sql="SELECT * FROM Rasy_koni";
        List<Breeds> listBreeds = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Breeds.class));
        return listBreeds;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Breeds breeds) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Rasy_koni").usingColumns("Nr_Rasy", "Nazwa", "Opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(breeds);
        insertActor.execute(param);
    }

    public Breeds get(int Nr_Rasy) {
        String sql = "SELECT * FROM Rasy_koni WHERE Nr_Rasy = ?";
        Object[] args = {Nr_Rasy};
        Breeds breed = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Breeds.class));
        return breed;
    }

    public Breeds get1(int Nr_Rasy){
        Object[] args = {Nr_Rasy};
        String sql = "SELECT * FROM Rasy_koni WHERE Nr_Rasy = " + args[0];
        Breeds breed = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Breeds.class));
        return breed;
    }

    public void update(Breeds breed) {
        String sql = "UPDATE Rasy_koni SET Nazwa=:Nazwa, Opis=:Opis WHERE Nr_Rasy=:Nr_Rasy";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(breed);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_Rasy) {
        String sql = "DELETE FROM Rasy_koni WHERE Nr_Rasy = ?";
        jdbcTemplate.update(sql,Nr_Rasy);
    }
}
