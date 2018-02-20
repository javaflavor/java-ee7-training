package com.redhat.example.entity.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.redhat.example.util.ModelBase;

@Entity
public class Record extends ModelBase {
	@Id int id;
	int count;
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
//	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	Product product;
	
//	@ManyToOne
//	Cart cart;

	public Record() {}
	
	public Record(int id, Product product, int count) {
		this.id = id;
		this.product = product;
		this.count = count;
	}

	public Record(int id, int count) {
		this.id = id;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
