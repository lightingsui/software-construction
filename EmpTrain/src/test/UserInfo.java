package test;

public class UserInfo {
	private String id1;
	private String id2;
	private String name;

	public UserInfo() {
	}

	public UserInfo(String id1, String id2, String name) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.name = name;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserInfo [id1=" + id1 + ", id2=" + id2 + ", name=" + name + "]";
	}

}
