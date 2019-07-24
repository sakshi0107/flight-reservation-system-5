package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.dao.FlightScheduleDao;
import com.cg.flightreservationsystem.excetion.FRSException;

@Repository
@Transactional
public class FlightScheduleDaoImpl implements FlightScheduleDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * adds schedule details to the flight table
	 * 
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public FlightScheduleBean addSchedule(FlightScheduleBean flightScheduleBean) throws FRSException {
		if (flightScheduleBean != null) {
			entityManager.persist(flightScheduleBean);
		} else {
			flightScheduleBean = null;
		}
		return flightScheduleBean;
	}

	/**
	 * delete schedule details to the flight table
	 * 
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightScheduleBean deleteSchedule(FlightScheduleBean flightScheduleBean) throws FRSException {
		FlightScheduleBean result;
		result = entityManager.find(FlightScheduleBean.class, flightScheduleBean.getScheduleId());
		entityManager.remove(result);
//		if (result!=null) {
//			  throw new FRSException(Exceptions.FOREIGN_KEY_CONSTRAINT);
//			 
//		} else {
//			result = null;
//		}
		return result;
	}

}
