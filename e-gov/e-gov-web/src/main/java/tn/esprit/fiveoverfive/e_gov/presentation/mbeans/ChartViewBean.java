package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean

public class ChartViewBean implements Serializable{


 
    
    private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
        
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Bar Charts");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        Axis yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(5500);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries Inscriptions = new ChartSeries();
        Inscriptions.setLabel("Inscriptions");
        Inscriptions.set("Esprit", 5000);
        Inscriptions.set("ENSIT", 1600);
        Inscriptions.set("ULT", 1000);
        Inscriptions.set("Time", 500);
        Inscriptions.set("Sesame", 200);
 
        model.addSeries(Inscriptions);
        return model;
    }
     
    
    
}