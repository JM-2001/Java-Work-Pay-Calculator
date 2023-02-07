package my.workPayCalc;

import javax.swing.*;
import java.awt.*;

/**
 * This class WorkDataRenderer extends DefaultListCellRenderer which gets used
 * to replace the ListCellRenderer in JList to show the WorkData class's
 * toString method
 *
 * @author https://github.com/echoblu
 */
public class WorkDataRenderer extends DefaultListCellRenderer {

    @Override
    /**
     * This Component method has 5 parameters which are used to show the
     * WorkData class's toString method
     *
     * @param list The JList object
     * @param value The object value
     * @param index The JList index
     * @param isSelected The selected Boolean
     * @param cellHasFocus The Boolean to check if JList cell is focused
     * @return This Component method back
     */
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Calls the superclass's method to add the parameters to that method
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Declares WorkData object 
        WorkData workData = (WorkData) value;

        // Sets the text using workData.toString
        setText(workData.toString());

        // Return this method
        return this;
    }
}
