package com.vo;	
	
import javax.persistence.Column;	
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;	
import javax.persistence.Id;	
import javax.persistence.Table;	
import org.hibernate.annotations.GenericGenerator;	
	
@Entity	
@Table(name = "userinfo")	
public class Userinfo {	
	
	/** serialVersionUID */	
	protected static final long serialVersionUID = -1L;	
	
	public Userinfo() {	
	
	}	
	
	@Id	
	@GeneratedValue(generator = "generator")	
	@GenericGenerator(name = "generator", strategy = "identity")	
	@Column(name = "ID")	
	private Long id;	
	@Column(name = "NAME")	
	private String name;	
	@Column(name = "PWD")	
	private String pwd;	
	@Column(name = "SEX")	
	private String sex;	
	@Column(name = "AGE")	
	private String age;	
	@Column(name = "TEL")	
	private String tel;	
	@Column(name = "ADDRESS")	
	private String address;	
	@Column(name = "EMAIL")	
	private String email;	
	@Column(name = "PIC")	
	private String pic;	
	@Column(name = "TYPE")	
	private String type;	
	@Column(name = "STYLE")	
	private String style;
	
		
		
	
	/**	
	 * @return Returns the Id.	
	 */	
	public Long getId() {	
		return this.id;	
	}	
	
	/**	
	 * @param id	
	 *            Set the id.	
	 */	
	public void setId(Long id) {	
		this.id = id;	
	}	
	
	/**	
	 * @return Returns the Name.	
	 */	
	public String getName() {	
		return this.name;	
	}	
	
	/**	
	 * @param name	
	 *            Set the name.	
	 */	
	public void setName(String name) {	
		this.name = name;	
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}	
	
	
		
		
	
}	
