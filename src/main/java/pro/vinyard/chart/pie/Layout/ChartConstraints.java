package pro.vinyard.chart.pie.Layout;

/**
 * @author VinYarD
 * created : 23/09/2018, 00:23
 */


public class ChartConstraints implements Cloneable {
	
	private int weight;
	
	public ChartConstraints() {
		this(1);
	}
	
	public ChartConstraints(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Creates a copy of this grid bag constraint.
	 * @return     a copy of this grid bag constraint
	 */
	public Object clone () {
		try {
			ChartConstraints c = (ChartConstraints) super.clone();
			return c;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError(e);
		}
	}
}
