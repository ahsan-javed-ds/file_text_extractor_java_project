package extractors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Extract the text from XLS file.
 *
 * @author Ahsan Javed
 * GitHub: https://github.com/ahsan-javed-ds/file_text_extractor_java_project
 */

public class XLSTextExtractor {
    public static String extractTextFromXLS(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(fis);
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
