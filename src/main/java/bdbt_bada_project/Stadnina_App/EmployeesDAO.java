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
public class EmployeesDAO {
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public EmployeesDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employees> list() {
        String sql = "SELECT Pracownicy.*, Stanowiska.Nazwa AS Stanowisko " +
                "FROM Pracownicy " +
                "JOIN Stanowiska ON Pracownicy.Nr_Stanowiska = Stanowiska.Nr_Stanowiska";
        List<Employees> listEmployees = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employees.class));
        return listEmployees;
    }



    public void save(Employees employee) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Pracownicy").usingColumns("Nr_Pracownika", "Imie", "Nazwisko", "PESEL", "Email", "Nr_dokumentu_pracownika", "Nr_konta", "Data_zatrudnienia", "Nr_Stadniny", "Nr_Stanowiska", "Login", "Haslo");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
        insertActor.execute(param);
    }


    public Employees get(int Nr_Pracownika) {
        String sql = "SELECT * FROM Pracownicy WHERE Nr_Pracownika = ?";
        Object[] args = {Nr_Pracownika};
        Employees employee = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Employees.class));
        return employee;
    }

    public Employees get1(int Nr_Pracownika){
        Object[] args = {Nr_Pracownika};
        String sql = "SELECT * FROM Pracownicy WHERE Nr_Pracownika = " + args[0];
        Employees employee = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Employees.class));
        return employee;
    }

    public static void update(Employees employee) {
        String sql = "UPDATE Pracownicy SET Imie=:Imie, Nazwisko=:Nazwisko, Email=:Email, Nr_konta=:Nr_Konta, Nr_Stanowiska=:Nr_Stanowiska, Login=:Login, Haslo=:Haslo WHERE Nr_Pracownika=:Nr_Pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Nr_Pracownika) {
        String sql = "DELETE FROM Pracownicy WHERE Nr_Pracownika = ?";
        jdbcTemplate.update(sql,Nr_Pracownika);
    }

    public static Employees findByUsername(String username) {
        String sql = "SELECT * FROM Pracownicy WHERE Login = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, BeanPropertyRowMapper.newInstance(Employees.class));
    }
}
