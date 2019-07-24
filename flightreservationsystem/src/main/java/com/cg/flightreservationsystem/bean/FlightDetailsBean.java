package com.cg.flightreservationsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class FlightDetailsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "flight_id")
	private int flightId;
	private int capacity;

	@OneToOne
	@JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
	private FlightScheduleBean flightScheduleBean;

	@OneToOne
	@JoinColumn(name = "route_id", referencedColumnName = "route_id")
	private FlightRouteBean flightRouteBean;

	public FlightScheduleBean getFlightScheduleBean() {
		return flightScheduleBean;
	}

	public void setFlightScheduleBean(FlightScheduleBean flightScheduleBean) {
		this.flightScheduleBean = flightScheduleBean;
	}

	public FlightRouteBean getFlightRouteBean() {
		return flightRouteBean;
	}

	public void setFlightRouteBean(FlightRouteBean flightRouteBean) {
		this.flightRouteBean = flightRouteBean;
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

	@Override
	public String toString() {
		return "FlightDetailsBean [flightId=" + flightId + ", capacity=" + capacity + ", flightScheduleBean="
				+ flightScheduleBean + ", flightRouteBean=" + flightRouteBean + "]";
	}

}
