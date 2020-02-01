
package ImportantAssignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author uzairleo
 */
public class EventHandler implements ActionListener
        
{

    JLabel magic=new JLabel();
    JButton apear=new JButton();
    JButton disapear=new JButton();
    EventHandler(JLabel magic,JButton apear ,JButton disapear){
        this.magic=magic;
        this.apear=apear;
        this.disapear=disapear;
    }
    
    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == apear) {
            magic.setText("uzairleo");

        } else if (button.getSource() == disapear) {

            magic.setText("");
        }

    }
    

    
}
