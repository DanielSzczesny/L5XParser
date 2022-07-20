package pl.ds.parser;

import pl.ds.pojo.RSLogix5000Content;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Runner {
    public static void main(String[] args) throws JAXBException, IOException, URISyntaxException {

        JAXBContext context = JAXBContext.newInstance(RSLogix5000Content.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        String mainDirPath = new File(Runner.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI()).getParent();

        File[] listOfL5XFiles = Parser.prepareInputL5XFiles(mainDirPath);
        File[] listOfCsvFile = Parser.prepareInputCsvFiles(mainDirPath);

        assert listOfL5XFiles != null;
        Parser.parseL5X(unmarshaller, mainDirPath, listOfL5XFiles, listOfCsvFile);
    }

}
