package JavaAuto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAuto {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaAutoConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.getAllUser());
    }
}
