
//Luis Valenzuela
// Description: Class Assignment JDBC WK 11
// Use this JAVA File provided by canvas 
// import mysql connector
// fix driver to connect to database
// Date: 04/08/2023
//IntelliJ IDEA: Add MySQL JAR file to Java Project
//private static final String password = "password goes here"; not included for privacy
//Refer to original submission for code


import java.sql.*;

//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;

class JDBCTest {

    private static final String url = "jdbc://jdbc:mysql://database-nyit.czdaczyt3bis.us-east-1.rds.amazonaws.com/nyit_1299302_classicmodels";
    private static final String user = "student_user";
    private static final String password = "password goes here";

    public static void main(String args[]) {
   	
	Statement stmt = null;
        Connection conn = null;

	try {

      	//STEP 1: Register JDBC driver
     	Class.forName("com.mysql.cj.jdbc.Driver");

      	//STEP 2: Connect via JDBC driver
      	System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Success : Connected to the database");

      	//STEP 3: Open a connection
      	//System.out.println("Connecting to database...");
      	//conn = DriverManager.getConnection(DB_URL,USER,PASS);

      	//STEP 4: Execute a query
      	System.out.println("Creating statement...");
      	stmt = conn.createStatement();
      	String sql;
      	sql = "SELECT * FROM customers;";
      	ResultSet rs = stmt.executeQuery(sql);

         System.out.println(" ");
      	//STEP 5: Extract data from result set
      	while(rs.next()){
         	//Retrieve by column name
         	int customerNumber  	= rs.getInt("customerNumber");
         	String customerName= rs.getString("customerName");
         	String contactLastName	= rs.getString("contactLastName");
			String contactFirstName	= rs.getString("contactFirstName");
         	String phone 	= rs.getString("phone");
			String addressLine1	= rs.getString("addressLine1");
			String addressLine2 	= rs.getString("addressLine2");
			String city	= rs.getString("city");
			String state 	= rs.getString("state");
			String postalCode	= rs.getString("postalCode");
			String country 	= rs.getString("country");
			int salesRepEmployeeNumber  	= rs.getInt("salesRepEmployeeNumber");
			float creditLimit  	= rs.getFloat("creditLimit");



         	//Display values
         	System.out.println("Customer Number     : " + customerNumber);
         	System.out.println("Contact Last Name   : " + contactLastName);
         	System.out.println("Contact First Name : " + contactFirstName);
         	System.out.println("Phone       : " + phone);
			System.out.println("Address Line 1    : " + addressLine1);
			System.out.println("Address Line 2    : " + addressLine2 );
			System.out.println("City : " + city);
			System.out.println("State     : " + state);
			System.out.println("Postal Code   : " + postalCode);
			System.out.println("Country : " + country);
			System.out.println("Sales Rep Employee Number    : " + salesRepEmployeeNumber );
			System.out.println("Credit Limit : " + creditLimit);

      	}
      
	//STEP 6: Clean-up environment
      	rs.close();
      	stmt.close();
      	conn.close();
   	}catch(SQLException se){
      	//Handle errors for JDBC
      	se.printStackTrace();
   	}catch(Exception e){
      	//Handle errors for Class.forName
      	e.printStackTrace();
   	}finally{
      	//finally block used to close resources
      	try{
         	if(stmt!=null)
            	stmt.close();
      	}catch(SQLException se2){
      	}// nothing we can do
      	try{
         	if(conn!=null)
            	conn.close();
      	}catch(SQLException se){
         	se.printStackTrace();
      	}//end finally try
   	}//end try
   	System.out.println("Goodbye!");
   }


}

