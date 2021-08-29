package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection conectarBD() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/ecommerce?useTimezone=true&serverTimezone=UTC";

			Connection conexao = DriverManager.getConnection(url, "root", "Meubanco2020@");

			return conexao;

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}

		return null;
	}
}
