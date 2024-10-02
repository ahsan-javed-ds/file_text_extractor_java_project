package extractors;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Extract the text from DOC file.
 *
 * @author Ahsan Javed
 * GitHub: <a href="https://github.com/ahsan-javed-ds/file_text_extractor_java_project</a>
 */

public class DOCTextExtractor {
    public static String extractTextFromDOC(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        HWPFDocument doc = new HWPFDocument(fis);
        WordExtractor extractor = new WordExtractor(doc);
        String text = extractor.getText();
        doc.close();
        return text;
    }
}
