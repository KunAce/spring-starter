package MultiEnv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource ds = (DataSource) ctx.getBean("ds");
        System.out.println(ds);
    }
}
