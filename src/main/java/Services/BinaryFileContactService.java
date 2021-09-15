package Services;

import Models.Contact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BinaryFileContactService extends InFileContactService {


    public BinaryFileContactService(List<Contact> contacts, String s) {
        super(contacts,s);
    }

    @Override
    List<Contact> load() {

        if (cash == null) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(getInputStream()))
                {

                        cash=(ArrayList<Contact>)objectInputStream.readObject();

                }
            catch(EOFException e)
            {
                cash=new ArrayList<>();
                return cash;
            }
            catch (IOException | ClassNotFoundException e) {

                throw new RuntimeException("IO Exception or Class not found in load function");


            }

        }

        return cash;
    }

    @Override
    void save(List<Contact> contactList) {
        cash = contactList;

        try (OutputStream os = getOutputStream()){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(contactList);
            objectOutputStream.flush();
            cash=contactList;

        } catch (IOException e) {
            throw new RuntimeException("IO Exception in save function");
           // e.printStackTrace();
        }


    }


}
