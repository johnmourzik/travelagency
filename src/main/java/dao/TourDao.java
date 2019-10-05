package dao;

import java.util.List;

import models.TourData;

public interface TourDao {
	
	void addTour(TourData tour);
	
	void updateTour(TourData tour);
	
	void deleteTour(int tourCode);
	
	List<TourData> getToursByCountryName(String country);

	List<TourData> getAllTours();
	
	public TourData selectOne(int tourCode);

}
