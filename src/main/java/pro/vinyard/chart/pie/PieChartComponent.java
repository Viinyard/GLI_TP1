package pro.vinyard.chart.pie;

import pro.vinyard.chart.pie.Layout.PieChartLayout;
import pro.vinyard.chart.pie.model.*;
import pro.vinyard.chart.pie.model.adapter.PieChartModelEvent;
import pro.vinyard.chart.pie.model.adapter.PieChartModelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VinYarD
 * created : 22/09/2018, 14:31
 */


public class PieChartComponent extends JComponent implements PieChartModelListener {
	
	private List<SliceComponent> listSlice;
	
	public PieChartComponent() {
		this.listSlice = new ArrayList<>();
		this.setOpaque(false);
		this.setLayout(new PieChartLayout());
	}
	
	private void addSlice(SliceComponent slice, int index) {
		this.listSlice.add(index, slice);
		this.add(slice);
	}
	
	private SliceComponent getSlice(int index) {
		return this.listSlice.get(index);
	}
	
	private void removeSlice(int index) {
		this.remove(this.listSlice.remove(index));
	}
	
	@Override
	public boolean isLightweight() {
		return true;
	}
	
	@Override
	public void pieChartChanged(PieChartModelEvent event) {
		PieChartModel model = (PieChartModel) event.getSource();
		
		switch (event.getType()) {
			case PieChartModelEvent.INSERT:
				if(PieChartModelEvent.ALL == event.getSlice()) {
					for(int i = 0; i < model.getSliceCount(); i++) {
						SliceComponent slice = new SliceComponent();
						slice.setColor(model.getColorAt(i));
						this.addSlice(slice, event.getSlice());
					}
				} else {
					SliceComponent slice = new SliceComponent();
					slice.setColor(model.getColorAt(event.getSlice()));
					this.addSlice(slice, event.getSlice());
				}
				break;
			case PieChartModelEvent.DELETE:
				if(PieChartModelEvent.ALL == event.getSlice()) {
					for (int i = 0; i < model.getSliceCount(); i++) {
						this.removeSlice(i);
					}
				} else {
					this.removeSlice(event.getSlice());
				}
				break;
			case PieChartModelEvent.UPDATE:
				if(PieChartModelEvent.ALL == event.getSlice()) {
					BigDecimal start = BigDecimal.ZERO;
					for(int i = 0; i < model.getSliceCount(); i++) {
						start = start.add(model.getValueAt(i).divide(model.getTotal(), 2, RoundingMode.HALF_UP));
						this.getSlice(i).setColor(model.getColorAt(i));
					}
				} else {
					this.getSlice(event.getSlice()).setColor(model.getColorAt(event.getSlice()));
				}
				break;
		}
		
		double start = 0;
		for(int i = 0; i < model.getSliceCount(); i++) {
			this.getSlice(i).setStart(start);
			try {
				this.getSlice(i).setPercent(model.getValueAt(i).divide(model.getTotal(), 15, RoundingMode.HALF_UP).multiply(new BigDecimal(360)).doubleValue());
			} catch (ArithmeticException e) {
				this.getSlice(i).setPercent(0);
			}
			start += this.getSlice(i).getExtent();
		}
		
		this.repaint();
	}
	
	
	@Override
	public boolean contains(int x, int y) {
		for(Component comp : this.getComponents()) {
			if(comp.contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "[" + this.getBounds() + "]";
	}
	
	public int getSliceAt(Point p) {
		return this.getSliceAt(p.x,  p.y);
	}
	
	public int getSliceAt(int x, int y) {
		return this.listSlice.indexOf(this.getComponentAt(x, y));
	}
	
}
