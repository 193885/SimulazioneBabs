package it.polito.tdp.babs.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Simulazione {
	
	private LocalDate date;
	private double k;
	private PriorityQueue pq;
	private Model model;
	
	private enum EventType {
		PICK, DROP;
	}
	
	public Simulazione(LocalDate date, double k, Model model) {
		this.date = date;
		this.k = k;
		this.model = model;
		pq = new PriorityQueue();
	}
	
	public void run() {
		model.getTripsByDate(date);
		
		// Aggiungere gli eventi alla pq
		
		// processare gli eventi
		
		// ritornare il numero di DROPmiss e PICKmiss
	}

	private class Event implements Comparable<Event> {
		
		EventType type;
		LocalDateTime date;
		Trip trip;
		
		public Event(EventType type, LocalDateTime date, Trip trip) {
			this.type = type;
			this.date = date;
			this.trip = trip;
		}

		@Override
		public int compareTo(Event o) {
			return date.compareTo(o.date);
		}
		
		
	}
}