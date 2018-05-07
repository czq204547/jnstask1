package Impl;

import Config.BaseConfig;
import DAO.SignUpDao;
import POJO.SignUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/6.
 */

@Repository
public class SignUpDaoImpl implements SignUpDao{


    private JdbcTemplate jdbcTemplate;
    private final static Logger logger = LogManager.getLogger(SignUpDaoImpl.class);
    //数据库操作时影响的行数
    private Integer row;

    static final String ADD_SQL = "insert into sign_up(name,qq,type_,admission_time,graduated_school,student_id," +
            "daily,wish,counselor,from_,create_at,update_at) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    static final String UPDATE_SQL ="update sign_up set name = ?,qq = ?,type_=?,admission_time=?,graduated_school=?," +
            "student_id=?,daily=?,wish=?,counselor=?,from_=?,update_at=? where id = ?";
    static final String DELETE_SQL = "delete from sign_up where id = ?";
    static final String SELECT_BY_ID = "select id,name,qq,type_,admission_time,graduated_school,student_id," +
            "daily,wish,counselor,from_,create_at,update_at from sign_up where id = ?";
    static final String SELECT_BY_NAME = "select id,name,qq,type_,admission_time,graduated_school,student_id," +
            "daily,wish,counselor,from_,create_at,update_at from sign_up where name = ?";
    static final String SELECT_BY_QQ = "select id,name,qq,type_,admission_time,graduated_school,student_id," +
            "daily,wish,counselor,from_,create_at,update_at from sign_up where qq = ?";

    @Autowired
    public SignUpDaoImpl( JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(SignUp signUp){
        Integer signUpId;
        long createAt = System.currentTimeMillis();

        KeyHolder keyHolder = new GeneratedKeyHolder();
         row = jdbcTemplate.update(new PreparedStatementCreator() {
                                       @Override
                                       public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                                           PreparedStatement ps = conn.prepareStatement(ADD_SQL, Statement.RETURN_GENERATED_KEYS);
                                           ps.setString(1, signUp.getName());
                                           ps.setString(2, signUp.getQq());
                                           ps.setString(3, signUp.getType());
                                           java.sql.Date date = new java.sql.Date(signUp.getAdmissionTime().getTime());
                                           ps.setDate(4, date);
                                           ps.setString(5, signUp.getGraduatedSchool());
                                           ps.setInt(6, signUp.getStudentID());
                                           ps.setString(7, signUp.getDaily());
                                           ps.setString(8, signUp.getWish());
                                           ps.setString(9,signUp.getCounselor());
                                           ps.setString(10, signUp.getFrom());
                                           ps.setLong(11,createAt);
                                           ps.setLong(12, createAt);
                                           return ps;
                                       }
                                   }
                 , keyHolder);
        signUpId = keyHolder.getKey().intValue();
        if(row != null && signUpId != null){
            logger.info("插入了" + row + "行数据");
            logger.info("返回的自增id:" + signUpId);
        }else {
            logger.info("插入数据错误");
        }
        return signUpId;
    }

    public boolean delete(int id){

        row = jdbcTemplate.update(DELETE_SQL, new Object[]{id});
        if(row != null){
            logger.info("删除:" + row + "行数据");
            return true;
        }
        return false;
    }

    public boolean update(SignUp signUp){
        long updateAt = System.currentTimeMillis();
        Object[] params = new Object[]{signUp.getName(),signUp.getQq(),signUp.getType(),signUp.getAdmissionTime(),
                signUp.getGraduatedSchool(), signUp.getStudentID(),signUp.getDaily(),signUp.getWish(),signUp.getCounselor()
                ,signUp.getFrom(),updateAt,signUp.getId()};
        row = jdbcTemplate.update(UPDATE_SQL,params);
        if(row != null){
            logger.info("更新：" + row + "行数据");
            return true;
        }
        return false;
    }

    public SignUp selectById(int id){
        SignUp signUp = new SignUp();
    jdbcTemplate.query(SELECT_BY_ID, new Object[]{id},getRowCallbackHandler(signUp));

    if(signUp != null){
        logger.info("查找ID=" + id + "的报名记录成功");
        return signUp;
    }
    logger.info("查找ID=" + id + "的报名记录失败");
    return signUp;
    }

    public SignUp selectByName(String name){
        SignUp signUp = new SignUp();
        jdbcTemplate.query(SELECT_BY_NAME, new Object[]{name}, getRowCallbackHandler(signUp));
        if(signUp != null){
            logger.info("查找name=" + name + "的报名记录成功");
            return signUp;
        }
        logger.info("查找name=" + name + "的报名记录失败");
        return signUp;
    }

    public SignUp selectByQq(String qq){
        SignUp signUp = new SignUp();
        jdbcTemplate.query(SELECT_BY_QQ, new Object[]{qq}, getRowCallbackHandler(signUp));
        if (signUp != null){
            logger.info("查找qq=" + qq + "的报名记录成功");
            return signUp;
        }
        logger.info("查找qq=" +qq + "的报名记录失败");
        return signUp;
    }


    private RowCallbackHandler getRowCallbackHandler(SignUp signUp){

        return rs -> {
            signUp.setId(rs.getInt("id"));
            signUp.setName(rs.getString("name"));
            signUp.setQq(rs.getString("qq"));
            signUp.setType(rs.getString("type_"));
            signUp.setAdmissionTime(rs.getDate("admission_time"));
            signUp.setGraduatedSchool(rs.getString("graduated_school"));
            signUp.setStudentID(rs.getInt("student_id"));
            signUp.setDaily(rs.getString("daily"));
            signUp.setWish(rs.getString("wish"));
            signUp.setCounselor(rs.getString("counselor"));
            signUp.setFrom(rs.getString("from_"));
            signUp.setCreateAt(rs.getLong("create_at"));
            signUp.setUpdateAt(rs.getLong("update_at"));
        };
    }


}
