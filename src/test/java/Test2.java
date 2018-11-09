import com.lmt.dao.AdminDao;
import com.lmt.entity.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 张洲徽 on 2018/11/1.
 */
public class Test2 {
    public static void main(String[] args){
        String conf="classpath:applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);

        //小写
        AdminDao dao=ac.getBean("adminDao",AdminDao.class);
        Admin admin=dao.findByAdminCode("admin");
        System.out.println(admin);
    }
}
