package cn.yangdeyu.bean;

public class User {
	private String openid;
	private String nickname;
	private int gender;
	private String country;
	private String province;
	private String city;
	private int age;
	private String phonenumber;



	public String getOpenid() {

		return openid;
	}
	public void setOpenid(String openid) {

		this.openid = openid;
	}
	public String getNickname() {

		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	public int getGender() {

		return gender;
	}
	public void setGender(int gender) {

		this.gender = gender;
	}
	public String getCountry() {

		return country;
	}
	public void setCountry(String country) {

		this.country = country;
	}
	public String getProvince() {

		return province;
	}
	public void setProvince(String province) {

		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {

		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {

		this.age = age;
	}
	public String getPhonenumber() {

		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {

		this.phonenumber = phonenumber;
	}

	public User() {
		this.setGender(-1);
		this.setPhonenumber("-1");
	}


}
