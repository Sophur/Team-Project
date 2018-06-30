package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "loginuser")
public class Loginuser {

	/** serialVersionUID */
	protected static final long serialVersionUID = -1L;

	public Loginuser() {

	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "identity")
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "USER_TYPE")
	private String userType;
	@Column(name = "RNAME")
	private String rname;
	
	@Column(name = "SEX")
	private String sex;
	@Column(name = "XUELI")
	private String xueli;
	@Column(name = "RENZHI")
	private String renzhi;
	@Column(name = "DEPT")
	private String dept;
	@Column(name = "ZHIWU")
	private String zhiwu;
	

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

	/**
	 * @return Returns the Password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            Set the password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the Phone.
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * @param phone
	 *            Set the phone.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return Returns the UserType.
	 */
	public String getUserType() {
		return this.userType;
	}

	/**
	 * @param userType
	 *            Set the userType.
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getXueli() {
		return xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getRenzhi() {
		return renzhi;
	}

	public void setRenzhi(String renzhi) {
		this.renzhi = renzhi;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	
	

}
