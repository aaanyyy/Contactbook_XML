package Services;

import Models.Contact;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class CsvFileContactService extends InFileContactService {


    public CsvFileContactService(List<Contact> contacts, String s) {
        super(contacts,s);
    }

    @Override
    List<Contact> load() {

        if (cash == null) {
            cash=new ArrayList<>();
            try (InputStream is=getInputStream())
                {
                    Scanner sc=new Scanner(is);

                    while (sc.hasNextLine())
                    {
                        String str=sc.nextLine();
                        String arr[]=str.split(";");
                        if(arr.length==3)
                        {
                            cash.add(new Contact(Integer.getInteger(arr[0]),arr[1],arr[2]));

                        }
                    }

                }
            catch(EOFException e)
            {
                return cash;
            }
            catch (IOException  e) {

                throw new RuntimeException("IO Exception or Class not found in load function");


            }

        }

        return cash;
    }

    @Override
    void save(List<Contact> contactList) {
        cash = contactList;

        try (OutputStream os = getOutputStream()){
            PrintWriter pw=new PrintWriter(os);
            for (Contact contact : contactList) {
                String str=contact.getId()+";"+contact.getName()+";"+contact.getPhone()+"\n";
                os.write(str.getBytes());
                //pw.printf("%d;%s;%s\n",contact.getId(),contact.getName(),contact.getPhone());
            }
            //contactList.stream().forEach(contact->pw.printf("%d;%s;%s\n",contact.getId(),contact.getName(),contact.getPhone()));
            os.flush();
            cash=contactList;

        } catch (IOException e) {
            throw new RuntimeException("IO Exception in save function");
           // e.printStackTrace();
        }


    }



}
