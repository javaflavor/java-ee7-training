package com.redhat.example.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.redhat.example.util.ModelBase;

@Entity
public class Mobile extends ModelBase {
	@Id
	String number;
	boolean activated = false;
	
	// 逆参照の場合、順方向参照のフィールド名を示す。
	@OneToOne(mappedBy="mobile")
	Employee ownedBy;
	
	public Mobile() {}
	
	public Mobile(String number, boolean activated) {
		this.number = number;
		this.activated = activated;
	}

	public Employee getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Employee ownedBy) {
		this.ownedBy = ownedBy;
	}
	
}
