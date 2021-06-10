package project5.fileHandler;

import project5.contectPackage.Contact;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ContactWrite extends Thread{
    private File file;
    private List<Contact> contacts;
    public ContactWrite(List<Contact> contacts, File file){
        this.file = file;
        this.contacts = contacts;
    }

    @Override
    public void run() {
        contactSave();
    }

    public synchronized void contactSave(){
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(contacts);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("파일 저장 완료");
    }
}
