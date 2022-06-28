package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper
{
    public static final String FileName = "listinfo.dat";
    //METHOD TO WRITE INTO A FILE
    public static void writeData(ArrayList<String> item, Context context)
    {
        try {
            FileOutputStream fos = context.openFileOutput(FileName, Context.MODE_PRIVATE); //This class is used to write data into a file
            ObjectOutputStream oas = new ObjectOutputStream(fos);   //these two classes are use together to write data into a file
            oas.writeObject(item);
            oas.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //METHOD TO READ FROM A FILE
    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemList = null;

        try {
            FileInputStream fis = context.openFileInput(FileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemList = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemList = new ArrayList<>(); //it is necessary for the very first opening of the application

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemList;
    }




}

