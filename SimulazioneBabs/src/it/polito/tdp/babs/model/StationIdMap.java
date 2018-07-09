package it.polito.tdp.babs.model;

import java.util.HashMap;
import java.util.Map;



public class StationIdMap {
	

		private Map <Integer, Station> map;
		
		public StationIdMap() {
			
			map = new HashMap<>();
			
		}
		
		public Station get(Station s) {
			
			//passo oggetto intero e non solo un codCorso perchè se non è presente il 
			//corso dovrò crearlo e poi aggiungerlo alla mappa
			
			Station old = map.get(s.getStationID());
			
			//in old viene salvato null se non c'è corrispondenza nella mappa o l'oggetto 
			//associato a quel codIns che prima qualcuno aveva creato
			
			if(old == null) {
				
				map.put(s.getStationID(), s);
				
				return s;
			}
			
			return old;
		}
		
		public void put(Integer stationID,Station s) {
			
			map.put(stationID, s);
			
		}

		public Station get(Integer stationID) {

			return map.get(stationID);
		}
	}