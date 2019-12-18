package test.table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class User implements PropertyChangeListener {

	@BeanColumn(name = "用户编号", index = 0)
	private Integer id;

	@BeanColumn(name = "用户姓名", index = 1)
	private String username;

	@BeanColumn(name = "用户密码", index = 2)
	private String password;

	@BeanColumn(name = "用户年龄", index = 3)
	private int age;

	// 这里如果取名字为is开头，在introspector中可能会存在BUG
	@BeanColumn(name = "婚否", index = 4)
	private Boolean marry;

	public User() {
	}

	public User(Integer id, String username, String password, int age,
			Boolean marry) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.marry = marry;
	}

	public Boolean getMarry() {
		return marry;
	}

	public void setMarry(Boolean marry) {
		this.marry = marry;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", marry=" + marry + "]";
	}

}
