package com.cg.flightreservationsystem.bean;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import oracle.sql.TIMESTAMP;

@Entity
@Table(name = "route")
public class FlightRouteBean {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "mySeq", sequenceName = "mySeq", allocationSize = 1)

	@Column(name = "route_id", updatable = false, nullable = false)
	private int routeId;
	
	@NotBlank(message = "source is mandatory")
	@Column(name = "source")
	private String source;

	
	@Column(name = "destination")
	private String destination;
	@Column(name = "current_time")
	private LocalDateTime currentTime;
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
	public LocalDateTime getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(LocalDateTime currentTime) {
		this.currentTime = currentTime;
	}
	@Override
	public String toString() {
		return "FlightRouteBean [routeId=" + routeId + ", source=" + source + ", destination=" + destination
				+ ", currentTime=" + currentTime + "]";
	}
	public FlightRouteBean(int routeId, @NotBlank(message = "source is mandatory") String source, String destination,
			LocalDateTime currentTime) {
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.currentTime = currentTime;
	}
	public FlightRouteBean() {
		super();
		
	}
	
	
}
	