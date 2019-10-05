package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import models.OrderData;

public class OrderDaoImpl implements OrderDao{
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travelagency";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static final String DELETE_ORDER = "DELETE FROM travelagency.order WHERE orderCode = ?";
	private static final String GET_ALL_ORDERS = "SELECT * FROM travelagency.order";
	private static final String GET_ORDER_FOR_USER = "SELECT * FROM travelagency.order WHERE userCode = ?";
	private static final String GET_ORDER_BY_EMAIL = "SELECT * FROM travelagency.order WHERE email = ?";
	
	public static OrderDaoImpl instance;
	
	public OrderDaoImpl(){
	}
	
	public void addOrder(OrderData order) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String addOrder = "INSERT INTO travelagency.order (userCode, tourCode, hotelCode, orderDate) VALUES ('" + order.getUserCode() 
			+ "','" + order.getTourCode() + "','" + order.getHotelCode() + "','" + order.getOrderDate() + "') ";
			statement.executeUpdate(addOrder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOrder(OrderData order) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String updateOrder = "UPDATE travelagency.order SET userCode='" + order.getUserCode() + "',tourCode='"
					+ order.getTourCode() + "',hotelCode='" + order.getHotelCode() + "',orderDate='"
					+ order.getOrderDate() + "' WHERE orderCode = " + order.getOrderCode() + " ; ";
			statement.executeUpdate(updateOrder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder(int orderCode) {
		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(DELETE_ORDER);) {
			statement.setInt(1, orderCode);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<OrderData> getAllOrders() {
		List<OrderData> allorders = new ArrayList<OrderData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(GET_ALL_ORDERS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setOrderCode(rs.getInt("orderCode"));
				orderData.setUserCode(rs.getInt("userCode"));
				orderData.setTourCode(rs.getInt("tourCode"));
				orderData.setHotelCode(rs.getInt("hotelCode"));
				orderData.setOrderDate(rs.getString("orderDate"));
				allorders.add(orderData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allorders;
	}

	public List<OrderData> getOrdersByUserCode(int userCode) {
		List<OrderData> userOrders = new ArrayList<OrderData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(GET_ORDER_FOR_USER);) {
			statement.setInt(1, userCode);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setOrderCode(rs.getInt("orderCode"));
				orderData.setUserCode(rs.getInt("userCode"));
				orderData.setTourCode(rs.getInt("tourCode"));
				orderData.setHotelCode(rs.getInt("hotelCode"));
				orderData.setOrderDate(rs.getString("orderDate"));
				userOrders.add(orderData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userOrders;
	}
	
	public List<OrderData> getOrdersByEmail(String email) {
		List<OrderData> userOrders = new ArrayList<OrderData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(GET_ORDER_BY_EMAIL);) {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setOrderCode(rs.getInt("orderCode"));
				orderData.setUserCode(rs.getInt("userCode"));
				orderData.setTourCode(rs.getInt("tourCode"));
				orderData.setHotelCode(rs.getInt("hotelCode"));
				orderData.setOrderDate(rs.getString("orderDate"));
				userOrders.add(orderData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userOrders;
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

	public static synchronized OrderDaoImpl getTourDaoInstance() {

		if (instance == null) {
			instance = new OrderDaoImpl();
		}
		return instance;
	}

}
