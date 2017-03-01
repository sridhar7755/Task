# Task
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
 
public class JDBCExample {                 // Accessmodifier(public) keyword(class) className(JDBC)  
public static void main(String[] args) {	//(main) method is a static method where running of program starts from here through JVM.
Scanner sc = new Scanner(System.in);		//(Scanner) is systemdefined class used for taking input from keyboard(manually or user) (sc) is a object created by (new) keyboard (System.in) is used to retrive data from keyboard.
System.out.println("enter publisher id");    //inbuilt class(Scanner) static variable(out) method(println) used to print given text("enter publisher id") on console
int publisherID = sc.nextInt();              //object name(sc) inbuiltmethod nextInt() used to take next integer value from keybord variable name(publisherID) datatype(int)
System.out.println("enter publisher name");      //Displays (enter publisher name) text massage on console
String publisher_Name = sc.next();             //used to retrive next value from keyboard
 
System.out.println("enter author id");
int authorsID1 = sc.nextInt();
System.out.println("enter author firstname name");
String firstName = sc.next();
System.out.println("enter author lastName name");
String lastName = sc.next();
 
//After entering all the details it next goes to jdbc connection
 
try{
Class.forName("com.mysql.jdbc.Driver");            //for connecting to mysql database we need to use mysql driver
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/books","root","sridhar"); //And for connecting to database use drivermanager method and provide username and password
 
PreparedStatement stmt = con.prepareStatement("insert into publishers values (?, ?)"); //prepareStatement is used to insert values in the tables
stmt.setInt(1, publisherID);
stmt.setString(2, publisher_Name);
stmt.executeUpdate();
 
stmt = con.prepareStatement("insert into authors values(?, ?, ?)");
stmt.setInt(1, authorID);
stmt.setString(2, firstName);
stmt.setString(3, lastName);
stmt.executeUpdate();
 
 
stmt.close();
System.out.println("Inserted records into the table..."); //After all values inserted it will display inserted records into the  table otherwise it will throws an error
}
catch(Exception e)
{ 
System.out.println(e);
}
}
}
