package firstproject;
import java.util.*;
import java.sql.SQLException;
//import java.util.Scanner;
public class StudentData {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DataBaseOperations db=new DataBaseOperations();
		db.connectDataBase();
		char ch;
		do
		{
			System.out.println("Enter the Option: ");
			System.out.println("1.Insert Data\n"
					+ "2.Display Data\n"
					+ "3.Delete H.T.No. Data");
			int o=sc.nextInt();
			try
			{
				switch(o)
				{
					case 1: db.dataEntry();
							db.insert();
							break;
					case 2: db.display();
							break;
					case 3: System.out.println("Enter HTNo: ");
							int htno=sc.nextInt();
							db.delete(htno);
							break;
					default: System.out.println("Invalid Option!");
				}
			}
			catch(SQLException e)
			{
				//System.out.println("Insert Operation failed");
				e.getMessage();
			}
			System.out.println("Do you want to continue..?");
			ch=sc.next().charAt(0);
		}while(ch=='y');
		System.out.println("Application Closed.");
	}
}
