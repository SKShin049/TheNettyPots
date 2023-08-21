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

    public User(String username, String password, String firstName, String lastName, String addressLineOne, String addressLineTwo, String state, int zipCode)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.state = state;
        this.zipCode = zipCode;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchElementException
    {
        FileWriter fw = new FileWriter("resources/AccountDB.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        //writes to file
        PrintWriter out = new PrintWriter(bw);
        
        //creates a File object for Scanner to refer to + read from
        //doesn't actually create a new file
        Scanner in = new Scanner (new File ("resources/AccountDB.txt"));
        
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

                        //receives username from user
                        account.username = userIn.nextLine();
                        System.out.println();

                        while (scanList.get(indexCount).hasNext())
                        {
                            
                            compare = scanList.get(indexCount).next();
                            System.out.println("Searchiiiiiiiiing: " + compare);
                            if (compare.contains(account.username))
                            {
                                System.out.println("FOUND IT!");
                                System.out.println();
                                userSuccess = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Not found...");
                                System.out.println("Please try again.");
                            }
                        }
                        scanList.get(indexCount).close();
                        scanList.remove(indexCount);
                    }
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("CAUGHT AN EXCEPTION!");
                }

                //check if password exists, else throw an error
                try 
                {
                    while (!passSuccess)
                    {
                        //reset Scanner + use colon delimiter
                        scanList.add(new Scanner(file));
                        scanList.get(indexCount).useDelimiter(";");

                        //check if username exists, else throw an error?
                        System.out.print("Password: ");

                        //receives username from user
                        account.password = userIn.nextLine();
                        System.out.println();

                        while (scanList.get(indexCount).hasNext())
                        {
                            compare = scanList.get(indexCount).next();
                            System.out.println("Searchiiiiiiiiing: " + compare);
                            if (compare.contains(account.password))
                            {
                                System.out.println("FOUND IT!");
                                System.out.println();
                                passSuccess = true;
                                break;
                            }
                            else
                            {
                                System.out.println("Not found...");
                                System.out.println("Please try again.");
                            }
                        }
                        scanList.get(indexCount).close();
                        scanList.remove(indexCount);
                    }
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("CAUGHT AN EXCEPTION!");
                }



                //if account.username and account.password match what is on AccountDB.txt, then login and load previous orders/info,etc.
                if ((userSuccess == true) && (passSuccess == true))
                {
                    System.out.println("Successfully logged in!");
                    
                    //reset Scanner + use colon delimiter
                    scanList.add(new Scanner(file));
                    scanList.get(indexCount).useDelimiter(";");

                     while (scanList.get(indexCount).hasNext())
                    {
                        compare = scanList.get(indexCount).next();
                        if (compare.contains(account.password))
                        {
                            while (compare != "\n")
                            {
                                System.out.println(compare);
                                compare = scanList.get(indexCount).next();
                            }
                        }
                    }
                    scanList.get(indexCount).close();
                    scanList.remove(indexCount);
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
                    account.username = userIn.nextLine();
                    out.print(account.username + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Password: ");
                {
                    account.password = userIn.nextLine();
                    out.print(account.password + ";");
                    System.out.println("DONE!");
                }

                System.out.println("First Name: ");
                {
                    account.firstName = userIn.nextLine();
                    out.print(account.firstName + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Last Name: ");
                {
                    account.lastName = userIn.nextLine();
                    out.print(account.lastName + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Address Line: ");
                {
                    account.addressLineOne = userIn.nextLine();
                    out.print(account.addressLineOne + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Address Line 2: ");
                {
                    account.addressLineTwo = userIn.nextLine();
                    out.print(account.addressLineTwo + ";");
                    System.out.println("DONE!");
                }

                System.out.println("State: ");
                {
                    account.state = userIn.nextLine();
                    out.print(account.state + ";");
                    System.out.println("DONE!");
                }

                System.out.println("Zip Code: ");
                {
                    account.zipCode = userIn.nextInt();
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
        in.close();
        userIn.close();
        out.close();
    }
}