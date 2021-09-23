package Services;

import Models.Contact;
import Util.ListUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
public class XmlFileContactService extends InFileContactService {

    public XmlFileContactService(List<Contact> contacts, String s) {
        super(contacts,s);
    }

    @Override
    List<Contact> load() {
        //to check if file exists
        if (cash == null) {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            cash = new ArrayList<Contact>();
            InputStream is = null;
            try(InputStream inputStream=getInputStream()) {

                cash = xmlMapper.readValue(inputStream, new TypeReference<ArrayList<Contact>>() {});
            }catch (JsonParseException e)
            {
                System.out.println("Cannot parse the file");
                return cash;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

            return cash;
        }


    @Override
    void save(List<Contact> contactList) {

        cash = contactList;
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);//xml header on


        try (OutputStream os = getOutputStream())
        {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(os, contactList);
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
