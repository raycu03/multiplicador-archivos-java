import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) throws IOException {
        List<String> files = Arrays.asList("US000000.txt", "AF000000.txt", "AC000000.txt","CT000000.txt","AP000000.txt");
        for (String file: files ){
            String  sourcePath = "C:\\Users\\xxxx\\Desktop\\rips_test_jmiter\\"+file;   // source file path
            String destinationPath="C:\\Users\\xxxx\\Desktop\\rips_test_jmiter\\";  // destination file path

            File sourceFile = new File(sourcePath);        // Creating A Source File
            for (int i = 0 ; i<1000; i++){
                File destinationFile = new File(destinationPath+parse(file,i)+".txt");
                Files.copy(sourceFile.toPath(), destinationFile.toPath());
            }
        }
    }

    private static String parse(String fileName, Integer i){
        StringBuilder type = new StringBuilder(fileName.substring(0, 2));
        Integer canidad = i.toString().length();
        for (int x = canidad ; x<6; x++){
            type.append("0");
        }
        type.append(i);
        return type.toString();
    }
}
