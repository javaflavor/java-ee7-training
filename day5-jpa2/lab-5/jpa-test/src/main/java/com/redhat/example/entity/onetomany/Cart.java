package com.redhat.example.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.redhat.example.util.ModelBase;

@Entity
public class Cart extends ModelBase {
	@Id int id;
	@OneToMany
	@JoinColumn(name = "CART_ID")	// JOIN TABLEを使用せず、関連側テーブルのFKとして追加するカラム名
//	@JoinColumn						// デフォルトでは<フィールド名>+"_ID"になってしまう(ex. "RECORDS_ID")
	List<Record> records;
	
	public Cart() {
		records = new ArrayList<>();
	}
	
	public Cart(int id) {
		this();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}
	
}
