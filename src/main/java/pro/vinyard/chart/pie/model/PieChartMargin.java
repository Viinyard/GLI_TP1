package pro.vinyard.chart.pie.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

/**
 * @author VinYarD
 * created : 23/09/2018, 02:32
 */


public class PieChartMargin extends JComponent implements MouseListener {
	
	private Shape shape;
	
	public PieChartMargin() {
		this.addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(this.getBackground());
		
		this.shape = new Ellipse2D.Double(0,
				0,
				this.getSize().getWidth(),
				this.getSize().getHeight());
		
		g2.fill(this.shape);
	}
	
	@Override
	public boolean isLightweight() {
		return true;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.shape.contains(x, y);
	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed
	 * and released) on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	/**
	 * Invoked when a mouse button has been pressed on a component.
	 *
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	
	/**
	 * Invoked when a mouse button has been released on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	/**
	 * Invoked when the mouse enters a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	
	/**
	 * Invoked when the mouse exits a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	
	}
}
