package extractors;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Extract the text from XLSX file.
 *
 * @author Ahsan Javed
 * GitHub: https://github.com/ahsan-javed-ds/file_text_extractor_java_project
 */

public class XLSXTextExtractor {
    public static String extractTextFromXLSX(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        StringBuilder data = new StringBuilder();

        for (Sheet sheet : workbook) {
            for (Row row : sheet) {
                for (Cell cell : row) {
                    data.append(cell.toString()).append("\t");
                }
                data.append("\n");
            }
        }
        workbook.close();
        return data.toString();
    }
}
