/** The interface that DeliveryOrder.java and CarryOutOrder.java will use
 * These methods don't have bodies. Methods will be defined in each class implementation
 */
interface Order {
    public void deliveryETA(); 
    public void readyAt();
    public void checkRadius();

}
