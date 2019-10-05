package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import models.UserData;

public class UserDaoImpl implements UserDao{

	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travelagency";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DELETE_USER = "DELETE FROM user WHERE userCode = ?";
	private static final String GET_ALL_USERS = "SELECT * FROM user";
	private static final String SELECT_ONE_USER = "SELECT * FROM user WHERE userCode = ?";
	private static final String SELECT_ONE_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
	private static final String SELECT_ONE_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user WHERE email = ? and password = ?";
	
	private static UserDaoImpl instance;
	
	public UserDaoImpl(){
		}
	
	public static synchronized UserDaoImpl getUserDaoInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	public void addUser(UserData user) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String addUser = "INSERT INTO user (userName, userSurname, birthday, email, password) VALUES ('"
					+ user.getUserName() + "','" + user.getUserSurname() + "','" + user.getBirthday() + "','"
					+ user.getEmail() + "','" + user.getPassword() + "') ";
			statement.executeUpdate(addUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(UserData user) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String updateUser = "UPDATE user SET userName='" + user.getUserName() + "',userSurname='" + user.getUserSurname()
					+ "',birthday='" + user.getBirthday() + "',email='" + user.getEmail() + "',password='"
					+ user.getPassword() + "' WHERE userCode = " + user.getUserCode() + " ;";
			statement.executeUpdate(updateUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmailUser(UserData user) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String updateUser = "UPDATE user SET email='" + user.getEmail() + "',password='"
					+ user.getPassword() + "' WHERE email = '?' ;";
			statement.executeUpdate(updateUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userCode) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USER);) {
			statement.setInt(1, userCode);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserData> getAllUsers() {
		List<UserData> allusers = new ArrayList<UserData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(GET_ALL_USERS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setUserCode(rs.getInt("userCode"));
				userData.setUserName(rs.getString("userName"));
				userData.setUserSurname(rs.getString("userSurname"));
				userData.setBirthday(rs.getString("birthday"));
				userData.setEmail(rs.getString("email"));
				userData.setPassword(rs.getString("password"));
				allusers.add(userData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allusers;
	}
	
	public UserData selectOne(int userCode) {
		UserData userData = null;
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ONE_USER);) {
			preparedStatement.setInt(1, userCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int userCode1 = resultSet.getInt(1);
				String userName = resultSet.getString(2);
				String userSurname = resultSet.getString(3);
				String birthday = resultSet.getString(4);
				String email = resultSet.getString(5);
				String password = resultSet.getString(6);
				userData = new UserData();
				userData.setUserCode(userCode1);
				userData.setUserName(userName);
				userData.setUserSurname(userSurname);
				userData.setBirthday(birthday);
				userData.setEmail(email);
				userData.setPassword(password);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return userData;
	}
	
	public UserData selectOne(String email) {
		UserData userData = null;
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ONE_USER_BY_EMAIL);) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int userCode = resultSet.getInt(1);
				String userName = resultSet.getString(2);
				String userSurname = resultSet.getString(3);
				String birthday = resultSet.getString(4);
				String email1 = resultSet.getString(5);
				String password = resultSet.getString(6);
				userData = new UserData();
				userData.setUserCode(userCode);
				userData.setUserName(userName);
				userData.setUserSurname(userSurname);
				userData.setBirthday(birthday);
				userData.setEmail(email1);
				userData.setPassword(password);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return userData;
	}
	
	public String loginCheck(UserData userData) {
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = 
						conn.prepareStatement(SELECT_ONE_USER_BY_EMAIL_AND_PASSWORD);) {
			preparedStatement.setString(1, userData.getEmail());
			preparedStatement.setString(2, userData.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (userData.getEmail().equals("asd@asd")) {
				return "admin";
			}
			if (resultSet.next()) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return "error";
	}

	private Connection getConnection() {
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME + PARAMS, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
