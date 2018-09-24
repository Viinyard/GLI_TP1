package pro.vinyard;

import pro.vinyard.camember.Budget;
import pro.vinyard.camember.BudgetControler;
import pro.vinyard.camember.BudgetModel;
import pro.vinyard.chart.pie.PieChartComponent;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    public static void main( String[] args ) {
        new App();
    }
    
    public App() {
        this.setTitle("GLI TP1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(500, 500));
	
			BudgetControler ctrl = new BudgetControler();
    
        
        this.add(ctrl);
        
        
        ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("Café", new BigDecimal("71.2"), "Je suis un programmeur",new Color(0x6f4e37)));
			ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("Loyer", new BigDecimal("351.50"), "Pour 17m2 ...", new Color(0x854442)));
			ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("Transport", new BigDecimal("32.20"), null, new Color(0xae5a41)));
			ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("Electricité", new BigDecimal("63.12"), "J'suis programmeur ...", new Color(0xbfb5b2)));
			ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("Condoms", new BigDecimal("2"), "J'suis programmeur :'( ...", new Color(0xd11141)));
			ctrl.addBudget(BudgetControler.ChartCategory.DEPENSES, new Budget("f37735", new BigDecimal("101.21"), "Vive les tickets restau !", new Color(0xf37735)));
   
			
			ctrl.addBudget(BudgetControler.ChartCategory.BENEFITS, new Budget("Remboursement transport", new BigDecimal("16.10"), "Merci capge", new Color(0x00aedb)));
			ctrl.addBudget(BudgetControler.ChartCategory.BENEFITS, new Budget("Bourses", new BigDecimal("450.5"), "Merci le crous", new Color(0xa200ff)));
			ctrl.addBudget(BudgetControler.ChartCategory.BENEFITS, new Budget("APL", new BigDecimal("222.30"), null, new Color(0xef4f91)));
			ctrl.addBudget(BudgetControler.ChartCategory.BENEFITS, new Budget("Salaire", new BigDecimal("1600"), "Merci capge", new Color(0xc79dd7)));
			ctrl.addBudget(BudgetControler.ChartCategory.BENEFITS, new Budget("Ticket restaurant", new BigDecimal("183.60"), "Merci capge", new Color(0x363b74)));
			
        this.setVisible(true);
        
    }
}
