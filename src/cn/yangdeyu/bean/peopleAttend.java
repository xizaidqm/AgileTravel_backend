package cn.yangdeyu.bean;

public class peopleAttend {
    private String travelid;
    private String openid;
    private String comment;

    public void setTravelid(String travelid) {
        this.travelid = travelid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTravelid() {
        return travelid;
    }

    public String getOpenid() {
        return openid;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "peopleAttend{" +
                "travelid='" + travelid + '\'' +
                ", openid='" + openid + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
