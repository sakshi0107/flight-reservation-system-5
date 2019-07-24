package com.cg.flightreservationsystem.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class FlightScheduleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "schedule_id")
	private int scheduleId;

	// @FutureOrPresent(message = Exceptions.DATE_NOT_EXIST)
	@Column(name = "arrival_date")
	private Date arrivalDate;

	// @FutureOrPresent(message = Exceptions.DATE_NOT_EXIST)
	@Column(name = "departure_date")
	private Date departureDate;

	// @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]", message =
	// Exceptions.INVALID_TIME)
	@Column(name = "arrival_time")
	private String arrivalTime;

	// @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]", message =
	// Exceptions.INVALID_TIME)
	@Column(name = "departure_time")
	private String departureTime;

	private double price;

	@OneToOne(mappedBy = "flightScheduleBean")
	private FlightDetailsBean flightDetailsBean;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FlightScheduleBean() {
		super();
	}

	@Override
	public String toString() {
		return "FlightScheduleBean [scheduleId=" + scheduleId + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", price="
				+ price + "]";
	}

}