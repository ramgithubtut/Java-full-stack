/*
	create table register(
		regid number primary key,
		fname varchar2(20),
		lname varchar2(20),
		email varchar2(20),
		pass varchar2(20),
		mobile NUMBER,
		address varchar2(50)
	);

*/

import java.sql.*;
import java.util.*;
class JDBC_1 {
	public static void main(String rags[]) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","pat","pat");
		Statement stmt=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first name");
		String fname=sc.next();
		System.out.println("enter last  name");
		String lname=sc.next();
		System.out.println("enter email");
		String email=sc.next();
		System.out.println("enter pass");
		String pass=sc.next();
		System.out.println("enter mobile");
		long mobile=sc.nextLong();
		sc.nextLine();
		System.out.println("enter address");
		String address=sc.next();
		int regid =0;
		ResultSet rs=stmt.executeQuery("select max(regid) from register");
		if(rs.next()){
			regid=rs.getInt(1);
		}
		regid++;
		String sql="insert into register values("+regid+",'"+fname+"','"+lname+"','"+email+"','"+pass+"',"+mobile+",'"+address+"')";
		int i=stmt.executeUpdate(sql);
		if(i==1)
			System.out.println(i+"record inserted");
		rs.close();stmt.close();con.close();
	}
}
