package JavaTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainAnnotation {
    private JdbcTemplate jdbcTemplate;
    private UserService userService;

    @Before
    public void before(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        userService = ctx.getBean(UserService.class);
    }

    @Test
    public void test1(){
        userService.updateMoney();
    }
}
