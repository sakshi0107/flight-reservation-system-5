package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.dao.FlightDetailsDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.utility.Exceptions;

@Repository
@Transactional
public class FlightDetailsDaoImpl implements FlightDetailsDao {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * adds plane details
	 * @param flightDetailsBean
	 * @return String
	 * @throws FRSException 
	 */
	public String addFlight(FlightDetailsBean flightDetailsBean) throws FRSException 
	{	
		if(flightDetailsBean!=null) 
	{
		entityManager.persist(flightDetailsBean);
	}
		else {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		return "added successfully";
	}

	/**
	 * delete plane details
	 * @param flightDetailsBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteFlight(FlightDetailsBean flightDetailsBean) throws FRSException {
		if(flightDetailsBean!=null) {
		FlightDetailsBean flightDetailsBean2 = entityManager.find(FlightDetailsBean.class,
				flightDetailsBean.getFlightId());
		entityManager.remove(flightDetailsBean2);
		}
		else {
			throw new FRSException(Exceptions.ID_INVALID);
		}
		return true;
	}

}
