package serviceImpl;

import static org.junit.Assert.*;

import Config.BasicConfig;
import Config.RootConfig;
import POJO.SignUp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class SignUpServiceImplTest {

    static   SignUpServiceImpl signUpService;

    @BeforeClass
    public static void context(){
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        signUpService = context.getBean(SignUpServiceImpl.class);
    }

    @Test
    public void insert() throws Exception {
        SignUp signUp = new SignUp("def","1234567","前端",new Date(),"c school",4545,"www.cc","I wish","mm","zhihu");
        assertNotEquals(0,signUpService.insert(signUp));
    }

    @Test
    public void delete() throws Exception {
        int id = 10004;
        assertTrue(signUpService.delete(id));

    }

    @Test
    public void update() throws Exception {
        SignUp signUp = new SignUp("jack","3426","前端",new Date(),"c school",4545,"www.cc","I wish","mm","zhihu");
        signUp.setId(10003);
        signUp.setName("update更改数据1");
        assertTrue(signUpService.update(signUp));
    }

    @Test
    public void selectById() throws Exception {
        int id = 10000;
        assertNotNull(signUpService.selectById(id));
    }

    @Test
    public void selectByName() throws Exception {
        String name = "jack";
        assertNotNull(signUpService.selectByName(name));
    }

    @Test
    public void selectByQq() throws Exception {
        String qq = "123456";
        assertNotNull(signUpService.selectByQq(qq));
    }

}