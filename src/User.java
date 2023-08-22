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

    public User(String username, String password, String firstName, String lastName, String addressLineOne, String addressLineTwo, String state, int zipCode)
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
    }

    public User(){
        //empty constructor
    }

    public static void userMain() throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchElementException
    {
        FileWriter fw = new FileWriter("/Users/MorganBarrett/Desktop/School/CSUN/Summer2023/COMP380/TheNettyPots/src/resources/AccountDB.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        //writes to file
        PrintWriter out = new PrintWriter(bw);
        
        //creates a File object for Scanner to refer to + read from
        //doesn't actually create a new file
        Scanner in = new Scanner (new File ("/Users/MorganBarrett/Desktop/School/CSUN/Summer2023/COMP380/TheNettyPots/src/resources/AccountDB.txt"));
        
        //uses colon as delimiter when reading login info from txt file
        in.useDelimiter(";"); 
        
        //reads from user input
        Scanner userIn = new Scanner (System.in);
        String nulled = null;
            
        User account = new User("none", "none", "none", "none", "none", "none", "none", 00000);

        System.out.println("1) Login");
        System.out.println("2) Signup");
        System.out.print("Please make your selection: ");
        
        boolean userSuccess = false;
        boolean passSuccess = false;
        String compare;
        int indexCount = 0;
        int choice = userIn.nextInt();

        File file = new File("resources/AccountDB.txt");
        ArrayList<Scanner> scanList = new ArrayList<Scanner>();

        //prevents skipping from reading int variables
        userIn.nextLine(); 
        switch (choice)
        {
            case 1:
            {
                //will be used to compare stored values in text file
                try 
                {
                    while (!userSuccess)
                    {
                        //reset Scanner + use colon delimiter
                        scanList.add(new Scanner(file));
                        scanList.get(indexCount).useDelimiter(";");

                        //if login, read info from file
                        System.out.println("Please login.");

                        //check if username exists, else throw an error?
                        System.out.print("Username: ");

                        //receives username from user, stores in Account class
                        account.username = userIn.nextLine();
                        
                        
                        while (scanList.get(indexCount).hasNext())
                        {
                            compare = scanList.get(indexCount).next();
                            //System.out.println("Searchiiiiiiiiing: " + compare);
                            System.out.println("###COMPARE###: " + compare);
                            if (compare.equals(account.username))
                            {
                                System.out.print("Success!");
                                System.out.println();
                                userSuccess = true;
                                break;
                            }
                            else
                            {
                                //System.out.println("Not found...");
                                //runs once per line to check first entry (username)
                                //delimiter will stop it from reading other info
                                scanList.get(indexCount).nextLine();
                            }
                        }
                        if (!userSuccess)
                        {
                            System.out.println("Please try again.");
                        }
                        scanList.get(indexCount).close();
                        scanList.remove(indexCount);
                    }
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("An error has occurred. Please try restarting the application");
                }

                //check if password exists, else throw an error
                try 
                {
                    while (!passSuccess)
                    {
                        //reset Scanner + use colon delimiter
                        scanList.add(new Scanner(file));
                        scanList.get(indexCount).useDelimiter(";");

                        //check if password exists, else throw an error?
                        System.out.print("Password: ");

                        //receives password from user, stores in Account class
                        account.password = userIn.nextLine();

                        while (scanList.get(indexCount).hasNext())
                        {
                            //skip first entry
                            scanList.get(indexCount).next();
                            //assign second entry to compare
                            compare = scanList.get(indexCount).next();
                            //System.out.println("Searchiiiiiiiiing: " + compare);
                            System.out.println("###COMPARE###: " + compare);
                            if (compare.equals(account.password))
                            {
                                System.out.print("Success!");
                                System.out.println();
                                passSuccess = true;
                                break;
                            }
                            else
                            {
                                //System.out.println("Not found...");
                                //runs once per line to check second entry (password)
                                //delimiter will stop it from reading other info
                                scanList.get(indexCount).nextLine();
                            }
                        }
                        if (!passSuccess)
                        {
                            System.out.println("Please try again.");
                        }
                        scanList.get(indexCount).close();
                        scanList.remove(indexCount);
                    }
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("An error has occurred. Please try restarting the application");
                }

                //if account.username/password both match what is on "AccountDB.txt", 
                //then login and load previous orders/info,etc.
                try
                {
                    
                    if ((userSuccess == true) && (passSuccess == true))
                    {
                        System.out.println();
                        System.out.println("Successfully logged in!");
                        
                        //reset Scanner + use colon delimiter
                        scanList.add(new Scanner(file));
                        scanList.get(indexCount).useDelimiter(";");
                        int counter = 1;

                        while (scanList.get(indexCount).hasNext())
                        {
                            compare = scanList.get(indexCount).next();
                            if (compare.contains(account.password))
                            {
                                while ((compare != "\n") && (counter < 8))
                                {
                                    compare = scanList.get(indexCount).next();
                                    System.out.println(counter + ") " + compare);

                                    //assign value to "account" object
                                    switch (counter)
                                    {
                                        case 1:
                                        {
                                            account.firstName = compare;
                                            break;
                                        }
                                        case 2:
                                        {
                                            account.lastName = compare;
                                            break;
                                        }
                                        case 3:
                                        {
                                            account.addressLineOne = compare;
                                            break;
                                        }
                                        case 4:
                                        {
                                            account.addressLineTwo = compare;
                                            break;
                                        }
                                        case 5:
                                        {
                                            account.city = compare;
                                            break;
                                        }
                                        case 6:
                                        {
                                            account.state = compare;
                                            break;
                                        }
                                        case 7:
                                        {
                                            try
                                            {
                                                account.zipCode = Integer.parseInt(compare);
                                            }
                                            catch (NumberFormatException e)
                                            {
                                                account.zipCode = 00000;
                                            }
                                            break;
                                        }
                                    }
                                    counter++;
                                }
                            }
                        }
                        System.out.println();
                        scanList.get(indexCount).close();
                        scanList.remove(indexCount);
                    }
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("An error has occurred!");
                }
                break;
            }



            case 2:
            {
                //if new user, store info into file
                //User presses "Sign Up" button... then:
            
                System.out.println("Creating a new account...");
                System.out.println("Please type for the following:");
                System.out.println("Username: ");
                {
                    //Required
                    account.username = userIn.nextLine();
                    out.print(account.username + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Password: ");
                {
                    //Required
                    account.password = userIn.nextLine();
                    out.print(account.password + ";");
                    System.out.println("DONE!");
                }

                System.out.println("First Name: ");
                {
                    account.firstName = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.firstName == null)
                    {
                        account.firstName = "N/A";
                    }
                    out.print(account.firstName + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Last Name: ");
                {
                    account.lastName = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.lastName == null)
                    {
                        account.lastName = "N/A";
                    }
                    out.print(account.lastName + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Address Line: ");
                {
                    account.addressLineOne = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.addressLineOne == null)
                    {
                        account.addressLineOne = "N/A";
                    }
                    out.print(account.addressLineOne + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Address Line 2: ");
                {
                    account.addressLineTwo = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.addressLineTwo == null)
                    {
                        account.addressLineTwo = "N/A";
                    }
                    out.print(account.addressLineTwo + ";");
                    System.out.println("DONE!");
                }

                System.out.println("City: ");
                {
                    account.city = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.city == null)
                    {
                        account.city = "N/A";
                    }
                    out.print(account.city + ";");
                    System.out.println("DONE!");
                }

                System.out.println("State: ");
                {
                    account.state = userIn.nextLine();
                    //if user doesn't put anything, add "N/A"
                    if (account.state == null)
                    {
                        account.state = "N/A";
                    }
                    out.print(account.state + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Zip Code: ");
                {
                    account.zipCode = userIn.nextInt();
                    //if user doesn't put anything, add "N/A"
                    // (!!!) find better implementation of int equivalent of "null"
                    if (account.zipCode <= 0) 
                    {
                        account.zipCode = 00000;
                    }
                    out.print(account.zipCode + ";");
                    System.out.println("DONE!");
                    userIn.nextLine(); //prevents skipping from reading int variables
                }
                out.println();
                System.out.println("Done writing!");
                //finalizes the line and moves to nextLine
                //if nextLine is null, then stop reading.
            }
        }
        System.out.println("You've reached the end!");
        System.out.println();
        
        //for debugging purposes only
        System.out.println("Username: " + account.username);
        System.out.println("Password: " + account.password);
        System.out.println("First Name: " + account.firstName);
        System.out.println("Last Name: " + account.lastName);
        System.out.println("Address: " + account.addressLineOne);
        System.out.println("Address 2: " + account.addressLineTwo);
        System.out.println("City: " + account.city);
        System.out.println("State: " + account.state);
        System.out.println("Zip Code: " + account.zipCode);

        in.close();
        userIn.close();
        out.close();
    }
}