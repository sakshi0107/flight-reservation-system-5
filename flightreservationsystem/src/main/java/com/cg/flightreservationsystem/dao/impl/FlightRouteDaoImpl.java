package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.dao.FlightRouteDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.utility.Exceptions;

@Repository
@Transactional
public class FlightRouteDaoImpl implements FlightRouteDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * add route details
	 * 
	 * @param flightRouteBean
	 * @return String
	 * @throws FRSException
	 */
	public String addRoute(FlightRouteBean flightRouteBean) throws FRSException {
		// System.out.println(flightRouteBean);
		if (flightRouteBean != null) {
			 System.out.println("inside dao ");
			entityManager.persist(flightRouteBean);
		} else {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		System.out.println(flightRouteBean);
		return "added successfully";
	}

	/**
	 * delete route details in the flight
	 * 
	 * @param flightRouteBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteRoute(FlightRouteBean flightRouteBean) throws FRSException {
		if (flightRouteBean != null) {
			FlightRouteBean flightRouteBean2 = entityManager.find(FlightRouteBean.class, flightRouteBean.getRouteId());
			entityManager.remove(flightRouteBean2);
		} else {
			throw new FRSException(Exceptions.ID_INVALID);
		}
		return true;
	}
	
	public boolean viewRoute(FlightRouteBean flightRouteBean)throws FRSException{
		String query = "select route_id, source, destination from route where current_time=?";
		entityManager.
		return true;
	}
}
