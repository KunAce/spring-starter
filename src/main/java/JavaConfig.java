import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean("beanNameTest")
    SayHello sayHello() {
        return new SayHello();
    }
}
