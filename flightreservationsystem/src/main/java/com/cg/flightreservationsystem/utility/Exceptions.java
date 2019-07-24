package com.cg.flightreservationsystem.utility;

public class Exceptions {
	public static final String CAPACITY_EXCEPTION = "You have entered incorrect format of capacity, please try again!! ";
	public static final String FOREIGN_KEY_CONSTRAINT = "Could not delete from the database as it is foreign key";
	public static final String CITY_INCORRECT = "You have entered wrong format of city , please try again!!";
	public static final String INVALID_TIME = "Given time is Invalid, it does not match with the required format hh:mm ";
	// public static final String INVALID_DATE = "Given date is Invalid, it does not
	// match with the required format dd-mm-yyyy ";
	// public static final String INVALID_PRICE = "Given price is Invalid ";
	public static final String DATE_NOT_EXIST = "This date does not exist";
	public static final String ID_INVALID = "This ID does not exist";
	public static final String CITY_EQUALS = "The source and destination city cannot be same";
	public static final String TIME_EQUALS = "Arrival and departure time cannot be the same";
	public static final String EMPTY_LIST = "Please enter the values !!";
	public static final String CONNECTION_EXCEPTION = "The data is not added to the database";
}
