package demo;

import java.util.List;

import dao.OrderDao;
import dao.TourDao;
import dao.UserDao;
import impl.OrderDaoImpl;
import impl.TourDaoImpl;
import impl.UserDaoImpl;
import models.OrderData;
import models.TourData;
import models.UserData;

public class Demo {

	public static void main(String[] args) {
		
//		UserDaoExapmle userDaoExample = new UserDaoExample();
//		UserData userData = userDaoExample.getUserByID();
//		System.out.println(userData);
		
//		UserDao userDao1 = new UserDaoImpl();
//		UserData newUser1 = new UserData();
//		newUser1.setUserName("Fedor");
//		newUser1.setUserSurname("Dobronravov");
//		newUser1.setBirthday("1990-12-28");
//		newUser1.setEmail("0661594872@ukr.net");
//		newUser1.setPassword("369258147");
//		userDao1.addUser(newUser1);
		
		
//		UserDao userDao2 = new UserDaoImpl();
//		UserData newUser2 = new UserData();
//		newUser2.setName("Dobrinyua");
//		newUser2.setLast_name("Dobronravov");
//		newUser2.setBirthday("1990-12-28");
//		newUser2.setTelephone("+380661594872");
//		newUser2.setEmail("0661594872@ukr.net");
//		newUser2.setPassword1("369258147");
//		newUser2.setPassword2("741852963");
//		newUser2.setId_user(9);
//		userDao2.updateUser(newUser2);
		
//		UserDao userDao3 = new UserDaoImpl();
//		userDao3.deleteUser(8);
		
		 UserData newuser = new UserData();
         newuser.setEmail("78999@78999");
         newuser.setPassword("1");
		UserDao userDao3 = new UserDaoImpl();
		userDao3.updateEmailUser(newuser);
		
		UserDao userDao5 = new UserDaoImpl();
		UserData userData5 = userDao5.selectOne(3);
		System.out.println(userData5);
		
//		UserDao userDao3 = new UserDaoImpl();
//		UserData userData2 = userDao3.selectOne("456@456");
//		System.out.println(userData2);
//		
//		UserDao userDao4 = new UserDaoImpl();
//		List<UserData> userData1 = userDao4.getAllUsers();
//		System.out.println(userData1);
		
//		TourDao tourDao1 = new TourDaoImpl();
//		TourData newTour1 = new TourData();
//		newTour1.setName("Bohemian rapsody");
//		newTour1.setId_country(6);
//		newTour1.setId_city(10);
//		newTour1.setId_hotel_name(18);
//		newTour1.setDescription("For all who love classical music");
//		newTour1.setStart_date("2019-12-20");
//		newTour1.setFinish_date("2019-12-27");
//		newTour1.setPrice(525);
//		tourDao1.addTour(newTour1);
		
//		TourDao tourDao2 = new TourDaoImpl();
//		TourData newTour2 = new TourData();
//		newTour2.setName("Bohemian rapsody");
//		newTour2.setId_country(6);
//		newTour2.setId_city(10);
//		newTour2.setId_hotel_name(18);
//		newTour2.setDescription("For all who love classical music");
//		newTour2.setStart_date("2019-12-20");
//		newTour2.setFinish_date("2019-12-27");
//		newTour2.setPrice(525);
//		newTour2.setId_tour(15);
//		tourDao2.updateTour(newTour2);
		
//		TourDao tourDao3 = new TourDaoImpl();
//		tourDao3.deleteTour(15);
		TourDao tourDao6 = new TourDaoImpl();
		TourData newTour2 = tourDao6.selectOne(1);
		System.out.println(newTour2);
		
		TourDao tourDao4 = new TourDaoImpl();
		List <TourData> tourData4 = tourDao4.getToursByCountryName("Turkey");
		System.out.println(tourData4);
		
		TourDao tourDao5 = new TourDaoImpl();
		List <TourData> tourData5 = tourDao5.getAllTours();
		System.out.println(tourData5);
		
//		OrderDao orderDao1 = new OrderDaoImpl();
//		OrderData newOrder1 = new OrderData();
//		newOrder1.setUserCode(1);
//		newOrder1.setTourCode(7);
//		newOrder1.setHotelCode(7);
//		newOrder1.setOrderDate("2020-08-08");
//		orderDao1.addOrder(newOrder1);
		
//		OrderDao orderDao2 = new OrderDaoImpl();
//		OrderData newOrder2 = new OrderData();
//		newOrder2.setId_user(9);
//		newOrder2.setId_departure_city(2);
//		newOrder2.setId_country(6);
//		newOrder2.setId_city(10);
//		newOrder2.setId_hotel(19);
//		newOrder2.setId_tour_number(17);
//		newOrder2.setStart_date("2020-01-16");
//		newOrder2.setFinish_date("2020-01-26");
//		newOrder2.setId_tour_order(8);
//		orderDao2.updateOrder(newOrder2);
		
//		OrderDao orderDao3 = new OrderDaoImpl();
//		orderDao3.deleteOrder(8);
		
		OrderDao orderDao4 = new OrderDaoImpl();
		List <OrderData> orderData4 = orderDao4.getAllOrders();
		System.out.println(orderData4);
		
		OrderDao orderDao5 = new OrderDaoImpl();
		List <OrderData> orderData5 = orderDao5.getOrdersByUserCode(3);
		System.out.println(orderData5);
				
	}

}
