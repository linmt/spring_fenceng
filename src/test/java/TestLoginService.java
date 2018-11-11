import com.lmt.entity.Admin;
import com.lmt.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 热带雨林 on 2018/11/11.
 */
public class TestLoginService {
    public static void main(String[] args){
        String conf="classpath:applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);

        LoginService service=ac.getBean("loginService",LoginService.class);
        Admin admin=service.checkLogin("admin","1234");
        System.out.println(admin);
    }
}
