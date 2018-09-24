package pro.vinyard.chart.pie.Layout;

import java.awt.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

/**
 * @author VinYarD
 * created : 22/09/2018, 22:21
 */


public class DoughnutChartLayout implements LayoutManager2 {
	
	private Map<Component, ChartConstraints> components;
	private List<Component> orderedComponenets;
	
	private ChartConstraints defaultConstraints;
	
	public DoughnutChartLayout() {
		this.components = new Hashtable<>();
		this.orderedComponenets = new LinkedList<>();
		this.defaultConstraints = new ChartConstraints(5);
	}
	
	@Override
	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints instanceof ChartConstraints) {
			setConstraints(comp, (ChartConstraints) constraints);
		} else if (constraints != null) {
			throw new IllegalArgumentException("cannot add to layout: constraints must be a ChartConstraints");
		}
	}
	
	public void setConstraints(Component comp, ChartConstraints constraints) {
		orderedComponenets.add(comp);
		components.put(comp, (ChartConstraints) constraints.clone());
	}
	
	public ChartConstraints getConstraints(Component comp) {
		ChartConstraints constraints = components.get(comp);
		if (constraints == null) {
			setConstraints(comp, defaultConstraints);
			constraints = components.get(comp);
		}
		return (ChartConstraints)constraints.clone();
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
		
		int totalWeight = 0;
		for(Component comp : this.components.keySet()) {
			ChartConstraints cc = getConstraints(comp);
			totalWeight += cc.getWeight();
		}
		
		int cptWeight = totalWeight;
		int cpt = this.orderedComponenets.size();
		for(Component comp : this.orderedComponenets) {
			ChartConstraints cc = this.getConstraints(comp);
			
			Rectangle r = new Rectangle();
			
			int size = (int) (Math.min(dimension.width, dimension.height) * ( (cptWeight / (double) totalWeight)));
			
			r.setSize(size, size);
			
			r.setLocation((int) (dimension.getWidth() / 2 - size / 2), (int) (dimension.getHeight() / 2 - size / 2));
			
			comp.setBounds(r);
			parent.setComponentZOrder(comp, --cpt);
			cptWeight -= cc.getWeight();
		}
	}
}
