package cn.yangdeyu.bean;

import java.util.Date;

public class Activities {
    private String travelid;
    private String openid;
    private String city;
    private Date starttime;
    private Date endtime;
    private String travelname;
    private String description;
    private int flag;
    private String kind;
    private String cost;
    private String totalnumber;

    public String getTravelid() {
        return travelid;
    }

    public String getOpenid() {
        return openid;
    }

    public String getCity() {
        return city;
    }

    public Date getStarttime() {
        return starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public String getTravelname() {
        return travelname;
    }

    public String getDescription() {
        return description;
    }

    public int getFlag() {
        return flag;
    }

    public String getKind() {
        return kind;
    }

    public String getCost() {
        return cost;
    }

    public void setTravelid(String travelid) {
        this.travelid = travelid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public void setTravelname(String travelname) {
        this.travelname = travelname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(String totalnumber) {
        this.totalnumber = totalnumber;
    }

    @Override
    public String toString() {
        return "{" +
                "\"success\":1 ," +
                "\"content\":{" +
                "\"travelid\"=\"" + travelid + "\"" +
                ", \"openid\"=\"" + openid + "\""+
                ", \"city\"=\"" + city + "\"" +
                ", \"starttime\"=\"" + starttime +"\""+
                ", \"endtime\"=\"" + endtime +"\""+
                ", \"travelname\"=\"" + travelname + "\"" +
                ", \"description\"=\"" + description + "\"" +
                ", \"flag\"=" + flag +
                ", \"kind\"=\"" + kind + "\"" +
                ", \"cost\"=" + cost +
                ", \"totalnumber\"="+ totalnumber +
                "}}";
    }


}
