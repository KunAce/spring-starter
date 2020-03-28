import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        SayHello hello = ctx.getBean(SayHello.class);
        System.out.println(hello.sayHelloPrint("javatest"));
    }
}
