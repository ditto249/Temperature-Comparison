# July Temperatures Visualizer (Java Coursework)
This project is a Java Swing application that reads hourly temperature data for two locations (Downing Street and East 15) during the month of July and visualizes them on a graph.
It was developed as part of a university coursework exercise.

## Project Structure
TemperatureReading.java
- Represents a single temperature reading.
- Stores day, hour, and temperatures for Downing Street and East 15.
- Provides utility methods for min/max temperature calculations.
- Includes a static readFromFile() method to load data from a CSV file.

## TemperaturePlot.java
- Custom Swing component (JComponent) that draws the temperature graph.
- Plots two line graphs (one for each location) against time.
- Adds labeled axes, tick marks, and a legend.
- Uses a fixed y-axis range (12°C – 30°C) for clarity.

## JulyTemperatures.java
- Main entry point of the application.
- Loads the dataset (temperatures-July.csv).
- Creates a Swing window (JFrame) and displays the TemperaturePlot.

## temperatures-July.csv
- The dataset used for visualization.
- Contains two comma-separated columns:
- temperature_at_DowningStreet(Kelvin),temperature_at_East15(Kelvin)

## How It Works
### Data Loading
- The program reads from temperatures-July.csv.
- Temperatures (given in Kelvin) are converted to Celsius.
- Each line corresponds to one hour of temperature data.
- After 24 readings, the program increments the day counter.

### Graph Rendering
- X-axis = Days of July
- Y-axis = Temperature in °C
- Blue line = East 15
- Red line = Downing Street
- Each data point is drawn and connected with lines.
- A legend is shown in the top-right corner.

### Scaling & Layout
- Graph automatically adjusts to window size.
- X-axis labels show day numbers (1–31).
- Y-axis labels show temperature values (12°C to 30°C).

## Running the Application
### Requirements
- Java 8+
- IDE (IntelliJ IDEA, Eclipse, NetBeans) or command-line compilation

### Steps
- Clone or download the project files.
- Ensure temperatures-July.csv is placed in the resources folder (so it can be loaded with getResourceAsStream).
- Compile the project:
javac *.java
- Run the program:
java JulyTemperatures
- A graph window will open displaying July temperature trends.

## Example Visualization
- Red Line → Downing Street temperatures
- Blue Line → East 15 temperatures
- X-axis → Days of July
- Y-axis → Temperatures in °C (12°C – 30°C range)

## Features
- Reads hourly temperature data from CSV
- Converts Kelvin → Celsius
- Visualizes daily temperature trends
- Uses custom graph plotting with axes, labels, and legends
- Object-oriented design (Reading, Plot, Main App)

## License

This project was created as a university coursework exercise.
Feel free to use it for learning and experimentation.
