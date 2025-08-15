import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TemperaturePlot extends JComponent {
    private List<TemperatureReading> temperatureReadings;
// constructor to initialise temperatureReadings
    public TemperaturePlot(List temperatureReadings) {
        this.temperatureReadings = temperatureReadings;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int padding = 50;
        int xAxisHeight = 20;
        int yAxisWidth = 50;
        double minTemp = 12;
        double maxTemp = 30;

        // Calculate temperature range and scale for plotting
        double tempRange = maxTemp - minTemp;
        double tempScale = (height - padding - xAxisHeight) / tempRange;
        // Calculate width of each temperature data point
        double tempDataWidth = (double) (width - yAxisWidth - padding) / temperatureReadings.size();
        // Draw horizontal axis (date)
        g.drawLine(yAxisWidth, height - padding, width - padding, height - padding);
        // Draw vertical axis (temperature)
        int yAxisStart = padding - 30;
        int yAxisEnd = height - padding;
        g.drawLine(yAxisWidth, yAxisStart, yAxisWidth, yAxisEnd);

        // Draw temperature data points and date labels
        for (int i = 0; i < temperatureReadings.size(); i++) {
            TemperatureReading reading = temperatureReadings.get(i);
            // Calculate x-coordinate for the data point
            int x = (int) (yAxisWidth + (i + 0.5) * tempDataWidth);
            // Calculate y-coordinate for Downing Street temperature
            int yDowning = (int) (height - padding - (reading.tempOfDowningStreet - minTemp) * tempScale);
            // Draw Downing Street temperature data point
            g.setColor(Color.BLUE);
            g.fillOval(x - 1, yDowning - 1, 2, 2);
            // Calculate y-coordinate for East 15 temperature
            int yEast15 = (int) (height - padding - (reading.tempOfEast15 - minTemp) * tempScale);
            // Draw East 15 temperature data point
            g.setColor(Color.RED);
            g.fillOval(x - 1, yEast15 - 1, 2, 2);

            // Draw lines connecting data points, except for the first one
            if (i > 0) {
                int xPrev = (int) (yAxisWidth + (i - 0.5) * tempDataWidth);
                int yDowningPrev = (int) (height - padding - (temperatureReadings.get(i - 1).tempOfDowningStreet - minTemp) * tempScale);
                int yEast15Prev = (int) (height - padding - (temperatureReadings.get(i - 1).tempOfEast15 - minTemp) * tempScale);
                // Draw Downing Street temperature line
                g.setColor(Color.RED);
                g.drawLine(xPrev, yDowningPrev, x, yDowning);
                // Draw East 15 temperature line
                g.setColor(Color.BLUE);
                g.drawLine(xPrev, yEast15Prev, x, yEast15);
            }
        }
        // Draw days at the bottom
        g.setColor(Color.BLACK);
        int daysCount = temperatureReadings.size() / 24; // To get readings per day
        int daysWidth = (width - yAxisWidth - padding) / daysCount;
        for (int i = 0; i < daysCount; i++) {
            int x = yAxisWidth + i * daysWidth + daysWidth / 2;
            g.drawString("" + (i + 1), x - 15, height - padding + 30);
        }
        // Draw numbers on the y-axis
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 18; i++) {
            double temp = minTemp + i * (maxTemp - minTemp) / 18;
            int y = (int) (height - padding - i * (height - padding - xAxisHeight) / 18);
            g.drawString(String.format("%.1f", temp), yAxisWidth - 40, y + 5);
            g.setColor(Color.RED);
            g.fillRect(width - 105, padding + 5, 10, 10);
            g.setColor(Color.BLUE);
            g.fillRect(width - 105, padding + 20, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString("East 15", width - 90, padding + 15);
            g.drawString("Downing Street", width - 90, padding + 30);
        }
    }
}
