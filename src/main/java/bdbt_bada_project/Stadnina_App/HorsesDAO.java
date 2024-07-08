package bdbt_bada_project.Stadnina_App;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class HorsesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HorsesDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Horses> list(){
        String sql="SELECT * FROM Konie";
        List<Horses> listHorses = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Horses.class));
        return listHorses;
    }

    public void save(Horses horses) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Konie").usingColumns("Nr_konia", "Imie", "Plec", "Data_urodzenia", "Nr_stajni", "Nr_rasy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(horses);
        insertActor.execute(param);
    }


    public Horses get(int Nr_Konia) {
        String sql = "SELECT * FROM Konie WHERE Nr_konia = ?";
        Object[] args = {Nr_Konia};
        Horses horse = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Horses.class));
        return horse;
    }

    public Horses get1(int Nr_Konia){
        Object[] args = {Nr_Konia};
        String sql = "SELECT * FROM Konie WHERE Nr_konia = " + args[0];
        Horses horse = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Horses.class));
        return horse;
    }

    public void update(Horses horse) {
        String sql = "UPDATE Konie SET Imie=:Imie, Nr_stajni=:Nr_Stajni WHERE Nr_konia=:Nr_Konia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(horse);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_konia) {
        String sql = "DELETE FROM Konie WHERE Nr_konia = ?";
        jdbcTemplate.update(sql,Nr_konia);
    }
}
