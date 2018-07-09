package it.polito.tdp.babs.model;

public class StazTot implements Comparable<StazTot> {

	private int totArrivo;
	private Station s;
	private int totPart;
		
	public StazTot(int totArrivo, Station s, int totPart) {
		
		this.s = s;
		this.totArrivo = totArrivo;
		this.totPart = totPart;
	}

	public int getTotArrivo() {
		return totArrivo;
	}

	public void setTotArrivo(int totArrivo) {
		this.totArrivo = totArrivo;
	}

	public Station getS() {
		return s;
	}

	public void setS(Station s) {
		this.s = s;
	}

	public int getTotPart() {
		return totPart;
	}

	public void setTotPart(int totPart) {
		this.totPart = totPart;
	}

	@Override
	public String toString() {
		return "totArrivo=" + totArrivo + ", s=" + s + ", totPart=" + totPart ;
	}

	@Override
	public int compareTo(StazTot other) {
		
		if(this.getS().getLat() - other.getS().getLat() > 0)
			
			return 1;
		
		else if( this.getS().getLat() - other.getS().getLat() == 0)
			
			return 0 ;
		
		else
			return -1;
		
		
	}
	
}
