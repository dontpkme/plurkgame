package idv.plurk.rpg.util;

import idv.plurk.rpg.model.Emotion;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost:6033/jpa?useUnicode=true&characterEncoding=UTF-8",
						"root", "dontpkme8825252");
		return conn;
	}

	public static void main(String arg[]) {
		Emotion e = new Emotion();
		e = (Emotion) findOne(e, "select * from `emotion` where `id`=1");
		System.out.println(e.getUrl());
	}

	public static List<Map<String, Object>> query(String sql) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			List<Map<String, Object>> rsList = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int cc = rsmd.getColumnCount();
				for (int i = 1; i <= cc; i++) {
					map.put(rsmd.getColumnName(i),
							rs.getObject(rsmd.getColumnName(i)));
				}
				rsList.add(map);
			}
			conn.close();
			return rsList;
		} catch (Exception e) {
			return null;
		}
	}

	public static Object findOne(Object model, String sql) {
		try {
			Connection conn = getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			Class<?> c = (Class<?>) model.getClass();
			String setMethodName = null;
			Method methods[] = c.getMethods();

			while (rs.next()) {
				int cc = rsmd.getColumnCount();
				for (int i = 1; i <= cc; i++) {

					for (Method method : methods) {
						setMethodName = method.getName().toLowerCase();
						if (setMethodName.equals("set"
								+ rsmd.getColumnName(i).toLowerCase())) {
							method.invoke(model, rs.getObject(i));
							break;
						}
					}
				}
			}

			conn.close();
			return model;
		} catch (Exception e) {
			return null;
		}
	}
}
