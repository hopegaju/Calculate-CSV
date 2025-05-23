import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class CSVStreamProcessor {

    public static double calculateAverageAge(String csvFilePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(csvFilePath))) {
            OptionalDouble averageAge = lines
                    .skip(1) // Skip header row
                    .map(line -> line.split(",")) // Split CSV by comma
                    .filter(arr -> arr.length == 2) // Ensure correct format
                    .map(arr -> {
                        try {
                            return Integer.parseInt(arr[1]); // Convert age to Integer
                        } catch (NumberFormatException e) {
                            return null; // Handle invalid age format
                        }
                    })
                    .filter(age -> age != null) // Remove null values
                    .mapToInt(Integer::intValue) // Convert Stream<Integer> to IntStream
                    .average(); // Calculate average

            return averageAge.orElse(0.0); // Handle empty streams gracefully
        }
    }

    public static void main(String[] args) {
        String filePath = "people.csv"; // Adjust path if needed
        try {
            double averageAge = calculateAverageAge(filePath);
            System.out.println("Average Age: " + String.format("%.2f", averageAge));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
