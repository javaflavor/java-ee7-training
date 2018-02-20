package com.redhat.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.jakewharton.fliptables.FlipTable;

public class TestBase {
	public EntityManagerFactory emf;
	public EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void sql(String sql) {
		try {
			
			Statement st = getConnection().createStatement();
			boolean hasResults = st.execute(sql);
			System.out.println(sql);
			System.out.println("--------------------------------------");
			if (hasResults) {
				System.out.println(format(st.getResultSet()));
			} else {
				System.out.printf("Update count: %d%n", st.getUpdateCount());
			}
		} catch (Exception e) {
			System.out.printf("Error: ", e);
		}
	}

	public Connection getConnection() throws Exception {
		Session session = em.unwrap(Session.class);
		return ((SessionImpl) session).connection();
	}

	public static String format(ResultSet resultSet) throws Exception {
		if (resultSet == null)
			throw new NullPointerException("resultSet == null");

		List<String> headers = new ArrayList<>();
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int column = 0; column < columnCount; column++) {
			headers.add(resultSetMetaData.getColumnName(column + 1));
		}

		List<String[]> data = new ArrayList<>();
		while (resultSet.next()) {
			String[] rowData = new String[columnCount];
			for (int column = 0; column < columnCount; column++) {
				rowData[column] = resultSet.getString(column + 1);
				rowData[column] = rowData[column] == null ? "NULL" : rowData[column];
			}
			data.add(rowData);
		}

		String[] headerArray = headers.toArray(new String[headers.size()]);
		String[][] dataArray = data.toArray(new String[data.size()][]);
		return FlipTable.of(headerArray, dataArray);
	}

}
