import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
//@ImportResource("classpath:applicationContext.xml") // For mixed configuration of Java config and XML.
public class JavaConfig {
    @Bean("beanNameTest")
//    @Scope("prototype")
    SayHello sayHello() {
        return new SayHello();
    }
}
