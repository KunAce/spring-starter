package JavaTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    private JdbcTemplate jdbcTemplate;
    private UserService userService;

    @Before
    public void before(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTransaction.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        userService = ctx.getBean(UserService.class);
    }

    @Test
    public void test1(){
        userService.updateMoney();
    }
}
