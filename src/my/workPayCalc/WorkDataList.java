package my.workPayCalc;

import java.util.*;
import javax.swing.*;

/**
 * The class WorkDataList extends from the AbstractListModel which allows JList
 * to create an Abstract List Model which allows the addition and removal of
 * elements from the JList. An ArrayList will be used to hold a dynamic array of
 * WorkData objects. In addition, it can be used to calculate the total time and
 * total net pay of the ArrayList
 *
 * @author https://github.com/echoblu
 */
class WorkDataList extends AbstractListModel<WorkData> {

    // Declare variables
    private ArrayList<WorkData> dataList = new ArrayList<>();

    @Override
    /**
     * This method getSize() gets the size of the ArrayList
     *
     * @return The dataList ArrayList
     */
    public int getSize() {
        return dataList.size();
    }

    @Override
    /**
     * This method getElementAt() gets the element located at the index in the
     * ArrayList
     *
     * @return The element located at the index of ArrayList
     */
    public WorkData getElementAt(int index) {
        return dataList.get(index);
    }

    /**
     * This method addWorkData() has 6 parameters which are used to declare a
     * new WorkData object that'll be added to the ArrayList
     *
     * @param payRate The pay rate
     * @param otMultiplier The overtime multiplier to calculate the overtime pay
     * rate
     * @param timeWorked The amount of time worked
     * @param overTimeWorked The amount of overtime worked
     * @param netPay The net pay before taxes
     * @param date The date
     */
    public void addWorkData(double payRate, double otMultiplier, double timeWorked, double overTimeWorked, double netPay, String date) {
// Gets the size of the ArrayList        
        int index = this.getSize();

        // Declares a new WorkData object with the 6 parameters and adds it to the ArrayList
        dataList.add(index, new WorkData(payRate, otMultiplier, timeWorked, overTimeWorked, netPay, date));

        // Adds this to WorkDataList
        fireIntervalAdded(this, index, index);
    }

    /**
     * This method removes the selected item from the JList and the ArrayList
     *
     * @param i The index of the selected item from the JList
     */
    public void removeWorkData(int i) throws Exception {
        // Gets the size of the ArrayList        
        int index = this.getSize();

        // Removes the element from the ArrayList
        dataList.remove(i);

        // Removes this from WorkDataList
        fireIntervalRemoved(this, index, index);
    }

    /**
     * This method calculates the total time worked by going through the
     * ArrayList
     *
     * @return The total amount of time worked
     */
    public double totalTime() {
        // Declare variable
        double totalTimeWorked = 0;

        // Declare a for loop to go through each element in the ArrayList object and gets added to the total time worked
        for (int pos = 0; pos < dataList.size(); pos++) {
            totalTimeWorked += dataList.get(pos).getTimeWorked();
        }

        // Return totalTimeWorked   
        return totalTimeWorked;
    }

    /**
     * This method calculates the total net pay by going through the ArrayList
     *
     * @return The total net pay
     */
    public double totalNetPay() {
        // Declare variable
        double totalNetPay = 0;

        // Declare a for loop to go through each element in the ArrayList object and gets added to the total net pay
        for (int pos = 0; pos < dataList.size(); pos++) {
            totalNetPay += dataList.get(pos).getNetPay();
        }

        // Return totalNetPay
        return totalNetPay;
    }

}
