package it.polito.tdp.babs.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import it.polito.tdp.babs.db.BabsDAO;

public class Model {
	
	private BabsDAO bDAO;
	
	private List <Station> stazioni;
	
	private StationIdMap sMap;
	
	public Model() {
		
		bDAO = new BabsDAO();
		
		sMap = new StationIdMap();
		
		stazioni = bDAO.getAllStations(sMap);
		
	}

	public List<StazTot> contaTrip(LocalDate data) {
		
		List <StazTot> risultato = new ArrayList< >();
		
		for ( Station s : stazioni ) {
					
			 StazTot result = new StazTot ( bDAO.getTripArrByData(data, s),s,bDAO.getTripPartByData(data, s));
			 
			 risultato.add(result);

		}
			
			Collections.sort(risultato);
			
		return risultato;
		
	}

}
