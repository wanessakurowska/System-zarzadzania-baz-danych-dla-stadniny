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
public class HorseCaretakerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HorseCaretakerDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(HorseCaretaker horseCaretaker) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Opiekunowie_koni").usingColumns("Nr_Pracownika", "Nr_Konia");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(horseCaretaker);
        insertActor.execute(param);
    }
}
