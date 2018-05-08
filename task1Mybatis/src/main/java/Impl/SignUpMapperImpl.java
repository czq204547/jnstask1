package Impl;

import POJO.SignUp;
import mapper.SignUpMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/5/7.
 */
@Repository
public class SignUpMapperImpl implements SignUpMapper{

    @Autowired
    private SignUpMapper signUpMapper;
    private static final Logger logger = LogManager.getLogger(SignUpMapperImpl.class);


    public int insert(SignUp signUp){
        long dateTime = System.currentTimeMillis();
        int row;
        signUp.setCreateAt(dateTime);
        signUp.setUpdateAt(dateTime);
        row = signUpMapper.insert(signUp);
        return row;
    }

    public int delete(int id){
        return signUpMapper.delete(id);
    }

    public int update(SignUp signUp){
        return signUpMapper.update(signUp);
    }

    public SignUp selectById(int id){
        return signUpMapper.selectById(id);
    }

    public SignUp selectByName(String name){
        return signUpMapper.selectByName(name);
    }

    public SignUp selectByQq(String qq){
        return signUpMapper.selectByQq(qq);
    }
}
