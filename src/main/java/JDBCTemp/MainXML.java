package JDBCTemp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MainXML {
    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextJdbc.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void insert() {
        jdbcTemplate.update("INSERT INTO user (username, address) values (?,?);","javatestuser","www.javatestuser.org");
    }

    @Test
    public void update() {
        jdbcTemplate.update("UPDATE user SET username=? where id=?","javatestuser123","1");
    }

    @Test
    public void delete() {
        jdbcTemplate.update("DELETE FROM user where id=?",2);
    }

    @Test
    public void select() {
        User user = jdbcTemplate.queryForObject("SELECT * FROM user where id=?", new BeanPropertyRowMapper<User>(User.class),1);
    }

    // Rename the queried columns
    @Test
    public void select2() {
        User user = jdbcTemplate.queryForObject("SELECT id, username as name,address FROM user where id=?",new BeanPropertyRowMapper<User>(User.class),1);
        System.out.println(user);
    }

    // Customize RowMapper
    @Test
    public void select3() {
        User user = jdbcTemplate.queryForObject("SELECT * FROM user where id=?", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                User u = new User();
                u.setId(id);
                u.setUsername(username);
                u.setAddress(address);
                return u;
            }
        },1);
        System.out.println(user);
    }

    @Test
    public void select4() {
        List<User> list = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
    }
}
