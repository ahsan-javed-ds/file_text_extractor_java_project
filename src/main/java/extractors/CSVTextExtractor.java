package extractors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Extract the text from CSV file.
 *
 * @author Ahsan Javed
 * GitHub: https://github.com/ahsan-javed-ds/file_text_extractor_java_project
 */

public class CSVTextExtractor {
    public static String extractTextFromCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder data = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            data.append(line).append("\n");
        }
        br.close();
        return data.toString();
    }
}
