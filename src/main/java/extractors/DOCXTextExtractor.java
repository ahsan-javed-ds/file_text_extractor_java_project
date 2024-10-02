package extractors;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Extract the text from DOCX file.
 *
 * @author Ahsan Javed
 * GitHub: <a href="https://github.com/ahsan-javed-ds/file_text_extractor_java_project</a>
 */

public class DOCXTextExtractor {
    public static String extractTextFromDOCX(String filePath) throws IOException {
        XWPFDocument doc = new XWPFDocument(new FileInputStream(filePath));
        StringBuilder text = new StringBuilder();
        doc.getParagraphs().forEach(paragraph -> text.append(paragraph.getText()).append("\n"));
        doc.close();
        return text.toString();
    }
}
