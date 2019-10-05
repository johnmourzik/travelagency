package dao;

import java.util.List;

import models.OrderData;

public interface OrderDao {
	
	void addOrder(OrderData order);
	
	void updateOrder(OrderData order);
	
	void deleteOrder(int orderCode);
	
	List<OrderData> getAllOrders();
	
	List<OrderData> getOrdersByUserCode(int userCode);
	
	List<OrderData> getOrdersByEmail(String email);

}
