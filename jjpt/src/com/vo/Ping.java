package com.vo;	
	
import javax.persistence.Column;	
import javax.persistence.Entity;	
import javax.persistence.GeneratedValue;	
import javax.persistence.Id;	
import javax.persistence.Table;	
import org.hibernate.annotations.GenericGenerator;	
	
@Entity	
@Table(name = "ping")	
public class Ping {	
	
	/** serialVersionUID */	
	protected static final long serialVersionUID = -1L;	
	
	public Ping() {	
	
	}	
	
	@Id	
	@GeneratedValue(generator = "generator")	
	@GenericGenerator(name = "generator", strategy = "identity")	
	@Column(name = "ID")	
	private Long id;	
	@Column(name = "NAME")	
	private String name;
	@Column(name = "TYPE")	
	private String type;
	@Column(name = "PIC")	
	private String pic;
	@Column(name = "INFO")	
	private String info;
	@Column(name = "ADDDATE")	
	private String adddate;
	@Column(name = "inid")	
	private Long inid;	
	
		
		
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public Long getInid() {
		return inid;
	}

	public void setInid(Long inid) {
		this.inid = inid;
	}	
	
	
		
		
	
}	
