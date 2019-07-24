package com.cg.flightreservationsystem.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.cg.flightreservationsystem.utility.Exceptions;

@Entity
@Table(name = "route")
public class FlightRouteBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "route_id")
	private int routeId;

	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = Exceptions.CITY_INCORRECT)
	@Column(name = "source")
	private String source;

	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = Exceptions.CITY_INCORRECT)
	@Column(name = "destination")
	private String destination;

	@Column(name = "current_time")

	private LocalDate currentDate;

	@OneToOne(mappedBy = "flightRouteBean")
	private FlightDetailsBean flightDetailsBean;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public LocalDate setCurrentDate(LocalDate currentDate) {
		return this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "FlightRouteBean [routeId=" + routeId + ", source=" + source + ", destination=" + destination
				+ ", currentDate=" + currentDate + "]";
	}

	public FlightRouteBean(int routeId, String source, String destination, LocalDate currentDate) {
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.currentDate = currentDate;
	}

	public FlightRouteBean() {
		super();

	}

}
