import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
 
public class JDBCExample {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("enter publisher id");
int publisherID = sc.nextInt();
System.out.println("enter publisher name");
String publisher_Name = sc.next();
 
System.out.println("enter author id");
int authorsID1 = sc.nextInt();
System.out.println("enter author firstname name");
String firstName = sc.next();
System.out.println("enter author lastName name");
String lastName = sc.next();
 

 
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/books","root","nooraen");
 
PreparedStatement stmt = con.prepareStatement("insert into publishers values (?, ?)");
stmt.setInt(1, publisherID);
stmt.setString(2, publisher_Name);
stmt.executeUpdate();
 
stmt = con.prepareStatement("insert into authors values(?, ?, ?)");
stmt.setInt(1, authorID);
stmt.setString(2, firstName);
stmt.setString(3, lastName);
stmt.executeUpdate();
 
 
stmt.close();
System.out.println("Inserted records into the table...");
}
catch(Exception e)
{
System.out.println(e);
}
}
}