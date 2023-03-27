package io_;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
    public static void main(String[] args){
        try {
            //DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"))

            FileOutputStream fos = new FileOutputStream("result.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("이희경");
            dos.writeInt(25);
            dos.writeDouble(166);

            dos.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();

        }
    }
}
