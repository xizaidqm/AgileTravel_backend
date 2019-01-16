package cn.yangdeyu.bean;

public class AttendList {
    private String comment;
    private Activities activities;
    private User user;

    public String getComment() {
        return comment;
    }

    public Activities getActivities() {
        return activities;
    }

    public User getUser() {
        return user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setActivities(Activities activities) {
        this.activities = activities;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AttendList(Activities activities, User user) {
        this.activities = activities;
        this.user = user;
    }

}
