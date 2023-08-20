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

public class User {
    String userID;
    String password;
    String firstName;
    String lastName;
    String addressLineOne;
    String addressLineTwo;
    String state;
    int zipCode;

    public String getUserID(){
        return userID;
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

    User(String userID, String password, String firstName, String lastName, String addressLineOne, String addressLineTwo, String state, int zipCode){
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.state = state;
        this.zipCode = zipCode;
    }
}