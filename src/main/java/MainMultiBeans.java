import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMultiBeans {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // use multiple values for bean id in XML
//        User user = ctx.getBean("user,user1,user2,user3", User.class);
//        User user2 = ctx.getBean("user,user1,user2,user3", User.class);


        // use multiple values for bean name in XMLs
        User user = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user2", User.class);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user == user2);
    }
}