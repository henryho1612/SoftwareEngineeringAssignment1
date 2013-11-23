package FileHandler;

import Utilities.DetectOS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author HenryHo
 */
public class ContentReader {
   
    public String getInput() {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String filePath = "";

        try {
            System.out.print("Enter file's name: ");
            fileName = bufferReader.readLine();

            if (DetectOS.isWindows()) {
                filePath = "src\\Files\\".concat(fileName);
            } else if (DetectOS.isMac()) {
                filePath = "src/Files/".concat(fileName);
            } else if (DetectOS.isUnix()) {
                filePath = "src/Files/".concat(fileName);
            } else {
                System.out.println("Your OS is not support!!");
            }
        } catch (IOException ioException) {
            System.out.println("Invalid Input");
        }

        return filePath;
    }

    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        
        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferReader.readLine()) != null)
            {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } catch (IOException exception) {
            System.out.println("File Not Found");
        }
        
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
    
}
