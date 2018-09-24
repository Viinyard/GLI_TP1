package pro.vinyard.chart.pie.model;

/**
 * @author VinYarD
 * created : 23/09/2018, 15:16
 */


public class PieInsets {
	
	public int extern;
	public int intern;
	public int weight;
	
	public PieInsets(int extern, int intern, int weight) {
		this.extern = extern;
		this.intern = intern;
		this.weight = weight;
	}
	
	public int getExtern() {
		return extern;
	}
	
	public void setExtern(int extern) {
		this.extern = extern;
	}
	
	public int getIntern() {
		return intern;
	}
	
	public void setIntern(int intern) {
		this.intern = intern;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
