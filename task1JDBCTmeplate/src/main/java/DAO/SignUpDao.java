package DAO;

import POJO.SignUp;

/**
 * Created by Administrator on 2018/5/6.
 */
public interface SignUpDao {

    int add(SignUp signUp);

    boolean delete(int id);

    boolean update(SignUp signUp);

    SignUp selectById(int id);

    SignUp selectByName(String name);

    SignUp selectByQq(String qq);


}
