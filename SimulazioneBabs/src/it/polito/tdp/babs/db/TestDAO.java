/*package it.polito.tdp.babs.db;

import java.sql.Date;
import java.util.List;

import it.polito.tdp.babs.model.Station;
import it.polito.tdp.babs.model.StazTot;
import it.polito.tdp.babs.model.Trip;

public class TestDAO {

	public static void main(String args[]) {
		
		BabsDAO dao = new BabsDAO();
		
		List<StazTot>  trips1 = null;

	//	List<Station> stations = dao.getAllStations();
		
		for (Station s : stations) {
			System.out.format("%2d %-20s\n", s.getStationID(), s.getName());
		}

		List<Trip> trips = dao.getAllTrips();
		System.out.format("Found %d trips", trips.size());
		
		System.out.println("------------------------");
		
		for (Station s : stations) 
			
		trips1 = dao.getTripByData(Date.valueOf("2013-08-29").toLocalDate(),s);
		
		
		System.out.println(trips1.size());
	}
}
*/