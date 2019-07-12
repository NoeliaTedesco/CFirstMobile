package context;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.poiji.annotation.ExcelCell;


@XmlRootElement
public class UsuarioMobile {
	
	
	private String email;
	private String password;
	
	public UsuarioMobile(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public UsuarioMobile() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}

