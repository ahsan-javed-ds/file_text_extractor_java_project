package extractors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Extract the text from PDF file.
 *
 * @author Ahsan Javed
 * GitHub: https://github.com/ahsan-javed-ds/file_text_extractor_java_project
 */


public class PDFTextExtractor {
    public static String extractTextFromPDF(String filePath) throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }
}
