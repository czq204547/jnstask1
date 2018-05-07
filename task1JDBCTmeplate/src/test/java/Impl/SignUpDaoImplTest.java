package Impl;

import static org.junit.Assert.*;

import Config.BaseConfig;
import POJO.SignUp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/5/7.
 */
public class SignUpDaoImplTest {

    static public SignUpDaoImpl signUpDao;

    @BeforeClass
    static public void context(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
        signUpDao = context.getBean(SignUpDaoImpl.class);
    }

    @Test
    public void add() throws Exception {
        SignUp signUp = new SignUp("john","123","java",new Date(),"ab school",123131,"wwww.abc.com","I hope","jack","zhihu");
        assertNotNull(signUpDao.add(signUp));
    }

    @Test
    public void delete() throws Exception {
        int id = 10032;
        assertTrue(signUpDao.delete(id));
    }

    @Test
    public void update() throws Exception {
        SignUp signUp = new SignUp("john","123","java",new Date(),"ab school",123131,"wwww.abc.com","I hope","jack","zhihu");
        signUp.setId(10030);
        signUp.setName("update by JDBCTemplate");
        assertTrue(signUpDao.update(signUp));
    }

    @Test
    public void selectById() throws Exception {
        int id = 10024;
        assertNotNull(signUpDao.selectById(id));
    }

    @Test
    public void selectByName() throws Exception {
        String name = "刘仁瑞";
        assertNotNull(signUpDao.selectByName(name));
    }

    @Test
    public void selectByQq() throws Exception {
        String qq = "936997223";
        assertNotNull(signUpDao.selectByQq(qq));
    }

}