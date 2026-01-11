
package mumbo.jumbo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level3 extends JPanel implements ActionListener {
    boolean levelComplete = false;
    private Word w1;
    private Word w2;
    private Word w3;
    private static int correct = 0;  
    private JButton check;
    private JButton start;
    Timer timer;
    private int seconds = 60;
    private JLabel l = new JLabel("Time: 60");
    private JLabel info = new JLabel("LEVEL 3");
    private JLabel star1 = new JLabel("★");
    private JLabel star2 = new JLabel("★");
    private JLabel star3 = new JLabel("★");
    private JLabel result = new JLabel();
    private JButton hint1 = new JButton("💡");
    private JButton hint2 = new JButton("💡");
    private JButton hint3 = new JButton("💡");
    private JLabel gameOver = new JLabel("You ran out of time!");
    private JButton next = new JButton("Next Level");
    private CardLayout layout;
    private JPanel main;
    
    public Level3(CardLayout layout, JPanel main){
        this.layout = layout;
        this.main = main;
        this.setBounds(0,0,600,500);
        this.setLayout(null);
        l.setBounds(0,0,100,30);
        l.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        l.setVisible(false);
        this.add(l);
        
        gameOver.setBounds(170,20,450,30);
        gameOver.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gameOver.setVisible(false);
        this.add(gameOver);
        
       hint1.setBounds(10,105,55,20);
       hint1.setFocusable(false);
       hint1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
       hint1.setVisible(false);
       hint1.addActionListener(this);
       Color hintcolor = new Color(255,220,102);
       hint1.setBackground(hintcolor);
       
       this.add(hint1);
       
       hint2.setBounds(10,205,55,20);
       hint2.setFocusable(false);
       hint2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
       hint2.setVisible(false);
       hint2.addActionListener(this);
       hint2.setBackground(hintcolor);
       
       this.add(hint2);
       
       hint3.setBounds(10,305,55,20);
       hint3.setFocusable(false);
       hint3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
       hint3.setVisible(false);
       hint3.addActionListener(this);
       hint3.setBackground(hintcolor);
       
       this.add(hint3);
        
        info.setBounds(230,30,450,30);
        info.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        this.add(info);
        
        start = new JButton("START!");
        start.addActionListener(this);
        start.setBounds(200,380,150,30);
        start.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Color c = new Color(208,131,232);
        start.setBackground(c);
        start.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        start.setFocusable(false);
        this.add(start);
        
        next.addActionListener(this);
        next.setBounds(200,400,150,30);
        next.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        next.setBackground(c);
        next.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        next.setFocusable(false);
        next.setVisible(false);
        this.add(next);
        
        timer = new Timer(1000, this);
        this.setBackground(Color.PINK);
        w1 = new Word("WATER", "ATWRE");
        w2 = new Word("MONEY", "YNEOM");
        w3 = new Word("HOUSE", "SUEHO");
        w1.setBounds(70,50,500,100);
        w2.setBounds(70,150,500,100);
        w3.setBounds(70,250,500,100);
       
        w1.disableLetters();
        w2.disableLetters();
        w3.disableLetters();
        
        check = new JButton("Check Answers");
        check.addActionListener(this);
        check.setBounds(200,380, 150,30);
        check.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Color c2 = new Color(170, 225,255);
        check.setBackground(c2);
        check.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        check.setFocusable(false);
        check.setVisible(false);
        this.add(w1);
        this.add(w2);
        this.add(w3);
        this.add(check);
        
        star1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 70));
        star1.setForeground(Color.YELLOW);
        star1.setBounds(10,65,100,70);
        star1.setVisible(false);
        this.add(star1);
        
        star2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 70));
        star2.setForeground(Color.YELLOW);
        star2.setBounds(10,165,100,70);
        star2.setVisible(false);
        this.add(star2);
        
        star3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 70));
        star3.setForeground(Color.YELLOW);
        star3.setBounds(10,265,100,70);
        star3.setVisible(false);
        this.add(star3);
        
       result.setBounds(130,360,300,30);
       result.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
       result.setVisible(false);
       this.add(result);
             
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == start){
           timer.start();
           check.setVisible(true);
           start.setVisible(false);
           info.setVisible(false);
           w1.enableLetters();
           w1.gameLocked = false;
           w2.enableLetters();
           w2.gameLocked = false;
           w3.enableLetters();
           w3.gameLocked = false;
           l.setVisible(true);
           hint1.setVisible(true);
           hint2.setVisible(true);
           hint3.setVisible(true);
       }
       else if (e.getSource() == check){
           hint1.setVisible(false);
           hint2.setVisible(false);
           hint3.setVisible(false);
           next.setVisible(true);
           timer.stop();
           
       if (w1.checkOrder()){
           star1.setVisible(true);
           correct ++;}
       if(w2.checkOrder()){
           star2.setVisible(true);
           correct ++;
       } 
       if(w3.checkOrder()){
           star3.setVisible(true);
           correct ++;
       }
       check.setVisible(false);
       result.setText("You got: " + correct + " correct word(s) out of 3!");
       result.setVisible(true);
       next.setVisible(true);
        w1.disableLetters();
        w2.disableLetters();
        w3.disableLetters();
        w1.gameLocked = true;
        w2.gameLocked= true;
        w3.gameLocked = true;
       }
       
       else if (e.getSource() == timer) {
        seconds--;
        l.setText("Time: " + seconds);
        if(seconds == 0){
            timer.stop();
        gameOver.setVisible(true);
        w1.disableLetters();
        w2.disableLetters();
        w3.disableLetters();
        w1.gameLocked = true;
        w2.gameLocked= true;
        w3.gameLocked = true;}
    }
         else if(e.getSource() == hint1){
          w1.giveHint();
          if (w1.hintTimer != null && w1.hintTimer.isRunning()) {
        w1.hintTimer.stop();    
    }

    w1.hintTimer = new Timer(1000, evt -> w1.paintNormal());
    w1.hintTimer.setRepeats(false);
    w1.hintTimer.start();
}
          
       else if(e.getSource() == hint2){
          w2.giveHint();
          if (w2.hintTimer != null && w2.hintTimer.isRunning()) {
        w2.hintTimer.stop();   
    }

    w2.hintTimer = new Timer(1000, evt -> w2.paintNormal());
    w2.hintTimer.setRepeats(false);
    w2.hintTimer.start();
}
        else if(e.getSource() == hint3){
          w3.giveHint();
          if (w3.hintTimer != null && w3.hintTimer.isRunning()) {
        w3.hintTimer.stop();   
    }

    w3.hintTimer = new Timer(1000, evt -> w3.paintNormal());
    w3.hintTimer.setRepeats(false);
    w3.hintTimer.start();
}
       else if(e.getSource() == next){
           levelComplete = true;
           this.layout.show(this.main, "L4");
       }
      
    }
     public int getCorrect(){
        return correct;
    }
}

    
    

