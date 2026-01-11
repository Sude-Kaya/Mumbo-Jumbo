
package mumbo.jumbo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MumboJumbo {
 public static int count = 0;
   
    public static void main(String[] args) {
       
    JFrame frame = new JFrame();
    frame.setSize(600,500);
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Mumbo Jumbo");
    frame.setBackground(Color.PINK);
    CardLayout layout = new CardLayout();
    JPanel main = new JPanel(layout);
    Level1 l1 = new Level1(layout, main);
    Level2 l2 = new Level2(layout, main);
    Level3 l3 = new Level3(layout, main);
    Level4 l4 = new Level4(layout, main, l1, l2, l3);
    Results r = new Results(layout,main,l1,l2,l3,l4);
    main.add(l1, "L1");
    main.add(l2, "L2");
    main.add(l3, "L3");
    main.add(l4, "L4");
    main.add(r, "Results");
    frame.add(main);

  
    frame.setVisible(true);
    }
    
}
