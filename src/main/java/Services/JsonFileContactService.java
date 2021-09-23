package Services;

import Models.Contact;
import Util.ListUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
public class JsonFileContactService extends InFileContactService {

    public JsonFileContactService(List<Contact> contacts, String s) {
        super(contacts, s);
    }

    @Override
    List<Contact> load() {

        if (cash == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            cash = new ArrayList<Contact>();
            try (InputStream inputStream = getInputStream()) {
                cash = objectMapper.readValue(inputStream, new TypeReference<ArrayList<Contact>>() {
                });

            } catch (EOFException e) {
                cash = new ArrayList<>();
                return cash;
            }
            catch (JsonParseException e)
            {
                System.out.println("Cannot parse the file");
                return cash;
            }
            catch (IOException e) {
                // e.printStackTrace();
                throw new RuntimeException("IO Exception or Class not found in load function");

            }
        }

        return cash;
    }

    @Override
    void save(List<Contact> contactList) {

        cash = contactList;
        ObjectMapper jsonMapper = new ObjectMapper();

        try (OutputStream os = getOutputStream()) {
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(os, contactList);
            os.flush();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("IO Exception in save function");



        }



    }


}
