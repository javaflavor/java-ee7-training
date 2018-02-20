package com.redhat.example.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

public class DDLUtil {
	public static void main(String[] args) {
		Map<String, String> props = new HashMap<>();

		props.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
		props.put("javax.persistence.schema-generation.create-source", "metadata");
		props.put("javax.persistence.schema-generation.scripts.create-target", "target/sql/create_h2.sql");
		props.put("javax.persistence.schema-generation.drop-source", "metadata");
		props.put("javax.persistence.schema-generation.scripts.drop-target", "target/sql/drop_h2.sql");

		Persistence.generateSchema("TestPU", props);
	}
}
