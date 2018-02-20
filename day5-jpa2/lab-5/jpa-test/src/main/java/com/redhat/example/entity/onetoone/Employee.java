package com.redhat.example.entity.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.redhat.example.util.ModelBase;

@Entity
public class Employee extends ModelBase {
	@Id int id;
	String name;
	
	@Embedded
	Address address;
	
	@OneToOne(cascade={CascadeType.PERSIST})
//	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
//	@JoinColumn(name="MOBILE_NUMBER")	// デフォルトのFKカラム名は<フィールド名>_<参照先ID>
	Mobile mobile;
	
	public Employee() {}
	
	public Employee(int id, String name, Mobile mobile, Address address) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	void setMobile(Mobile mobile) {
//		mobile.setOwnedBy(this);
//		this.mobile = mobile; 
//	}
//	
//	void removeMobile() {
//		if (mobile != null) {
//			mobile.setOwnedBy(null);
//			mobile = null;
//		}
//	}
}
