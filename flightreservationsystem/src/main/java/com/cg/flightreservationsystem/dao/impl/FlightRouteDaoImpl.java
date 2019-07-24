package com.cg.flightreservationsystem.dao.impl;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.dao.FlightRouteDao;
import com.cg.flightreservationsystem.excetion.FRSException;

import com.cg.flightreservationsystem.utility.Queries;

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
	public FlightRouteBean addRoute(FlightRouteBean flightRouteBean) throws FRSException {

		if (flightRouteBean != null) {
			LocalDate time = flightRouteBean.setCurrentDate(LocalDate.now());
			// System.out.println(time);
			entityManager.persist(flightRouteBean);
		} else {
			flightRouteBean = null;
		}
		return flightRouteBean;
	}

	/**
	 * delete route details in the flight
	 * 
	 * @param flightRouteBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightRouteBean deleteRoute(FlightRouteBean flightRouteBean) throws FRSException {
		FlightRouteBean result;
		result = entityManager.find(FlightRouteBean.class, flightRouteBean.getRouteId());
		entityManager.remove(result);
		System.out.println(result);
//		if (result==null) {
//			  throw new FRSException(Exceptions.FOREIGN_KEY_CONSTRAINT);

		return result;
	}

	public List<FlightRouteBean> viewRoute(FlightRouteBean flightRouteBean) throws FRSException {
		String query = Queries.FIND;
		TypedQuery<FlightRouteBean> route = entityManager.createQuery(query, FlightRouteBean.class);
		route.setParameter("currentDate", flightRouteBean.getCurrentDate());
		List<FlightRouteBean> route1 = route.getResultList();
		return route1;
	}
}
