package pro.vinyard.camember;

import pro.vinyard.chart.pie.model.PieChartModel;
import pro.vinyard.chart.pie.model.adapter.PieChartModelEvent;
import pro.vinyard.chart.pie.model.adapter.PieChartModelListener;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * @author VinYarD
 * created : 21/09/2018, 08:53
 */


public class BudgetModel implements PieChartModel, TableModel {

	private EventListenerList listeners = new EventListenerList();
	
	private List<Budget> listBudget;
	
	public static final String[] COLUMNS = new String[] {
			"Couleur",
			"Label",
			"Montant",
			"Description"
		};
	
	public BudgetModel() {
		this.listBudget = new ArrayList<>();
	}
	
	public void removeBudget(int index) {
		this.listBudget.remove(index);
		
		this.fireBudgetDeleted(index);
	}
	
	public void update(int index) {
		this.fireBudgetUpdated(index);
	}
	
	public void update(Budget budget) {
		this.fireBudgetUpdated(this.listBudget.indexOf(budget));
	}
	
	public void addBudget(Budget budget) {
		this.listBudget.add(budget);
		
		this.fireBudgetInserted(this.listBudget.size() - 1);
	}
	
	public void fireBudgetUpdated(int index) {
		for(TableModelListener listener : this.listeners.getListeners(TableModelListener.class)) {
			listener.tableChanged(new TableModelEvent(this, index, index, TableModelEvent.ALL_COLUMNS, TableModelEvent.UPDATE));
		}
		
		for(PieChartModelListener listener : this.listeners.getListeners(PieChartModelListener.class)) {
			listener.pieChartChanged(new PieChartModelEvent(this, index, PieChartModelEvent.UPDATE));
		}
	}
	
	public void fireBudgetDeleted(int index) {
		for(TableModelListener listener : this.listeners.getListeners(TableModelListener.class)) {
			listener.tableChanged(new TableModelEvent(this, index, index, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE));
		}
		
		for(PieChartModelListener listener : this.listeners.getListeners(PieChartModelListener.class)) {
			listener.pieChartChanged(new PieChartModelEvent(this, index, PieChartModelEvent.DELETE));
		}
	}
	
	public void fireBudgetInserted(int index) {
		for(TableModelListener listener : this.listeners.getListeners(TableModelListener.class)) {
			listener.tableChanged(new TableModelEvent(this, index, index, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
		}
		
		for(PieChartModelListener listener : this.listeners.getListeners(PieChartModelListener.class)) {
			listener.pieChartChanged(new PieChartModelEvent(this, index, PieChartModelEvent.INSERT));
		}
	}
	
	@Override
	public Color getColorAt(int index) {
		return this.listBudget.get(index).getColor();
	}
	
	@Override
	public BigDecimal getValueAt(int index) {
		return this.listBudget.get(index).getCount();
	}
	
	@Override
	public BigDecimal getTotal() {
		return this.listBudget.stream().map(b -> b.getCount()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Override
	public String getLabelAt(int index) {
		return this.listBudget.get(index).getLabel();
	}
	
	@Override
	public int getSliceCount() {
		return this.listBudget.size();
	}
	
	@Override
	public void addPieChartModelListener(PieChartModelListener l) {
		this.listeners.add(PieChartModelListener.class, l);
	}
	
	@Override
	public void removePieChartModelListener(PieChartModelListener l) {
		this.listeners.remove(PieChartModelListener.class, l);
	}
	
	@Override
	public int getRowCount() {
		return this.listBudget.size();
	}
	
	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return COLUMNS[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0 :
				return Color.class;
			case 1 :
				return String.class;
			case 2 :
				return BigDecimal.class;
			case 3 :
				return String.class;
			default:
				return Object.class;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Budget b = this.listBudget.get(rowIndex);
		switch (columnIndex) {
			case 0 :
				return b.getColor();
			case 1 :
				return b.getLabel();
			case 2 :
				return b.getCount();
			case 3 :
				return b.getDescription();
				default:
					return null;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Budget b = this.listBudget.get(rowIndex);
		switch (columnIndex) {
			case 0 :
				b.setColor((Color) aValue);
				break;
			case 1 :
				b.setLabel((String) aValue);
				break;
			case 2 :
				b.setCount((BigDecimal) aValue);
				break;
			case 3 :
				b.setDescription((String ) aValue);
				break;
		}
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		this.listeners.add(TableModelListener.class, l);
	}
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		this.listeners.remove(TableModelListener.class, l);
	}
}
