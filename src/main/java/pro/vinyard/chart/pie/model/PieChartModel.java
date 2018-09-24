package pro.vinyard.chart.pie.model;

import pro.vinyard.chart.pie.model.adapter.PieChartModelListener;

import javax.swing.event.TableModelListener;
import java.awt.*;
import java.math.BigDecimal;

/**
 * @author VinYarD
 * created : 22/09/2018, 16:58
 */


public interface PieChartModel {
	
	/**
	 * Returns the color for the slice at <code>index</code> and
	 *
	 * @param   index        the slice whose value is to be queried
	 * @return  the value Color at the specified slice
	 */
	Color getColorAt(int index);
	
	/**
	 * Returns the value for the slice at <code>index</code> and
	 *
	 * @param   index        the slice whose value is to be queried
	 * @return  the value BigDecimal at the specified slice
	 */
	BigDecimal getValueAt(int index);
	
	/**
	 * Return the total amout of all the slice value in the model.
	 * <code>PieChartComponent</code> uses this method to determine the percentage of each slice it should display.
	 * This method should be quick, as it is called frequently during rendering.
	 * @return
	 */
	BigDecimal getTotal();
	
	String getLabelAt(int index);
	
	/**
	 * Returns the number of slice in the model. A
	 * <code>PieChartComponent</code> uses this method to determine how many slice it
	 * should display.  This method should be quick, as it
	 * is called frequently during rendering.
	 *
	 * @return the number of slice in the model
	 */
	int getSliceCount();
	
	/**
	 * Adds a listener to the list that is notified each time a change
	 * to the data model occurs.
	 *
	 * @param   l               the PieChartModelListener
	 */
	void addPieChartModelListener(PieChartModelListener l);
	
	/**
	 * Removes a listener from the list that is notified each time a
	 * change to the data model occurs.
	 *
	 * @param   l               the PieChartModelListener
	 */
	void removePieChartModelListener(PieChartModelListener l);
}
