package JavaAuto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class UserDao {
    public String hello() {
        return "userdao";
    }
}
