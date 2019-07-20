package com.cg.flightreservationsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class FlightDetailsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqFlight")
	@SequenceGenerator(name = "mySeqFlight", sequenceName = "mySeqFlight")
	@Column(name = "flight_id")
	private int flightId;
	private int capacity;
	@Column(name = "schedule_id")
	private int scheduleId;
	@Column(name = "route_id")
	private int routeId;

	public int getScheduleId() {
		return scheduleId;
	}

	@Override
	public String toString() {
		return "FlightDetailsBean [flightId=" + flightId + ", capacity=" + capacity + ", scheduleId=" + scheduleId
				+ ", routeId=" + routeId + "]";
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public FlightDetailsBean() {
		super();
	}

}
