package com.vo;	
	
import javax.persistence.Column;	
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;	
import javax.persistence.Id;	
import javax.persistence.Table;	
import org.hibernate.annotations.GenericGenerator;	
	
@Entity	
@Table(name = "ling")	
public class Ling {	
	
	/** serialVersionUID */	
	protected static final long serialVersionUID = -1L;	
	
	public Ling() {	
	
	}	
	
	@Id	
	@GeneratedValue(generator = "generator")	
	@GenericGenerator(name = "generator", strategy = "identity")	
	@Column(name = "ID")	
	private Long id;	
	@Column(name = "TITLE")	
	private String title;	
	@Column(name = "INFO")	
	private String info;
	@Column(name = "LIANXIREN")	
	private String lianxiren;
	@Column(name = "TEL")	
	private String tel;
	@Column(name = "QQ")	
	private String qq;
	@Column(name = "ADDATE")	
	private String addate;
	@Column(name = "USERID")	
	private Long userid;	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	  

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

 

	public String getAddate() {
		return addate;
	}

	public void setAddate(String addate) {
		this.addate = addate;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	

 
	 
	
		
		
	
}	
