package com.java.database;

public abstract class DatabaseQueries 
{
	/**
	 * for login check
	 */
	public static String loginCheck="SELECT `UserId`, `UserName`, `Password`, `Status`, `FirstName`, `LastName`, `Email`, `Address`, `City`, `State`, `Pincode`, `RegisterDate` FROM "+DatabaseTables.Users+" WHERE `UserName`=? AND `Password`=?";
}
