package models;

public class OrderData {
	int orderCode;
	int userCode;
	int tourCode;
	int hotelCode;
	String orderDate;

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getTourCode() {
		return tourCode;
	}

	public void setTourCode(int tourCode) {
		this.tourCode = tourCode;
	}

	public int getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(int hotelCode) {
		this.hotelCode = hotelCode;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderData [orderCode=" + orderCode + ", userCode=" + userCode + ", tourCode=" + tourCode
				+ ", hotelCode=" + hotelCode + ", orderDate=" + orderDate + "]";
	}

}
