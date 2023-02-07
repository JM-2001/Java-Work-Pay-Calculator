package my.workPayCalc;

/**
 * This class WorkData implements Comparable which will contain the work data
 * information and calculate the time and net pay
 *
 * @author https://github.com/echoblu
 */
public class WorkData implements Comparable {

    // Declare variables
    private double payRate, otMultiplier, timeWorked, overTimeWorked, netPay;
    private String date;

    /**
     * Construct default no-arg WorkData Constructor
     */
    public WorkData() {

    }

    /**
     * Construct WorkData Constructor
     *
     * @param payRate The pay rate
     * @param otMultiplier The overtime multiplier used to calculate the
     * overtime pay
     * @param timeWorked The amount of time worked
     * @param overTimeWorked The amount of overtime worked
     * @param netPay The net pay before taxes
     * @param date The date
     */
    public WorkData(double payRate, double otMultiplier, double timeWorked, double overTimeWorked, double netPay, String date) {
        this.payRate = payRate;
        this.otMultiplier = otMultiplier;
        this.timeWorked = timeWorked;
        this.overTimeWorked = overTimeWorked;
        this.netPay = netPay;
        this.date = date;
    }

    /**
     * This method setPayRate sets the pay rate
     *
     * @param payRate The pay rate
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * This method getPayRate gets the pay rate
     *
     * @return payRate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * This method setOTMultiplier sets the overtime multiplier
     *
     * @param otMultiplier The overtime multiplier
     */
    public void setOTMultiplier(double otMultiplier) {
        this.otMultiplier = otMultiplier;
    }

    /**
     * This method getOTMultiplier gets the overtime multiplier
     *
     * @return otMultiplier the overtime multiplier
     */
    public double getOTMultiplier() {
        return otMultiplier;
    }

    /**
     * This method setTimeWorked sets the time worked
     *
     * @param timeWorked The time worked
     */
    public void setTimeWorked(double timeWorked) {
        this.timeWorked = timeWorked;
    }

    /**
     * This method getTimeWorked gets the time worked
     *
     * @return timeWorked The time worked
     */
    public double getTimeWorked() {
        return timeWorked;
    }

    /**
     * This method setOverTimeWorked sets the overtime worked
     *
     * @param overTimeWorked The overtime worked
     */
    public void setOverTimeWorked(double overTimeWorked) {
        this.overTimeWorked = overTimeWorked;
    }

    /**
     * This method getOverTimeWorked gets the overtime worked
     *
     * @return overTimeWorked The overtime worked
     */
    public double getOverTimeWorked() {
        return overTimeWorked;
    }

    /**
     * This method setNetPay sets the net pay
     *
     * @param netPay The net pay
     */
    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    /**
     * This method getNetPay gets the net pay
     *
     * @return netPay The net pay
     */
    public double getNetPay() {
        return netPay;
    }

    /**
     * This method setDate sets the date
     *
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method getDate gets the date
     *
     * @return date The date
     */
    public String getDate() {
        return date;
    }

    /**
     * This method calculateTime has 4 parameters which are used to calculate
     * the time worked and overtime worked
     *
     * @param startTime The start time of the shift
     * @param endTime The end time of the shift
     * @param otStartTime The start time of the overtime shift
     * @param otEndTime The end time of the overtime shift
     */
    public void calculateTime(String startTime, String endTime, String otStartTime, String otEndTime) {
        // Declare variables
        String delimiter = "[:,!? ]+";
        int stHour, stMin, etHour, etMin, otSTHour, otSTMin, otETHour, otETMin;
        double totalHour, totalMin, otTotalHour, otTotalMin;

        // Splits the String into two seperate string and each string is converted to a double and assigned to a variable
        String[] tokens = startTime.split(delimiter);
        stHour = Integer.parseInt(tokens[0]);
        stMin = Integer.parseInt(tokens[1]);

        // Splits the String into two seperate string and each string is converted to a double and assigned to a variable
        tokens = endTime.split(delimiter);
        etHour = Integer.parseInt(tokens[0]);
        etMin = Integer.parseInt(tokens[1]);

        // Splits the String into two seperate string and each string is converted to a double and assigned to a variable
        tokens = otStartTime.split(delimiter);
        otSTHour = Integer.parseInt(tokens[0]);
        otSTMin = Integer.parseInt(tokens[1]);

        // Splits the String into two seperate string and each string is converted to a double and assigned to a variable
        tokens = otEndTime.split(delimiter);
        otETHour = Integer.parseInt(tokens[0]);
        otETMin = Integer.parseInt(tokens[1]);

        // Calculates the amount of time worked and divides the mins by 60 to easily calculate the pay for those minutes
        totalHour = Math.abs(etHour - stHour);
        totalMin = Math.abs(etMin - stMin);
        totalMin = totalMin / 60;

        // Calculates the amount of overtime worked and divides the mins by 60 to easily calculate the pay for those minutes
        otTotalHour = Math.abs(otETHour - otSTHour);
        otTotalMin = Math.abs(otETMin - otSTMin);
        otTotalMin = otTotalMin / 60;

        // Calls the set methods to set the total time
        this.setTimeWorked(totalHour + totalMin);
        this.setOverTimeWorked(otTotalHour + otTotalMin);
    }

    /**
     * This method calculateNetPay is used to calculate the net pay and calls
     * setNetPay to set the net pay from the calculation
     */
    public void calculateNetPay() {
        this.setNetPay((this.getTimeWorked() * this.getPayRate()) + (this.getOverTimeWorked() * (this.getOTMultiplier() * this.getPayRate())));
    }

    @Override
    /**
     * This method toString is used to represent the WorkData class in string
     * format
     *
     * @return returnString The string holding string representation
     */
    public String toString() {
        String returnString = this.getDate() + " - $" + this.getPayRate() + " - " + this.getTimeWorked() + " - " + this.getOverTimeWorked() + " - $" + this.getNetPay();
        return returnString;
    }

    @Override
    /**
     * This method compareTo is used to compare the elements of each object
     *
     * @param o The object
     * @return The value of whether an object is similar to the parameter o
     */
    public int compareTo(Object o) {
        if (((WorkData) o).getDate().compareTo(this.date) >= 1) {
            return 1;
        } else if (((WorkData) o).getDate().compareTo(this.date) <= 1) {
            return -1;
        } else {
            return 0;
        }
    }

}
