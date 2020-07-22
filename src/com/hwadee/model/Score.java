package com.hwadee.model;

/**
 * @Author LH
 * @Description 成绩单
 * @Date Create in 14:16 2020/7/22
 */
public class Score {
    private String cno;//课程号
    private String cname;//课程名称
    private String cteacher;//执教老师
    private int Ccredit;//学分
    private double score;//分数
    private String status;//状态

    public Score(String cno, String cname, String cteacher, int ccredit, double score) {
        this.cno = cno;
        this.cname = cname;
        this.cteacher = cteacher;
        Ccredit = ccredit;
        this.score = score;
        this.status = "正常";
    }

    public Score() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Score{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", Ccredit=" + Ccredit +
                ", score=" + score +
                ", status='" + status + '\'' +
                '}';
    }
}
