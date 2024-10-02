import extractors.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Extract the text from multiple files including PDF, DOCX, DOC, XLSX, XLS, CSV.
 * Currently supporting the above-mentioned six file formats.
 * In the future, new file formats will also be supported.
 *
 * @author Ahsan Javed
 * GitHub: https://github.com/ahsan-javed-ds/file_text_extractor_java_project
 */

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide input and output folder paths as Program Arguments in 'Edit Configuration'.");       // Like this: C:\Users\XYZ\Desktop\Text_Extracter_Java\file_inputs C:\Users\XYZ\Desktop\Text_Extracter_Java\file_outputs
            System.out.println("Usage: java Main <input_folder> <output_folder>");
            return;
        }

        String inputFolder = args[0];
        String outputFolder = args[1];

        File inputDir = new File(inputFolder);
        File outputDir = new File(outputFolder);

        // Check: Output Directory existence, if it doesn't exist, will create a one for you
        if (!outputDir.exists()) {
            if (outputDir.mkdir()) {
                System.out.println("Output directory created successfully.");
            } else {
                System.err.println("Failed to create output directory. Please check permissions or provide a valid path.");
                return; // Exit the program if the directory couldn't be created
            }
        }

        long startTime = System.currentTimeMillis();

        // Check: Input folder existence as a Directory, if it doesn't exist, will create a one for you
        if (inputDir.exists() && inputDir.isDirectory()) {
            File[] files = inputDir.listFiles();

            // It will process all the files with supported formats in the input folder: file_inputs
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            long fileStartTime = System.currentTimeMillis();

                            processFile(file, outputFolder);
                            long fileEndTime = System.currentTimeMillis(); // End time for a single file
                            long fileDuration = fileEndTime - fileStartTime;

                            System.out.println("Time taken to process " + file.getName() + ": " + fileDuration + " ms.");

                        } catch (IOException e) {
                            System.err.println("Error processing file " + file.getName() + ": " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            System.out.println("Input folder does not exist or is not a directory.");
        }
        // End time measurement for the entire process
        long endTime = System.currentTimeMillis();
        long totalDuration = endTime - startTime;

        // Output total time taken for processing all files
        System.out.println("Total time taken for processing all files: " + totalDuration + " ms.");
    }

    /**
     * Process the file by extracting text and writing to the output folder.
     * @param inputFile The file(s) to process.
     * @param outputFolder The folder where the converted file will be saved.
     * @throws IOException if an error occurs during reading or writing.
     */
    private static void processFile(File inputFile, String outputFolder) throws IOException {
        String filePath = inputFile.getPath();
        String fileType = getFileExtension(filePath);
        String extractedText;

        // Cases: Extraction of the text as per the given file-formats.
        switch (fileType) {
            case "pdf":
                extractedText = PDFTextExtractor.extractTextFromPDF(filePath);
                break;
            case "docx":
                extractedText = DOCXTextExtractor.extractTextFromDOCX(filePath);
                break;
            case "doc":
                extractedText = DOCTextExtractor.extractTextFromDOC(filePath);
                break;
            case "xlsx":
                extractedText = XLSXTextExtractor.extractTextFromXLSX(filePath);
                break;
            case "xls":
                extractedText = XLSTextExtractor.extractTextFromXLS(filePath);
                break;
            case "csv":
                extractedText = CSVTextExtractor.extractTextFromCSV(filePath);
                break;
            default:
                System.out.println("Regretfully, we're not supporting this file-format at this moment, a future support will be added soon...: " + filePath);
                return;
        }

        // Output: Writing the Converted Text in the .txt file created in the 'file_outputs' folder
        writeTextToFile(inputFile, extractedText, outputFolder);
    }

    /**
     * Extracts the file extension from a file path.
     * @param filePath The full path of the file.
     * @return The file extension (e.g., "pdf", "docx").
     */
    private static String getFileExtension(String filePath) {
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            return filePath.substring(i + 1).toLowerCase();
        }
        return "";
    }

    /**
     * Writes the extracted text to a .txt file in the output folder.
     * @param inputFile The original file that was processed.
     * @param extractedText The text that was extracted from the original file.
     * @param outputFolder The folder where the converted file will be saved.
     * @throws IOException if an error occurs during writing.
     */
    private static void writeTextToFile(File inputFile, String extractedText, String outputFolder) throws IOException {
        // Extension-less filename: Getting the base name of the file (without extension)
        String baseName = getFileBaseName(inputFile.getName());

        // Converted File: Creating the new file name by appending "-converted.txt"
        String newFileName = outputFolder + "/" + baseName + "-converted.txt";

        // New File Writer: Writing the extracted text to the new file in the output folder: file_outputs
        FileWriter fileWriter = new FileWriter(newFileName);
        fileWriter.write(extractedText);
        fileWriter.close();

        System.out.println("Converted .txt file saved here: " + newFileName);
    }

    /**
     * Extracts the base name of the file (without extension).
     * @param fileName The full name of the file.
     * @return The base name of the file (e.g., "file" for "file.pdf").
     */
    private static String getFileBaseName(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
}


// ----------------------------------------- End of Main.java file ----------------------------------------------------------- //