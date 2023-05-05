//ayudas
//https://picodotdev.github.io/blog-bitix/2017/10/visualizar-datos-y-generar-graficas-en-java-con-jfreechart/
//https://www.youtube.com/watch?v=4Q9J06wPm-c
//
//
//
//
//
//
//
//
//
//sin terminar aun, no toma datos de un cvd

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.GradientPaint;
import javax.swing.JFrame;

public class BarChart extends JFrame {

    JFreeChart chart;//objeto para crear la grafica

    public BarChart() {
        //construimos el JFrame
        super("Grafica");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        crearGrafico();//cargar los datos y crear la grafica

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);//ubicamos el panel de la grafica
        add(panel);

        setVisible(true);
    }

    private void crearGrafico() {
        //crear un conjunto de datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(2, "Producto 1", "Raul");
        dataset.setValue(7, "Producto 1", "Ana");
        dataset.setValue(4, "Producto 1", "Luis");
        dataset.setValue(9, "Producto 1", "Pepe");
        dataset.setValue(6, "Producto 1", "Carlos");

        //crear el grafico de barra
        chart = ChartFactory.createBarChart(
                "Grafica", //Nombre de la grafica
                "Vendedor", //Nombre del eje Horizontal
                "Cantidad vendida", //Nombre del eje vertical
                dataset, //Data
                PlotOrientation.VERTICAL, //Orientacion HORIZONTAL o VERTICAL
                true, //Incluir leyenda
                true, //Informacion al pasar el mouse
                true);                      //URls

        //de aqui para abajo es pintura
        chart.setBackgroundPaint(Color.PINK);//Dar color al fondo del panel
        chart.getTitle().setPaint(Color.RED);//Dar color al titulo 

        //CategoryPlot plot =(CategoryPlot) chart.getPlot();	    	    	    
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);//Color del fondo del gr�fico

        plot.setDomainGridlinesVisible(true);//Lineas divisorias
        plot.setRangeGridlinePaint(Color.BLACK);//Color de lineas divisorias	    

        //Calculo de los valores en el eje x
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);//Asignar color de linea a las barras

        //Dar color a las barras
        GradientPaint gp = new GradientPaint(0.0f, 0.0f, Color.yellow, 0.0f, 0.0f, new Color(0, 64, 0));
        renderer.setSeriesPaint(0, gp);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
    }

    public static void main(String args[]) {
        BarChart demo = new BarChart();
    }
}
