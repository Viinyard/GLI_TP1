package pro.vinyard.chart.pie.Layout;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VinYarD
 * created : 22/09/2018, 22:21
 */


public class PieChartLayout implements LayoutManager2 {
	
	private List<Component> components;
	
	public PieChartLayout() {
		this.components = new ArrayList<>();
	}
	
	@Override
	public void addLayoutComponent(Component comp, Object constraints) {
		this.components.add(comp);
	}
	
	@Override
	public Dimension maximumLayoutSize(Container target) {
		return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Override
	public float getLayoutAlignmentX(Container target) {
		return 0.5f;
	}
	
	@Override
	public float getLayoutAlignmentY(Container target) {
		return 0.5f;
	}
	
	@Override
	public void invalidateLayout(Container target) {
	
	}
	
	@Override
	public void addLayoutComponent(String name, Component comp) {
	
	}
	
	@Override
	public void removeLayoutComponent(Component comp) {
	
	}
	
	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return new Dimension(parent.getInsets().left + parent.getInsets().right, parent.getInsets().top + parent.getInsets().right);
	}
	
	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return new Dimension(parent.getInsets().left + parent.getInsets().right, parent.getInsets().top + parent.getInsets().right);
	}
	
	@Override
	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();
		Dimension dimension = parent.getSize();
		
		for(Component comp : this.components) {
			Rectangle r = new Rectangle();
			
			int size = Math.min(dimension.width, dimension.height);
			
			r.setSize(size, size);
			
			r.setLocation(0, 0);
			
			comp.setBounds(r);
		}
	}
}
