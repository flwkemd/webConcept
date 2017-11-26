package vo;

public class Person1Vo {
	private String name, nickname;
	private int age;
	private String hometel, tel;

	public Person1Vo(String name, String nickname, int age, String hometel, String tel) {
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.hometel = hometel;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
