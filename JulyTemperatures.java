import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JulyTemperatures {
    public static void main(String[] args) {
        // open scanner to read
        Scanner scanner = new Scanner(System.in);
        // reades the data into a list
        List<TemperatureReading> readings = TemperatureReading.readFromFile("temperatures-July.csv");
        JFrame frame = new JFrame("Temperature Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TemperaturePlot temperature = new TemperaturePlot(readings);
        frame.add(temperature);
        //sets the size
        frame.setSize(800, 600);
        frame.setVisible(true);
        // closes scanner
        scanner.close();
    }
}
