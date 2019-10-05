package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TourDao;
import models.TourData;

public class TourDaoImpl implements TourDao{
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travelagency";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DELETE_TOUR = "DELETE FROM tour WHERE tourCode = ?";
	private static final String SELECT_ALL_TOURS_FOR_ONE_COUNTRY = "SELECT * FROM tour WHERE country = ?";
	private static final String SELECT_ALL_TOURS = "SELECT * FROM tour";
	private static final String SELECT_ONE_TOUR = "SELECT * FROM tour WHERE tourCode = ?";
	
	public static TourDaoImpl instance;
	
	public TourDaoImpl(){
	}
	
	public void addTour(TourData tour) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String addTour = "INSERT INTO tour (tourName, country, tourDesc, startDate, price) VALUES ('"
					+ tour.getTourName() + "','" + tour.getCountry() + "','" + tour.getTourDesc() + "','"
					+ tour.getStartDate() + "','" + tour.getPrice() + "') ";
			statement.executeUpdate(addTour);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTour(TourData tour) {
		try (Connection conn = getConnection(); Statement statement = conn.createStatement();) {
			String updateTour = "UPDATE tour SET tourName='" + tour.getTourName() + "',country='" + tour.getCountry()
					+ "',tourDesc='" + tour.getTourDesc() + "',startDate='" + tour.getStartDate() + "',price='" + tour.getPrice() 
					+ "' WHERE tourCode = " + tour.getTourCode() + " ;";
			statement.executeUpdate(updateTour);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTour(int tourCode) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_TOUR);) {
			statement.setInt(1, tourCode);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<TourData> getToursByCountryName(String country) {
		List<TourData> allTourByOneCountry = new ArrayList<TourData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS_FOR_ONE_COUNTRY);) {
			statement.setString(1, country);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourCode(rs.getInt("tourCode"));
				tourData.setTourName(rs.getString("tourName"));
				tourData.setCountry(rs.getString("country"));
				tourData.setTourDesc(rs.getString("tourDesc"));
				tourData.setStartDate(rs.getString("startDate"));
				tourData.setPrice(rs.getInt("price"));
				allTourByOneCountry.add(tourData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allTourByOneCountry;
	}

	public List<TourData> getAllTours() {
		List<TourData> allTours = new ArrayList<TourData>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setTourCode(rs.getInt("tourCode"));
				tourData.setTourName(rs.getString("tourName"));
				tourData.setCountry(rs.getString("country"));
				tourData.setTourDesc(rs.getString("tourDesc"));
				tourData.setStartDate(rs.getString("startDate"));
				tourData.setPrice(rs.getInt("price"));
				allTours.add(tourData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allTours;
	}
	
	public TourData selectOne(int tourCode) {
		TourData tourData = null;
		try (Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ONE_TOUR);) {
			preparedStatement.setInt(1, tourCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int tourCode1 = resultSet.getInt(1);
				String tourName = resultSet.getString(2);
				String country = resultSet.getString(3);
				String tourDesc = resultSet.getString(4);
				String startDate = resultSet.getString(5);
				int price = resultSet.getInt(6);
				tourData = new TourData();
				tourData.setTourCode(tourCode1);
				tourData.setTourName(tourName);
				tourData.setCountry(country);
				tourData.setTourDesc(tourDesc);
				tourData.setStartDate(startDate);
				tourData.setPrice(price);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return tourData;
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

	public static synchronized TourDaoImpl getTourDaoInstance() {

		if (instance == null) {
			instance = new TourDaoImpl();
		}
		return instance;
	}

}

