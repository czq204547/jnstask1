package POJO;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/6.
 */
public class SignUp {

    private Integer id;
    private String name;
    private String qq;
    private String type;
    private Date admissionTime;
    private String graduatedSchool;
    private Integer studentID;
    private String daily;
    private String wish;
    private String counselor;
    private String from;
    private Long createAt;
    private Long updateAt;

    public SignUp() {
    }

    public SignUp(String name, String qq, String type, Date admissionTime, String graduatedSchool, Integer studentID, String daily, String wish, String counselor, String from) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.admissionTime = admissionTime;
        this.graduatedSchool = graduatedSchool;
        this.studentID = studentID;
        this.daily = daily;
        this.wish = wish;
        this.counselor = counselor;
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
