package com.cg.flightreservationsystem.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class FlightScheduleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "mySeqSchedule", sequenceName = "mySeqSchedule")
	@Column(name = "schedule_id")
	private int scheduleId;

	@Column(name = "arrival_date")
	private Date arrivalDate;
	@Column(name = "departure_date")
	private Date departureDate;
	@Column(name = "arrival_time")
	private String arrivalTime;
	@Column(name = "departure_time")
	private String departureTime;
	private double price;

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