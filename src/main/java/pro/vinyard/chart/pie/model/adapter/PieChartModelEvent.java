package pro.vinyard.chart.pie.model.adapter;

import pro.vinyard.chart.pie.model.PieChartModel;

import java.util.EventObject;

/**
 * @author VinYarD
 * created : 22/09/2018, 16:54
 */


public class PieChartModelEvent extends EventObject {
	
	/**
	 * Identifies the addition of new slice.
	 */
	public static final int INSERT = 1;
	
	/**
	 * Identifies a hange to existing data.
	 */
	public static final int UPDATE = 0;
	
	/**
	 * Identifies the removal of slice.
	 */
	public static final int DELETE = -1;
	
	/**
	 * Specifies all slice.
	 */
	public static final int ALL = -1;
	
	private int slice;
	private int type;
	
	public PieChartModelEvent(PieChartModel source) {
		this(source, ALL, UPDATE);
	}
	
	public PieChartModelEvent(PieChartModel source, int slice, int type) {
		super(source);
		this.slice = slice;
		this.type = type;
	}
	
	public int getSlice() {
		return slice;
	}
	
	public int getType() {
		return type;
	}
}
