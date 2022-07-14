package pl.ds.parser;

import pl.ds.pojo.RSLogix5000Content;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Runner {
    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(RSLogix5000Content.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        RSLogix5000Content rsLogix5000Content = (RSLogix5000Content) unmarshaller
                .unmarshal(new File("src/main/resources/Line1_RT_Cell1.L5X"));

        System.out.println(rsLogix5000Content.getController().getProgramByName("P0010_mainprogram"));
    }
}
