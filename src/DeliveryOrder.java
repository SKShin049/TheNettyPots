import java.util.Arrays;

/**
 * DeliveryOrder extends Order class
 * 8/8/23
 * Morgan Barrett
 * All methods are inherited from Order class
 */

public class DeliveryOrder extends Order{
       User customer = new User(){
    };

    public void readyAt(){
        //calculates when pizza will be ready
    }

    //Need to add the function that checks zipcode in delivery scene
    public boolean checkRadius(int customerZip){
        int[] zipCodes = {91330, 91324, 91325, 91343, 91345, 91326, 91311, 91306, 91335, 91406}; //zips in the surrounding area that we can deliver to
        //customer.zipCode = customerZip;
        for (int i : zipCodes) {
            if (i == customerZip) {
                return true;
            }
        }
        return false;

    }
}