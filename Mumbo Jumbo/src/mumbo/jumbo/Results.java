
package mumbo.jumbo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Results extends JPanel {
    private Level1 l1;
    private Level2 l2;
    private Level3 l3;
    private Level4 l4;
 private JLabel l = new JLabel();
 private JLabel l1Label = new JLabel();
 private JLabel l2Label = new JLabel();
 private JLabel l3Label = new JLabel();
 private JLabel l4Label = new JLabel();
 private JLabel thanks = new JLabel("Thanks for playing!");
  private CardLayout layout;
    private JPanel main;
    public Results(CardLayout layout, JPanel main, Level1 l1, Level2 l2, Level3 l3, Level4 l4){
     

        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
       this.setBackground(Color.PINK);
       this.layout = layout;
        this.main = main;
        this.setBounds(0,0,600,500);
        this.setLayout(null);
        l.setBounds(120,60,150,30);
        l.setText("Your scores:");
        l.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        
         
       l1Label.setBounds(200,120,300,30);
       l1Label.setText("LEVEL 1: " + l1.getCorrect() + "/3");
       
      l1Label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
       l2Label.setBounds(200,170,300,30);
       l2Label.setText("LEVEL 2: " + l2.getCorrect() + "/3");
      l2Label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
       l3Label.setBounds(200,220,300,30);
       l3Label.setText("LEVEL 3: " + l3.getCorrect() + "/3");
      l3Label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
       l4Label.setBounds(200,270,300,30);
       l4Label.setText("LEVEL 4: " + l4.getCorrect() + "/3");
      l4Label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
      thanks.setBounds(170,330,300,30);
      thanks.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        
      
        this.add(l);
        this.add(l1Label);
        this.add(l2Label);
    this.add(l3Label);
    this.add(l4Label);
    this.add(thanks);
}

 
}
