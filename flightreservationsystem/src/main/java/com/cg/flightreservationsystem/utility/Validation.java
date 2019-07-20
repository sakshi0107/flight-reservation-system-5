package com.cg.flightreservationsystem.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.flightreservationsystem.excetion.FRSException;



public class Validation {
	public boolean cityIsValid(String city) throws FRSException {
		Pattern type = Pattern.compile("[A-Z]{1}[a-z]*");
		Matcher match = type.matcher(city);
		if (match.matches()) {
			return true;
		} 
		else {
			throw new FRSException(Exceptions.CITY_INCORRECT);
		}
		
	}	
		
		public boolean timeIsValid(String time) throws FRSException {
			
			  Pattern type = Pattern.compile("[0-23]{2}:[0-5]{1}[0-9]{1}"); 
			  Matcher match =type.matcher(time); 
			  if (match.matches()) 
			  {
				  return true;
			  } 
			  else 
			  { 
				  throw new FRSException(Exceptions.INVALID_TIME); 
			  }
		}
		public boolean idIsValid(int routeId) throws FRSException{
			if(routeId<0 && routeId>500) {
				throw new FRSException(Exceptions.ID_INVALID);
			}
			else {
					return true;
				}
		}
		
		public boolean dateIsValid(String date) throws FRSException {
			Pattern type = Pattern.compile("\\d[0-3]{2}-\\d[0-9]{2}-\\d[0-9]{4}");
			Matcher match = type.matcher(date);
			if (match.matches()) {
				return true;
			} else {
				try {
					SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
					format.setLenient(false);
					format.parse(date);
					return true;
				} catch (ParseException e) {
					throw new FRSException(Exceptions.DATE_NOT_EXIST);
				}
				
			}
		}
		
		public boolean priceIsValid(String price) throws FRSException {
			Pattern type = Pattern.compile("[0-9]{4}");
			Matcher match = type.matcher(price);
			if (match.matches()) {
				return true;
			} else {
				throw new FRSException(Exceptions.INVALID_PRICE);
			}
			
		}
		
		public boolean capacityIsValid(int capacity) throws FRSException{
			if(capacity>0 && capacity<200) {
				return true;
			}
			else {
				throw new FRSException(Exceptions.CAPACITY_EXCEPTION);
			}
		}
}
