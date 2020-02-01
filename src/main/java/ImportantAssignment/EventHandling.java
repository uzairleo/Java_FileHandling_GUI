package ImportantAssignment;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author uzairleo there are three methods to handle event in java 1-using the
 * same class by implementing the listeners 2-using outer class and then
 * extending the outer class by main 3-using the Anonymous class means in the
 * same class without any implementation or extending procedures
 */
public class EventHandling {

    JFrame frame = new JFrame();
    JLabel magic = new JLabel("");
    JButton apear = new JButton("Apear");
    JButton disapear = new JButton("DisApear");

    EventHandling() {
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new FlowLayout());

        frame.add(apear);
        frame.add(disapear);
        frame.add(magic);
EventHandler handler=new EventHandler(magic,apear,disapear);

apear.addActionListener(handler);
disapear.addActionListener(handler);

    
    }
    
    public static void main(String[] args) {
        new EventHandling();

    }

   
}
