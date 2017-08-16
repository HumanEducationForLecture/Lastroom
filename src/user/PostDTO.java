package user;

import java.io.Serializable;

public class PostDTO implements Serializable, User, Characteristics,Post {
	private String email;
	private String nickName;
	private String content;
	public PostDTO() {
		super();
	}
	
	public PostDTO(String email, String nickName,String content) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.content=content;
	}

	@Override
	public String getNickName() {
		return this.nickName;
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	@Override
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
