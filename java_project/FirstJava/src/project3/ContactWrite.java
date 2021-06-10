package project3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class ContactWrite extends Thread{
    File file;
    List<Contact> contacts;
    public ContactWrite(List<Contact> contacts, File file){
        this.file = file;
        this.contacts = contacts;
    }

    @Override
    public void run() {
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
