package ImportantAssignment;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FileReadWrite implements ActionListener {

    JFrame frame = new JFrame();

    JTextArea area = new JTextArea(10,20);
    JScrollPane pane = new JScrollPane(area);
    JButton browse = new JButton("browse");
    JButton saveas = new JButton("saveas");
    JButton save = new JButton("save");
    JButton reset = new JButton("reset");
JFileChooser chooser;
            
    public FileReadWrite() {
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new FlowLayout());

        frame.add(pane);
        frame.add(browse);
        frame.add(save);
        save.addActionListener(this);
        browse.addActionListener(this);

    }

    public static void main(String[] args) {
        new FileReadWrite();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == browse) {
            chooser=new JFileChooser(FileSystemView.getFileSystemView());
            int t = chooser.showOpenDialog(null);
            if (t == JFileChooser.APPROVE_OPTION) {
           
                    String path = chooser.getSelectedFile().getAbsolutePath();
                try {

                    File fr = new File(path);
                    Scanner reader = new Scanner(fr);
                     String data="";
                    while (reader.hasNextLine()) {
                        data += "\n"+reader.nextLine();
                        
                    }
                   area.setText(data);
                   reader.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "File Not FOund");
                }
            } else if (t == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "FileSystem view Cancelled");
            }

        }else if(ae.getSource()==save)
        {
            String data=area.getText();
            String path=chooser.getSelectedFile().getAbsolutePath();
            try{
           FileWriter fr=new FileWriter(path);
           
           fr.write(area.getText()+data);
           fr.close();
              JOptionPane.showMessageDialog(null, "Successfully wrote to the file.");
           
            }
            catch(Exception e)
            {
                System.out.println("Error Occured");
            }
            }

    }

}
