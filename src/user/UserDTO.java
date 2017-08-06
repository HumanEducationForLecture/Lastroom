package user;

import java.io.Serializable;

public class UserDTO implements Serializable, User, Characteristics {
	private String email;
	private String nickName;
	private String password;
	public UserDTO() {
		super();
	}
	
	public UserDTO(String email, String nickName, String password) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.password = password;
	}





	@Override
	public String getNickName() {
		return this.nickName;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
