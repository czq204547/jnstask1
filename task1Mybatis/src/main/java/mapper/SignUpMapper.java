package mapper;


import POJO.SignUp;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2018/5/7.
 */
public interface SignUpMapper {

    @Insert("insert into sign_up(name,qq,type_,admission_time,graduated_school,student_id,daily,wish,counselor," +
            "from_,create_at,update_at) values(#{name},#{qq},#{type},#{admissionTime},#{graduatedSchool},#{studentID},#{daily}," +
            "#{wish},#{counselor},#{from},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(SignUp signUp);

    @Delete("delete from sign_up where id=#{id}")
    int delete(int id);

    @Update("update sign_up set name=#{name},qq=#{qq},type_=#{type},admission_time=#{admissionTime},graduated_school=" +
            "#{graduatedSchool},student_id=#{studentID},daily=#{daily},wish=#{wish},counselor=#{counselor},from_=#{from}," +
            "update_at=#{updateAt} where id =#{id}")
    int update(SignUp signUp);

    @Select("select id,name,qq,type_,admission_time,graduated_school,student_id,daily,wish,counselor,from_,create_at," +
            "update_at from sign_up where id = #{id}")
    @Results({
            @Result(column = "type_", property = "type"),
            @Result(column = "admission_time",property = "admissionTime"),
            @Result(column = "graduated_school",property = "graduatedSchool"),
            @Result(column = "student_id", property = "studentID"),
            @Result(column = "from_", property = "from"),
            @Result(column = "create_at",property = "createAt"),
            @Result(column = "update_at",property = "updateAt")

    })
    SignUp selectById(int id);

    @Select("select id,name,qq,type_,admission_time,graduated_school,student_id,daily,wish,counselor,from_,create_at," +
            "update_at from sign_up where name = #{name}")
    @Results({
            @Result(column = "type_", property = "type"),
            @Result(column = "admission_time",property = "admissionTime"),
            @Result(column = "graduated_school",property = "graduatedSchool"),
            @Result(column = "student_id", property = "studentID"),
            @Result(column = "from_", property = "from"),
            @Result(column = "create_at",property = "createAt"),
            @Result(column = "update_at",property = "updateAt")

    })
    SignUp selectByName(String name);

    @Select("select id,name,qq,type_,admission_time,graduated_school,student_id,daily,wish,counselor,from_,create_at," +
            "update_at from sign_up where qq = #{qq}")
    @Results({
            @Result(column = "type_", property = "type"),
            @Result(column = "admission_time",property = "admissionTime"),
            @Result(column = "graduated_school",property = "graduatedSchool"),
            @Result(column = "student_id", property = "studentID"),
            @Result(column = "from_", property = "from"),
            @Result(column = "create_at",property = "createAt"),
            @Result(column = "update_at",property = "updateAt")

    })
    SignUp selectByQq(String qq);

}
