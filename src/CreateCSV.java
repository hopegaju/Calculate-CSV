import java.io.FileWriter;
import java.io.IOException;

public class CreateCSV {
    public static void main(String[] args) {
        String filePath = "people.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Name,Age\n");
            writer.append("Alice,30\n");
            writer.append("Bob,25\n");
            writer.append("Charlie,40\n");
            writer.append("David,35\n");
            writer.append("Eve,28\n");
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating CSV: " + e.getMessage());
        }
    }
}

