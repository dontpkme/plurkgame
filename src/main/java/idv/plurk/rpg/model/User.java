package idv.plurk.rpg.model;

public class User {

	private long id;

	private String nickname;

	private String displayname;

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String name) {
		this.nickname = name;
	}
}
