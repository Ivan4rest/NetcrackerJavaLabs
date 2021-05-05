package JAXB;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXB {
    private static Logger logger = Logger.getLogger(JAXB.class);

    public static void toXml(Object obj, String filePath) {
        logger.info("Started converting to XML");
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e){
            logger.error(e.getMessage());
        }
        logger.info("Ended converting to XML");
    }

    public static Object fromXml(String filePath, Class<?> clazz) {
        logger.info("Started converting from XML");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e){
            logger.error(e.getMessage());
        }
        logger.info("Ended converting from XML");
        return null;
    }
}
