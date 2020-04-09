package LifeGame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphAccounts extends ApplicationFrame {

    private static DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

    public GraphAccounts( String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Year","Account Value",
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    public static void addInvestmentValue(int year, float value){
        dataset.addValue( value , "Investment" , Integer.toString(year) );
    }

    public static void addSavingsValue(int year, float value){
        dataset.addValue( value , "Savings" , Integer.toString(year)  );
    }

    public static void displayGraph(){
        GraphAccounts chart = new GraphAccounts(
                "Account Value vs Year" ,
                "Account Value vs Year");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
