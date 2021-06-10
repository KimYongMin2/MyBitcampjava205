package project3;

import java.io.*;
import java.util.*;

public class ContactRead extends Thread{
    File file;
    List<Contact> contacts;
    public ContactRead(List<Contact> contacts, File file){
        this.file = file;
        this.contacts = contacts;
    }

    @Override
    public void run() {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Contact> contactsRead = (ArrayList<Contact>) in.readObject();
            contacts = contactsRead;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("파일 저장 완료");
    }
}
