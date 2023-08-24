/**
 * Class Name: User
 * A class that will will be used to register information about the user. 
 * Date of Code: 08/10/2023
 * @author Renzo Pereyra
 */

/** 
 * Creates a "user" class.
 * It contains input values which can be used to create a user account. These values can then be referenced to fetch user preferences and ease integration for future user orders.
 */

 import java.io.*; //For file reading
 import java.util.*; //for Scanner

public class User 
{
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String addressLineOne;
    public String addressLineTwo;
    public String city;
    public String state;
    public int zipCode;
    public String email;

    public String getusername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddressLineOne(){
        return addressLineOne;
    }
    public String getAddressLineTwo(){
        return addressLineTwo;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public int getZipCode(){
        return zipCode;
    }

    public User(String username, String password, String firstName, String lastName, String addressLineOne, String addressLineTwo, String state, int zipCode, String email, String city)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
    }

    public User(){
        //empty constructor
    }
    String loggedInFileName = "./TheNettyPots/src/resources/CurrentlyLoggedIn.txt";
    public void setLoggedIn(User user){
        try(FileWriter orderWriter = new FileWriter(loggedInFileName, true); 
        BufferedWriter itemInfo = new BufferedWriter(orderWriter);
        PrintWriter out = new PrintWriter(itemInfo))
        {
        out.println(user.username + "_" + user.password + "_" + user.firstName + "_" + user.lastName
        + "_" + user.addressLineOne + "_" + user.addressLineTwo + "_" + user.state + "_" + user.zipCode + "_" + user.city + "_" + user.email);
    } 
    catch (IOException e) {
        System.out.println("function no work");
    }
    }

    public boolean checkifLoggedIn() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./TheNettyPots/src/resources/CurrentlyLoggedIn.txt"));     
            if (br.readLine() == null) 
                return false;
            return true;
    }

    public User getLoggedIn (){

        User user = new User(username, password, firstName, lastName, addressLineOne, addressLineTwo, state, zipCode, email, city);
        File file = new File(loggedInFileName);
        try {                                                               //This try catch will read our MenuFile(Database that contains our menu items) line by line, and allows our fillMenu function
            FileReader fileReader = new FileReader(file);                   //to insert each menu item into the proper menu array.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            String line = bufferedReader.readLine();
            while (line != null) {
                //System.out.println(line);
                fillUser(line, user);
                line = bufferedReader.readLine();
            }
    
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void fillUser(String line, User user){
        String[] parts = line.split("_");
        String uName = parts[0];
		String uPass =parts[1];
		String ufirst = parts[2];
		String ulast = parts[3];
		String uSA1 = parts[4];
		String uSA2 =parts[5];
		String ustate =parts[6];
		int uZipCode = Integer.parseInt(parts[7]);
        String uemail = parts[8];
        String ucity = parts[9];
        User temp = new User(uName, uPass, ufirst, ulast, uSA1, uSA2, ustate, uZipCode, uemail,ucity);
        user = temp;

    }

}