package project6.contect.file_io;

import project6.contect.construct.Contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

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
        contactReadFile();
    }

    public synchronized void contactReadFile(){
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
