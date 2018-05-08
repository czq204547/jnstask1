package serviceImpl;

import Impl.SignUpMapperImpl;
import POJO.SignUp;
import mapper.SignUpMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SignUpService;

/**
 * Created by Administrator on 2018/5/8.
 */

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpMapperImpl signUpMapper;
    private static final Logger logger = LogManager.getLogger(SignUpServiceImpl.class);


    public int insert(SignUp signUp){
        Integer row = signUpMapper.insert(signUp);
        if(row != null){
            logger.info("报名表中添加一行记录，自增ID=" +signUp.getId());
            return signUp.getId();
        }
        logger.info("添加数据错误");
        return 0;
    }

    public boolean delete(int id){
        Integer row = signUpMapper.delete(id);
        if (row != null){
            logger.info("报名表删除一行记录，ID=" + id);
            return true;
        }
        logger.info("报名表删除一行记录错误，ID="  +id);
        return false;
    }

    public boolean update(SignUp signUp){
        Integer row = signUpMapper.update(signUp);
        if (row != null){
            logger.info("报名表更新一行记录，ID=" +signUp.getId());
            return true;
        }
        logger.info("报名表更新一行数据错误，ID=" + signUp.getId());
        return false;
    }

    public SignUp selectById(int id) {
        SignUp signUp = signUpMapper.selectById(id);
        if (signUp != null) {
            logger.info("查询报名表数据，ID=" + id);
            return signUp;
        }
        logger.info("查询报名表数据错误，ID=" + id);
        return signUp;
    }

    public SignUp selectByName(String name){
        SignUp signUp = signUpMapper.selectByName(name);
        if (signUp != null) {
            logger.info("查询报名表数据，name=" + name);
            return signUp;
        }
        logger.info("查询报名表数据错误，name=" + name);
        return signUp;
    }

    public SignUp selectByQq(String qq){
        SignUp signUp = signUpMapper.selectByQq(qq);
        if (signUp != null) {
            logger.info("查询报名表数据,qq=" + qq);
            return signUp;
        }
       logger.info("查询报名表数据错误，qq=" + qq);
        return signUp;
    }

}
