package extractors;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Extract the text from DOCX file.
 *
 * @author Ahsan Javed
 * GitHub: <a href="https://github.com/ahsan-javed-ds/file_text_extractor_java_project</a>
 */

public class DOCXTextExtractor {
    public static String extractTextFromDOCX(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(path))) {
            // Code to extract text from the DOCX file
            StringBuilder extractedText = new StringBuilder();
            doc.getParagraphs().forEach(paragraph -> extractedText.append(paragraph.getText()).append("\n"));
            return extractedText.toString();
        }
    }
}
