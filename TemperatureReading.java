import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class TemperatureReading {
    final int dayOfReading;
    final int hourOfReading;
    final double tempOfDowningStreet;
    final double tempOfEast15;

    // Constructor to initialise temperature readings
    TemperatureReading(int dayOfReading, int hourOfReading, double tempOfDowningStreet, double tempOfEast15) {
        this.dayOfReading = dayOfReading;
        this.hourOfReading = hourOfReading;
        this.tempOfDowningStreet = tempOfDowningStreet;
        this.tempOfEast15 = tempOfEast15;
    }

    //method to get the minimum temperature from a list of readings
    public static double getMinTemperature(List<TemperatureReading> readings) {
        double minTemp = Double.MAX_VALUE;
        for (TemperatureReading reading : readings) {
            minTemp = Math.min(minTemp, Math.min(reading.tempOfDowningStreet, reading.tempOfEast15));
        }
        return minTemp;
    }

    //method to get the maximum temperature from a list of readings
    public static double getMaxTemperature(List<TemperatureReading> readings) {
        double maxTemp = Double.MIN_VALUE;
        for (TemperatureReading reading : readings) {
            maxTemp = Math.max(maxTemp, Math.min(reading.tempOfDowningStreet, reading.tempOfEast15));
        }
        return maxTemp;
    }

    // Static method to read temperature readings from a file and return a list of TemperatureReading objects
    public static List<TemperatureReading> readFromFile(String filename) {
        List<TemperatureReading> readings = new ArrayList<>();
        int startDay = 0;
        int startHour = 0;
        int dayOfReading = startDay;
        int hourOfReading = startHour;
        try (InputStream inputStream = TemperatureReading.class.getResourceAsStream(filename);
             Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // splits the data at ","
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    double tempOfDowningStreet = Double.parseDouble(parts[0]);
                    double tempOfEast15 = Double.parseDouble(parts[1]);
                    readings.add(new TemperatureReading(dayOfReading,hourOfReading,(tempOfDowningStreet - 273.15), (tempOfEast15 - 273.15)));
                    hourOfReading++;
                    if (hourOfReading == 24){
                        hourOfReading = 0;
                        dayOfReading++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return readings;
    }
}
