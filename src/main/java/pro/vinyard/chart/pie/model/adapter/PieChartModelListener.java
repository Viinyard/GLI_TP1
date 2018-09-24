package pro.vinyard.chart.pie.model.adapter;

import java.util.EventListener;

public interface PieChartModelListener extends EventListener {
	
	void pieChartChanged(PieChartModelEvent event);
	
}
