import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "people.csv"; // Ensure this file exists in the project directory

        try {
            double averageAge = CSVStreamProcessor.calculateAverageAge(filePath);
            System.out.println("Average Age: " + String.format("%.2f", averageAge));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
