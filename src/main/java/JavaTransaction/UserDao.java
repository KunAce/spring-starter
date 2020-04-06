package JavaTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(String username, Integer money) {
        jdbcTemplate.update("UPDATE account SET money = money + ? WHERE username = ?", money, username);
    }

    public void minMoney(String username, Integer money) {
        jdbcTemplate.update("UPDATE account SET money = money - ? WHERE username = ?", money,username );
    }
}
