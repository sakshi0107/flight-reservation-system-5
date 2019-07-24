package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.dao.FlightDetailsDao;
import com.cg.flightreservationsystem.excetion.FRSException;

@Repository
@Transactional
public class FlightDetailsDaoImpl implements FlightDetailsDao {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * adds plane details
	 * 
	 * @param flightDetailsBean
	 * @return String
	 * @throws FRSException
	 */
	public FlightDetailsBean addFlight(FlightDetailsBean flightDetailsBean) throws FRSException {
		if (flightDetailsBean != null) {
			entityManager.persist(flightDetailsBean);
		} else {
			flightDetailsBean = null;
		}
		return flightDetailsBean;
	}

	/**
	 * delete plane details
	 * 
	 * @param flightDetailsBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightDetailsBean deleteFlight(FlightDetailsBean flightDetailsBean) throws FRSException {
		FlightDetailsBean flightDetailsBean2;
		flightDetailsBean2 = entityManager.find(FlightDetailsBean.class, flightDetailsBean.getFlightId());
		if (flightDetailsBean2 != null) {
			entityManager.remove(flightDetailsBean2);
		} else {
			flightDetailsBean2 = null;
		}
		return flightDetailsBean;
	}

}
