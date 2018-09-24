package pro.vinyard.chart.pie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;

/**
 * @author VinYarD
 * created : 22/09/2018, 14:52
 */


public class SliceComponent extends JComponent {

	private double extent;
	private Color color;
	private double start;
	
	private boolean selected = true;
	
	private Shape shape;
	
	public SliceComponent() {
		this.setAlignmentX(0.5f);
		this.setAlignmentY(0.5f);
		this.setOpaque(false);
	}
	
	@Override
	public boolean isLightweight() {
		return true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(this.getColor());
		
		this.shape = new Arc2D.Double(0, 0, this.getSize().width, this.getSize().height, this.start, this.extent, Arc2D.Double.PIE);
		
		g2.fill(this.shape);
		
		g2.setStroke(new BasicStroke(1));
		
		g2.setColor(this.getBackground());
		
		g2.draw(this.shape);
		
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public double getStart() {
		return start;
	}
	
	public void setStart(double start) {
		this.start = start;
	}
	
	public double getExtent() {
		return extent;
	}
	
	public void setPercent(double extent) {
		this.extent = extent;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.shape.contains(x, y);
	}
}
