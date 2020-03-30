package JavaAuto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class XMLTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextXMLTest.xml");
        UserService userService = ctx.getBean(UserService.class);
        List<String> list = userService.getAllUser();
        System.out.println(list);
    }
}
