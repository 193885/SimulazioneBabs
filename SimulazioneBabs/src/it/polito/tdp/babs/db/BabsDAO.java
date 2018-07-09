package it.polito.tdp.babs.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.babs.model.Station;
import it.polito.tdp.babs.model.StationIdMap;
import it.polito.tdp.babs.model.StazTot;
import it.polito.tdp.babs.model.Trip;

public class BabsDAO {

	public List<Station> getAllStations(StationIdMap sMap) {
		List<Station> result = new ArrayList<Station>();
		Connection conn = ConnectDB.getConnection();
		
		String sql = "SELECT * FROM station";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Station station = new Station(rs.getInt("station_id"),
										rs.getString("name"),
										rs.getDouble("lat"),
										rs.getDouble("long"),
										rs.getInt("dockcount"));
				result.add(sMap.get(station));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}

		return result;
	}

	public List<Trip> getAllTrips() {
		List<Trip> result = new LinkedList<Trip>();
		Connection conn = ConnectDB.getConnection();

		String sql = "SELECT * FROM trip";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Trip trip = new Trip(rs.getInt("tripid"), 
									rs.getInt("duration"),
									rs.getTimestamp("startdate").toLocalDateTime(),
									rs.getInt("startterminal"),
									rs.getTimestamp("enddate").toLocalDateTime(),
									rs.getInt("endterminal"));
				result.add(trip);
			}
			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}

		return result;
	}

	public Integer  getTripPartByData (LocalDate data,Station s) {
		
		int tot= 0;
		
		Connection conn = ConnectDB.getConnection();

		String sql = 	"select  count(*) as totTrip " + 
						"from trip " + 
						"where  trip.StartTerminal = ?   and  date (trip.StartDate) = ? ";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			

			st.setInt(1,s.getStationID());
			st.setDate(2, Date.valueOf(data));
			
			ResultSet rs = st.executeQuery();
			

			rs.next();
				
				tot = rs.getInt("totTrip");
			  
			
			conn.close();
			
			return tot;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}
		
	}
	
public Integer  getTripArrByData (LocalDate data,Station s) {
	
	int cont= 0;
		
		Connection conn = ConnectDB.getConnection();

		String sql = 	"select count(*) as totTrip " + 
						"from trip " + 
						"where  trip.EndTerminal= ?  and  date(trip.EndDate)= ? ";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			

			st.setInt(1,s.getStationID());
			st.setDate(2, Date.valueOf(data));
			
			ResultSet rs = st.executeQuery();
			

			rs.next();
				
				cont = rs.getInt("totTrip");
			
			conn.close();
			
			return cont;


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error in database query", e);
		}
		
	} 
}