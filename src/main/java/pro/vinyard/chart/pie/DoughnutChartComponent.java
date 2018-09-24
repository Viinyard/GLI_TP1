package pro.vinyard.chart.pie;

import pro.vinyard.chart.pie.Layout.DoughnutChartLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author VinYarD
 * created : 23/09/2018, 16:05
 */


public class DoughnutChartComponent extends JComponent {
	
	private DoughnutChartLayout layout;
	
	public DoughnutChartComponent() {
		this.layout = new DoughnutChartLayout();
		this.setLayout(this.layout);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		
	}
	
	@Override
	public void add(Component comp, Object constraints) {
		super.add(comp, constraints);
	}
	
	@Override
	public void add(Component comp, Object constraints, int index) {
		super.add(comp, constraints, index);
	}
}
