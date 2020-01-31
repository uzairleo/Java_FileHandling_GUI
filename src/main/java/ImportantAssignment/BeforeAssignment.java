package ImportantAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author uzairleo
 */
public class BeforeAssignment {//practice before doing the Assignment

    public static void main(String[] args) {
        try {

            //Creating new File using File Class
            File nFile = new File("/home/uzairleo/Desktop/leo.txt");
            if (nFile.exists())//to create write nFile.createNewFile();
            {
                //FileInformation
                System.out.println(" FileName : " + nFile.getName());
                System.out.println(" path of File : " + nFile.getAbsolutePath());
                System.out.println(" can read : " + nFile.canRead());
                System.out.println(" can write : " + nFile.canWrite());
                System.out.println(" can execute : " + nFile.canExecute());
                System.out.println(" file exist : " + nFile.exists());
                System.out.println(" is it file or Folder : " + nFile.isFile());
                System.out.println(" file size in Bytes : " + nFile.length());
                //file writting
//                FileWriter fwrite = new FileWriter("/home/uzairleo/Desktop/leo.txt");
//                fwrite.write("successfully write the file");
//
//                System.out.println("successfully write the file");

                //File Reading 
                File fr = new File("/home/uzairleo/Desktop/leo.txt");
                Scanner reader = new Scanner(fr);
                String data = "";
                while (reader.hasNextLine()) {
                    data = reader.nextLine();
                }
                System.out.println(data);
                //file must be closed at the end so that no one can read and rite from externally

            } else {
                System.out.println("FileNotexist");
            }
        } catch (Exception ex) {

        }
    }

}
