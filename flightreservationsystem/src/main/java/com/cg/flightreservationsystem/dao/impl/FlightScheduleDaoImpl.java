package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.dao.FlightScheduleDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.utility.Exceptions;

@Repository
@Transactional
public class FlightScheduleDaoImpl implements FlightScheduleDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * adds schedule details to the flight table
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public String addSchedule(FlightScheduleBean flightScheduleBean) throws FRSException {
		if(flightScheduleBean!=null) {
		entityManager.persist(flightScheduleBean);
		}
		else {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		return "added succcessfully";
	}

	/**
	 * delete schedule details to the flight table
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteSchedule(FlightScheduleBean flightScheduleBean) throws FRSException {
		if(flightScheduleBean!=null) {
		FlightScheduleBean flightScheduleBean2 = entityManager.find(FlightScheduleBean.class,
				flightScheduleBean.getScheduleId());
		entityManager.remove(flightScheduleBean2);
		}
		else {
			throw new FRSException(Exceptions.ID_INVALID);
		}
		return true;
	}

}
