package pl.ds.parser;

import pl.ds.pojo.RSLogix5000Content;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(RSLogix5000Content.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        RSLogix5000Content rsLogix5000Content = (RSLogix5000Content) unmarshaller
                .unmarshal(new File("src/main/resources/Line1_RT_Cell1.L5X"));


        List<String> conditions = new ArrayList<>();
//        conditions.add("HTL");
//        conditions.add("HTR");
        conditions.add("DryWt");
        conditions.add("WetWt");
        conditions.add("Left");
        conditions.add("Right");
        conditions.add("RTL");
        conditions.add("RTR");

        System.out.println(Tester.parseResult(Tester.getMapOfErrors(conditions, rsLogix5000Content)));
    }
}
