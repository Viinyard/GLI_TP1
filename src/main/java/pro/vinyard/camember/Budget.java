package pro.vinyard.camember;

import java.awt.*;
import java.math.BigDecimal;

/**
 * @author VinYarD
 * created : 21/09/2018, 08:54
 */


public class Budget {
	
	private String label;
	private BigDecimal count;
	private String description;
	private Color color = Color.BLACK;
	
	public Budget(String label, BigDecimal count, String description, Color color) {
		this.label = label;
		this.count = count;
		this.description = description;
		this.color = color;
	}
	
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public BigDecimal getCount() {
		return count;
	}
	
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
