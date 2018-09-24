package pro.vinyard.camember;

import pro.vinyard.chart.pie.DoughnutChartComponent;
import pro.vinyard.chart.pie.Layout.ChartConstraints;
import pro.vinyard.chart.pie.PieChartComponent;
import pro.vinyard.chart.pie.model.PieChartMargin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

import static pro.vinyard.camember.BudgetControler.ChartCategory.BENEFITS;
import static pro.vinyard.camember.BudgetControler.ChartCategory.DEPENSES;

/**
 * @author VinYarD
 * created : 23/09/2018, 17:41
 */


public class BudgetControler extends JPanel {
	
	public enum ChartCategory {
		DEPENSES(new Budget("Depenses", BigDecimal.ZERO, null,  new Color(0xd11141))),
		BENEFITS(new Budget("Benefits", BigDecimal.ZERO, null,  new Color(0x00b159)));
		
		private Budget budget;
		
		ChartCategory(Budget budget) {
			this.budget = budget;
		}
		
		public Budget getBudget() {
			return budget;
		}
		
		public void setBudget(Budget budget) {
			this.budget = budget;
		}
	}
	
	private Map<ChartCategory, BudgetModel> categoryBudget;
	
	private BudgetModel total;
	
	public BudgetControler() {
		this.categoryBudget = new Hashtable<>();
		
		this.setLayout(new GridLayout(1, 2));
		
		DoughnutChartComponent doughnut = new DoughnutChartComponent();
		JPanel jpTables = new JPanel();
		jpTables.setLayout(new GridLayout(2, 1));
		
		for(ChartCategory category : ChartCategory.values()) {
			BudgetModel model = new BudgetModel();
			
			JTable table = new JTable();
			table.setModel(model);
			
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			jp.add(table.getTableHeader(), BorderLayout.NORTH);
			jp.add(table);
			jpTables.add(jp);
			
			PieChartComponent pieView = new PieChartComponent();
			model.addPieChartModelListener(pieView);
			
			pieView.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int slice = ((PieChartComponent) e.getSource()).getSliceAt(e.getPoint());
					System.out.println(model.getLabelAt(slice) + " : " + model.getValueAt(slice));
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					((PieChartComponent) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					((PieChartComponent) e.getSource()).setCursor(Cursor.getDefaultCursor());
				}
			});
			
			doughnut.add(pieView, new ChartConstraints(5));
			doughnut.add(new PieChartMargin(), new ChartConstraints(1));
			
			this.categoryBudget.put(category, model);
		}
		
		this.total = new BudgetModel();
		
		PieChartComponent pieView = new PieChartComponent();
		
		pieView.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int slice = ((PieChartComponent) e.getSource()).getSliceAt(e.getPoint());
				System.out.println(total.getLabelAt(slice) + " : " + total.getValueAt(slice));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				((PieChartComponent) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				((PieChartComponent) e.getSource()).setCursor(Cursor.getDefaultCursor());
			}
		});
		
		this.total.addPieChartModelListener(pieView);
		
		this.total.addBudget(BENEFITS.getBudget());
		this.total.addBudget(DEPENSES.getBudget());
		
		doughnut.add(pieView, new ChartConstraints(5));
		
		this.add(doughnut);
		
		this.add(jpTables);
		
	}
	
	public void addBudget(ChartCategory category, Budget budget) {
		this.categoryBudget.get(category).addBudget(budget);
		category.getBudget().setCount(this.categoryBudget.get(category).getTotal());
		this.total.update(category.getBudget());
	}
}
