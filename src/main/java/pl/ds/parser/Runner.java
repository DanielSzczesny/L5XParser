package pl.ds.parser;

import pl.ds.pojo.RSLogix5000Content;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws JAXBException, IOException {

        String fileName = prepareInputFile();
        File readFile = new File(fileName);
        String outputPath = "C:\\L5K\\Reports\\";
        List<String> conditions = prepareConditionList();

        JAXBContext context = JAXBContext.newInstance(RSLogix5000Content.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        if (readFile.isFile() && readFile.canRead()) {
            RSLogix5000Content rsLogix5000Content = (RSLogix5000Content) unmarshaller
                    .unmarshal(readFile);
            Tester.saveResultToTxTFile(Tester.getMapOfErrors(conditions, rsLogix5000Content), outputPath);
        } else System.out.println("File not exist" + readFile.getAbsolutePath());
    }

    private static List<String> prepareConditionList() {
        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter parameters which have to be checked one by one. Insert exit to stop");

        while (true) {
            String tempString = scanner.next().trim();
            if (tempString.isEmpty() || tempString.equals("exit")) return result;
            else {
                result.add(tempString);
                System.out.println(result.size());
            }
        }
    }

    private static String prepareInputFile() {
        String filePath;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter .L5X file name absolute path");
        filePath = scanner.next().trim();

        if (filePath.contains(".L5X")) return filePath;
        else return prepareInputFile();
    }
}
