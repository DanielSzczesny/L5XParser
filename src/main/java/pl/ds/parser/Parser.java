package pl.ds.parser;

import pl.ds.pojo.RSLogix5000Content;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {

    /**
     * Parse L5X, prepare list of L5X files and csv files
     * @param unmarshaller Unmarshaller instance to exact Java objects from XML (L5X)
     * @param mainDirPath Directory path of current execution of file
     * @param listOfL5XFiles List of .L5X files from directory
     * @param listOfCsvFile Lost of .csv files from directory
     * @throws JAXBException Unmarshaller exception
     * @throws IOException Files exception
     */
    public static void parseL5X(Unmarshaller unmarshaller, String mainDirPath,
                                File[] listOfL5XFiles, File[] listOfCsvFile) throws JAXBException, IOException {
        assert listOfL5XFiles != null;
        for (File file : listOfL5XFiles) {
            String fileName = file.getName().substring(0, file.getName().length() - 4);
            List<String> conditions = new ArrayList<>();
            assert listOfCsvFile != null;
            for (File csv : listOfCsvFile) {
                if (csv.getName().contains(fileName)) {
                    conditions = prepareConditionsFromFile(csv);
                    break;
                }
            }
            if (conditions.size() == 0) conditions = prepareConditionList(file.getName());
            if (file.canRead() && file.isFile()) {
                RSLogix5000Content rsLogix5000Content = (RSLogix5000Content) unmarshaller.unmarshal(file);
                Tester.saveReportAsTxtFile(Tester.getMapOfErrors(conditions, rsLogix5000Content),
                        mainDirPath, rsLogix5000Content.getController().getName());
            }
        }
    }

    /**
     * Read csv file and save result as list of conditions to check
     * @param csv csv File
     * @return List of conditions
     */
    public static List<String> prepareConditionsFromFile(File csv) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
            String[] conditions = reader.readLine().split(",");
            result.addAll(Arrays.asList(conditions));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Manually provide list of conditions to file from name parameter.
     *
     * One by one separated by next line (Enter). To jump out of method insert 'exit'
     * @param name name of L5X file for which conditions have to be check
     * @return List of conditions
     */
    public static List<String> prepareConditionList(String name) {
        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter parameters which have to be checked one by one for "
                + name + ". Insert exit to stop");

        while (true) {
            String tempString = scanner.next().trim();
            if (tempString.isEmpty() || tempString.equals("exit")) return result;
            else {
                result.add(tempString);
                System.out.println(result.size());
            }
        }
    }

    /**
     * Prepare list of .L5X files from mainDirPath
     * @param mainDirPath current directory of start program
     * @return list of File[]
     */
    public static File[] prepareInputL5XFiles(String mainDirPath) {
        File[] listOfL5X = new File(mainDirPath).listFiles((dir, name) -> name.endsWith(".L5X"));

        if (listOfL5X != null && listOfL5X.length > 0) return listOfL5X;

        return null;
    }

    /**
     * Prepare list of .csv files from mainDirPath
     * @param mainDirPath current directory of start program
     * @return list of File[]
     */
    public static File[] prepareInputCsvFiles(String mainDirPath) {
        File[] listOfCsv = new File(mainDirPath).listFiles((dir, name) -> name.endsWith(".csv"));

        if (listOfCsv != null && listOfCsv.length > 0) return listOfCsv;

        return null;
    }
}
