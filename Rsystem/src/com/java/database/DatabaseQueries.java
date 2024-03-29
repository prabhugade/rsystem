package com.java.database;

public abstract class DatabaseQueries 
{
	/**
	 * for login check
	 */
	public static String loginCheck="SELECT `UserId`, `UserName`, `Password`, `Status`, `FirstName`, `LastName`, `Email`, `Address`, `City`, `State`, `Pincode`, `RegisterDate` FROM "+DatabaseTables.Users+" WHERE `UserName`=? AND `Password`=?";
	
	/**
	 * for register user
	 */
	public static String registration="INSERT INTO `Users`(`UserName`,`Password`,`Status`,`FirstName`,`LastName`,`Email`,`Address`,`City`,`State`,`Pincode`,`RegisterDate`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 *  getting the user info
	 */
	public static String getProfileData="SELECT `UserId`, `UserName`, `Password`, `Status`, `FirstName`, `LastName`, `Email`, `Address`, `City`, `State`, `Pincode`, `RegisterDate` FROM `Users` WHERE `UserName`=? AND `Password`=? AND Status='1'";
	/**
	 * 
	 */
	public static String updateProfile="UPDATE `Users` SET `UserName`=?,`Password`=?,`FirstName`=?,`LastName`=?,`Email`=?,`Address`=?,`City`=?,`State`=?,`Pincode`=? WHERE UserId=?";
	
	/**
	 * 
	 */
	public static String addReminders="INSERT INTO `Reminder`(`UserId`, `ReminderType`, `ReminderRepeat`, `ReminderDate`, `ReminderEntryDate`, `ReminderDescription`, `ReminderMessage`, `Status`) VALUES (?,?,?,?,?,?,?,?)";
}
