package service;

import POJO.SignUp;

/**
 * Created by Administrator on 2018/5/8.
 */
//定义这个service是为了满足返回Boolean值的要求
public interface SignUpService {

    int insert(SignUp signUp);

    boolean delete(int id);

    boolean update(SignUp signUp);

    SignUp selectById(int id);

    SignUp selectByName(String name);

    SignUp selectByQq(String qq);


}
