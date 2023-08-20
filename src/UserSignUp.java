import java.io.*;

public class UserSignUp{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		//Implement if/else
		//if: create a new "AccountDB" text file and pull account info from it
		//else: increment account count by 1, use separator character to separate account/textbox info?
		
		//userID, password, firstName, lastName, addressLineOne, addressLineTwo, state, zipCode
		User account1 = new User("test1", "testpassword", "testName", "testLastName", "address1", "address2", "California", 90010);
		//writing to file using ObjectOutputStream
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("AccountDB.txt"));
		out.writeObject(account1); 
		
		//creating other instance from file
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("AccountDB.txt"));
		User account2 = new User("test2", "testpassword2", "testName2", "testLastName2", "address1.2", "address2.2", "Texas", 90020);

		//checking to see if it was done correctly
		System.out.println(account1.userID);
		System.out.println(account2.userID);
	}
}