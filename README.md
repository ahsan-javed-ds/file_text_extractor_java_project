# Text Extractor Project in Java
This project is a Text Extractor application built in Java that extracts text content from various file types such as **PDF**, **DOC**, **DOCX**, **XLS**, **XLSX**, and **CSV**, and stores the extracted content in a ```.txt``` file in a designated output folder. The project uses several libraries like **Apache PDFBox**, **Apache POI**, and **Apache Tika** for handling different file formats.

## Prerequisites
Before running this project, ensure you have the following installed:

### Java Development Kit (JDK) 17.0.12
Download from: https://www.oracle.com/java/technologies/downloads/

**Important note**: Please add the ```C:/Program Files/Java/jdk-17/bin``` **path** into your system variable (Environmental Variables) and create a new System Variable as ```JAVA_HOME``` with this path ```C:/Program Files/Java/jdk-17```

### Apache Maven 3.9.9
Maven is required to build and manage project dependencies.
Download from: https://maven.apache.org/download.cgi

**Important note**: Please add the ```C:\Program Files\Apache\apache-maven-3.9.9\bin``` **path** into your 'System Variable' (Environmental Variables) and create a new 'System Variable' as ```MAVEN_HOME```  with this path ```C:\Program Files\Apache\apache-maven-3.9.9```

### To ensure the downloading of Java and Maven:

Run the following command in the project terminal to ensure that you have successfully installed the Java and maven:
```mvn -v```

The output will show something like this if you're using Windows:

> Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Program Files\Apache\apache-maven-3.9.9
Java version: 17.0.12, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"


### Cloning Text Extractor Java Project
Clone the repository from GitHub after creating the necessary folders for input and output files.

```git clone https://github.com/your-repo/Text_Extractor_Java.git```

### IDE (Optional but recommended)
It's recommended to use an IDE such as ```IntelliJ IDEA``` to easily manage and run the project.

### Project Dependencies
The project relies on the following ```Maven dependencies```:

1. Apache PDFBox (for PDF text extraction)
2. Apache POI (for DOC, DOCX, XLS, XLSX text extraction)
3. Apache Tika (for text extraction support across a variety of file formats)
4. Log4j (for logging)

The ```pom.xml``` file includes all the required dependencies. To install them, run the following command in the project root folder:

```mvn clean install```

### Project Structure
The project is structured as follows:

```Main.java```: Entry point of the application.

```Extractors```: Contains extractor classes for different file types (PDF, DOCX, DOC, XLSX, XLS, CSV).

```Input Folder```: files_input - The directory where files to be processed are placed.

```Output Folder```: files_output - The directory where the extracted ```.txt``` files are saved.

## How to Run the Project

### Configure Folders:
Create two folders in your project directory:

```files_input```: Place your input files (PDF, DOCX, DOC, XLSX, XLS, CSV) here.
```files_output```: This folder will store the extracted `.txt` files.

```Program Arguments```:
Pass the following arguments when running the program:

input_folder: Path to the files_input folder.
output_folder: Path to the files_output folder.

```java -jar TextExtractor.jar /path/to/files_input /path/to/files_output```

**OR**

*How to add these Program Arguments directly in IntelliJ*?

>Open ```Edit Configuration...``` button and add the paths of input and output in ```CLI Arguments to your application``` in the following way:
>```C:\Users\Text_Extracter_Java\file_inputs C:\Users\Text_Extracter_Java\file_outputs```

_Make sure you added the paths correctly as per the folder where you cloned the repository._

### Running the Program:
Run the application, and it will read files from `files_input`, process them based on the file type, extract the text content, and write the output in the `files_output` folder.

### Supported File Types
The following file formats are supported for text extraction:

1. `.pdf` - Extracts content from PDF files using Apache PDFBox.
2. `.docx` - Extracts content from Microsoft Word DOCX files using Apache POI.
3. `.doc` - Extracts content from Microsoft Word DOC files using Apache POI HWPF.
4. `.xlsx` - Extracts content from Microsoft Excel XLSX files using Apache POI.
5. `.xls` - Extracts content from older Excel XLS files using Apache POI.
6. `.csv` - Extracts content from CSV files.


### Logging
The project uses `Log4j` for logging purposes. Ensure the `log4j-core` and `log4j-api` dependencies are correctly included in your pom.xml file to avoid errors related to logging.

### Future Enhancements

Support for additional file formats such as `RTF`, `ODT`, `JSON`, `XML`, `HTML`, and other file formats will be added soon.
Implementation of `multi-threading` for processing multiple files simultaneously.
