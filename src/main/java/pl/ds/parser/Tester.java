package pl.ds.parser;

import pl.ds.pojo.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Tester {

    /**
     * Default value for where = ""
     * Default value for level = 2 - Rung
     * @param check list of Strings to look for in controller programs
     * @param content RSLogix5000Content
     * @return HashMap(programName, HashMap(routineName, list of rungs))
     */
    public static HashMap<String, HashMap<String, List<String>>> getMapOfErrors(List<String> check, 
                                                                                RSLogix5000Content content) {
        return getMapOfErrors(check, "", content, 2);
    }

    /**
     * Default value for level = 2 - Rung
     * @param check list of Strings to look for in controller programs
     * @param where String of in which program you want to serach (can by "" to search in whole controller)
     * @param content RSLogix5000Content
     * @return HashMap(programName, HashMap(routineName, list of rungs))
     */
    public static HashMap<String, HashMap<String, List<String>>> getMapOfErrors(List<String> check, String where,
                                                                                RSLogix5000Content content) {
        return getMapOfErrors(check, where, content, 2);
    }

    /**
     *
     * @param check list of Strings to look for in controller programs
     * @param where String of in which program you want to serach (can by "" to search in whole controller)
     * @param content RSLogix5000Content
     * @param level 0 - Program name; 1 - Routine name; 2 - Rung
     * @return HashMap(programName, HashMap(routineName, list of rungs))
     */
    public static HashMap<String, HashMap<String, List<String>>> getMapOfErrors(List<String> check, String where,
                                                                   RSLogix5000Content content, int level) {
        List<String> rungList;
        HashMap<String, List<String>> routineMap;
        LinkedHashMap<String, HashMap<String, List<String>>> result = new LinkedHashMap<>();
        HashMap<String, List<String>> conditionMap = new HashMap<>();
        conditionMap.put(where, check);
        result.put("Conditions" + level,conditionMap);

        Controller controller = content.getController();

        for (Program program : controller.getPrograms()) {
            routineMap = new HashMap<>();
            for (Routine routine : program.getRoutines()) {
                rungList = new ArrayList<>();
                for (Rung rung : routine.getRungs()) {
                    switch (level) {
                        case 0:
                            if (program.getName().contains(where)) {
                                checkOccurrences(check, rungList, routineMap, routine, rung);
                            }
                            break;
                        case 1:
                            if (routine.getName().contains(where)) {
                                checkOccurrences(check, rungList, routineMap, routine, rung);
                            }
                            break;
                        case 2:
                            checkOccurrences(check, rungList, routineMap, routine, rung);
                            break;
                    }
                }
            }
            result.put(program.getName(), routineMap);
        }
        return result;
    }

    private static void checkOccurrences(List<String> check, List<String> rungList,
                                         HashMap<String, List<String>> routineMap, Routine routine, Rung rung) {
        if (check.size() > 1) {
            for (int i = 0; i < check.size(); i++) {
                for (int j = i + 1; j < check.size(); j++) {
                    if (rung.getText().contains(check.get(i))
                            && rung.getText().contains(check.get(j))) {
                        rungList.add("Condition - "
                                + check.get(i) + " and " + check.get(j) + " - "
                                + rung.getNumber() + " - "
                                + rung.getText().trim());
                    }
                }
            }
            routineMap.put(routine.getName(), rungList);
        }
    }

    private static String parseResult(HashMap<String, HashMap<String, List<String>>> result) {
        StringBuilder builder = new StringBuilder();
        for (String program : result.keySet()) {
            boolean nameCondition = !program.equals("Conditions0")
                    && !program.equals("Conditions1") && !program.equals("Conditions2");
            if (nameCondition)
                builder.append("Program - ")
                        .append(program)
                        .append('\n');
            else if (program.equals("Conditions0")) builder.append("Conditions - Program Level\n");
            else if (program.equals("Conditions1")) builder.append("Conditions - Routine Level\n");
            else builder.append("Conditions - Rung Level\n");
            for (String routine : result.get(program).keySet()) {
                if (nameCondition)
                    builder.append("\tRoutine - ")
                            .append(routine)
                            .append('\n');
                else builder.append("\tWhere - ")
                        .append(routine)
                        .append('\n');
                for (int i = 0; i < result.get(program).get(routine).size(); i++) {
                    if (nameCondition)
                        builder.append("\t\tRung - ")
                                .append(result.get(program).get(routine).get(i))
                                .append('\n');
                    else builder.append("\t\tFind - ")
                            .append(result.get(program).get(routine).get(i))
                            .append('\n');
                }
            }
        }
        return builder.toString();
    }

    public static void saveResultToTxTFile(HashMap<String, HashMap<String, List<String>>> result,
                                           String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(path)
                .append('\\')
                .append(LocalDateTime.now().getYear());
        if (LocalDateTime.now().getMonthValue() < 10) builder.append("0")
                .append(LocalDateTime.now().getMonthValue());
        else builder.append(LocalDateTime.now().getMonthValue());
        if (LocalDateTime.now().getDayOfMonth() < 10) builder.append("0")
                .append(LocalDateTime.now().getDayOfMonth());
        else builder.append(LocalDateTime.now().getDayOfMonth())
                .append("_");
        if (LocalDateTime.now().getHour() < 10) builder.append("0")
                .append(LocalDateTime.now().getHour());
        else builder.append(LocalDateTime.now().getHour());
        if (LocalDateTime.now().getMinute() < 10) builder.append("0")
                .append(LocalDateTime.now().getMinute());
        else builder.append(LocalDateTime.now().getMinute())
                .append("_RaportL5K")
                .append(".txt");

        File fileToSave = new File(builder.toString());

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));
        writer.write(parseResult(result));
    }
}
