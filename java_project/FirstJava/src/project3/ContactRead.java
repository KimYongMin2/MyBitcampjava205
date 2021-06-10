package project3;

import java.io.*;
import java.util.*;

public class ContactRead extends Thread{
    private File file;
    private List<Contact> contacts;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

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

        System.out.println("파일 불러오기 완료");
    }
}
