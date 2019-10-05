package models;

public class TourData {

	int tourCode;
	String tourName;
	String country;
	String tourDesc;
	String startDate;
	int price;

	public int getTourCode() {
		return tourCode;
	}

	public void setTourCode(int tourCode) {
		this.tourCode = tourCode;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTourDesc() {
		return tourDesc;
	}

	public void setTourDesc(String tourDesc) {
		this.tourDesc = tourDesc;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TourData [tourCode=" + tourCode + ", tourName=" + tourName + ", country=" + country + ", tourDesc="
				+ tourDesc + ", startDate=" + startDate + ", price=" + price + "]";
	}

}
