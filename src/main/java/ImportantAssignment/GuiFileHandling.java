package ImportantAssignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class GuiFileHandling implements ActionListener {

    JFrame frame = new JFrame("FileHandling_GUI");
    JTextArea area = new JTextArea(10, 30);
    JScrollPane pane = new JScrollPane(area);
    JButton browse = new JButton("Browse");
    JButton saveAs = new JButton("SaveAs");
    JButton save = new JButton("Save");
    JButton reset = new JButton("Reset");
    JButton count = new JButton("Count");
    JTextArea resultArea = new JTextArea(30, 60);
    String path = "";

    JFileChooser chooser;

    public GuiFileHandling() {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.add(browse);
        frame.add(save);
        frame.add(saveAs);
        frame.add(reset);
        frame.add(count);
        frame.add(pane);
        frame.add(resultArea);
        browse.addActionListener(this);
        save.addActionListener(this);
        reset.addActionListener(this);
        saveAs.addActionListener(this);
        count.addActionListener(this);

    }

    public static void main(String[] args) 
    {
        new GuiFileHandling();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //for Browse button
        if (e.getSource() == browse) {
            System.out.println("Browse");
            chooser = new JFileChooser(FileSystemView.getFileSystemView());
            int d = chooser.showOpenDialog(null);
            if (d == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getAbsolutePath();
                try {
                    File myObj = new File(path);
                    Scanner myReader = new Scanner(myObj);
                    String data = "";
                    while (myReader.hasNextLine()) {
                        myReader.delimiter();
                        data += myReader.nextLine();

                    }
                    area.setText(data);
                    myReader.close();
                } 
                catch (FileNotFoundException ex) {
                    System.out.println("An error occurred.");
                }
            } else 
                if (d == JFileChooser.CANCEL_OPTION) {
                System.out.println("Cancelled ");
            }
            //for saveAs
        } else if (e.getSource() == saveAs) {
            JFileChooser saveChooser = new JFileChooser("/home/uzairleo/Desktop");
            int d = saveChooser.showSaveDialog(null);
            if (d == JFileChooser.APPROVE_OPTION) {
                String data = area.getText();
                String path = saveChooser.getSelectedFile().getAbsolutePath();
                try {
                    FileWriter myWriter = new FileWriter(path);
                    // writting the file
                    myWriter.write(data);
                    //As closing is important so that no one can read and write the file externally
                    myWriter.close();
                    JOptionPane.showMessageDialog(null, "Successfully wrote to the file.");
                } catch (IOException ex) {
                    System.out.println("An error occurred.");
                }
            } else if (d == JFileChooser.CANCEL_OPTION) {

            }
            //for reset
        } else if (e.getSource() == reset) {
            area.setText("");
            
           
        } else 
         //for save
        if (e.getSource() == save) {
            String data = area.getText();
            path = chooser.getSelectedFile().getAbsolutePath();
            try {
                FileWriter myWriter = new FileWriter(path);
                // Writes this content into the specified file
                myWriter.write(data);
                // Closing is necessary to retrieve the resources allocated
                myWriter.close();
                JOptionPane.showMessageDialog(null, "Successfully wrote to the file.");
            } catch (IOException ex) {
                System.out.println("An error occurred.");
            }
            //for Count
        } else if (e.getSource() == count) {

          path = chooser.getSelectedFile().getAbsolutePath();

            try {
                File file = new File(path);
                BufferedReader reader = new BufferedReader(new FileReader(path));
                Scanner readFile = new Scanner(file);
                //initilizers
                char ch;
                int count = 0;
                int aa = 0, ee = 0, ii = 0, oo = 0, uu = 0;
                int consonants = 0;
                int whitespaces = 0;
                int sentence = 1;
                String data = "";
                while (readFile.hasNextLine()) {
                    data = readFile.nextLine();
                    for (int i = 0; i < data.length(); i++) {
                        ch = data.charAt(i);
                switch (ch) {
                            case 'a':
                            case 'A':
                                aa++;
                                break;
                            case 'e':
                            case 'E':
                                ee++;
                                break;
                            case 'i':
                            case 'I':
                                ii++;
                                break;
                            case 'o':
                            case 'O':
                                oo++;
                                break;
                            case 'u':
                            case 'U':
                                uu++;
                                break;
                            case '.':
                            case ',':
                            case '!':
                                sentence++;
                                break;
                        case 'b':case 'B':case 'c':case 'C':case 'd':case 'D':
                        case 'f':case 'F':case 'g':case 'G':case 'h':case 'H':
                        case 'j':case 'J':case 'k':case 'K':case 'l':case 'L':
                        case 'm':case 'M':case 'n':case 'N':case 'p':case 'P':
                        case 'q':case 'Q':case 'r':case 'R':case 's':case 'S':
                        case 't':case 'T':case 'v':case 'V':case 'w':case 'W':
                        case 'x':case 'X':case 'y':case 'Y':case 'z':case 'Z':
                                consonants++;
                            default:
                                whitespaces++;

                        }

                    }
                }
                count = aa + ee + ii + oo + uu;
                
                System.out.println("Total number of a is " + aa);
                System.out.println("Total number of e is " + ee);
                System.out.println("Total number of i is " + ii);
                System.out.println("Total number of o is " + oo);
                System.out.println("Total number of u is " + uu);

                System.out.println("Total number of Vowel is " + count);

                System.out.println("Total number of consonant is " + consonants);
                System.out.println("\n\n\n");

                String line;
//         Initializing counters 
                int countWord = 0;
                int sentenceCount = 0;
                int characterCount = 0;
                int paragraphCount = 1;
                int whitespaceCount = 0;
//          
//         Reading line by line from the  
//         file until a null is returned 
                while ((line = reader.readLine()) != null) {

                    if (line.equals("")) {
                        paragraphCount++;
                    }
                    if (!(line.equals(""))) {
                        characterCount += line.length();
                        // \\s+ is the space delimiter in java 
                        String[] wordList = line.split("\\s+");

                        countWord += wordList.length;
                        whitespaceCount += countWord - 1;

                        // [!?.:]+ is the sentence delimiter in java programming
                        String[] sentenceList = line.split("[!?.:]+");

                        sentenceCount += sentenceList.length;
                    }
                }
//          
                System.out.println("Total word count = " + countWord);
                System.out.println("Total number of characters = " + characterCount);
                System.out.println("Number of paragraphs = " + paragraphCount);
                System.out.println("Total number of whitespaces = " + whitespaceCount);
                System.out.println("Total number of sentences = " + sentenceCount); 
                String countResult = "Total number of a is = " + aa + "\n"
                        + "Total number of e is = " + ee + "\n"
                        + "Total number of i is = " + ii + "\n"
                        + "Total number of o is = " + oo + "\n"
                        + "Total number of u is = " + uu + "\n"
                        + "---------------------------------------\n"
                        + "Total number of Vowel is = " + count + "\n"
                        + "---------------------------------------" + "\n"
                        + "Total number of Consonants is = " + consonants + "\n"
                        + "---------------------------------------\n\n"
                        + "Total word count = " + countWord + "\n"
                        + "---------------------------------------\n\n"
                        + "Total number of characters = " + (characterCount-whitespaceCount) + "\n"//for pure character count we can also subtract whitespaces from it like 
                        + "---------------------------------------\n\n"         //(characterCount-whitespaceCount) it will give us actual character without spaces
                        + "Number of paragraphs = " + paragraphCount + "\n"
                        + "---------------------------------------\n\n"
                        + "Total number of whitespaces = " + whitespaceCount+"\n"
                        +"---------------------------------------\n"
                        +"Total number of sentences = " + sentenceCount+"\n"
                        +"---------------------------------------\n";
                resultArea.setText(countResult);
//        
                String sentences = reader.readLine();
                while (sentences != null) {
                    System.out.println(sentence);
                    sentences = reader.readLine();

                }

            } catch (IOException ex)
            {
                System.err.println("Sorry Error Occured");
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
        }
    }
}
