
package mumbo.jumbo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Word extends JPanel {
    Timer hintTimer;
    private String trueOrder;
    private String currentOrder;
    private ArrayList<Slot> slots;
    private ArrayList<Letter> letters;
    boolean gameLocked = true;
    Color wordColor = new Color(153,186,219);
    
     public Word(String trueOrder, String currentOrder){
       setLayout(null);
       this.setBackground(Color.pink);
       this.setPreferredSize(new Dimension(500,100));
       slots = new ArrayList<>();
       letters = new ArrayList<>();
       this.trueOrder = trueOrder;
       this.currentOrder = currentOrder;
       
      
       
        for (int i = 0; i < currentOrder.length(); i++) {
            Letter l = new Letter(currentOrder.charAt(i), this);
            letters.add(l);
        }
        
        int startX = 60;
        int y = 30;
        int spacing = 65;
        
        for (int i = 0; i < trueOrder.length(); i++) {
            int x = startX + i * spacing;
            char trueChar = trueOrder.charAt(i);
            Slot s = new Slot(trueChar, letters.get(i).getChar(), x, y);
            slots.add(s);
            this.add(s);
            letters.get(i).setBounds(x, y,60,60);
        }
       
         for (Letter l : letters){
             this.add(l);
        }
        
       
       
       
    }
     
    public void removeLetter(Letter letter) {
    for (Slot s : slots) {
        if (s.getCurrentChar() == letter.getChar()) {
            s.clearSlot();
           
        }
    }}
  

    public boolean snapToPlace(Letter l, Rectangle r) { 
        removeLetter(l);
        for(Slot s : slots){
            if(r.intersects(s.getR()) && !s.isOccupied()){
              l.setBounds(s.getR());
              s.setCurrentChar(l.getChar());
             s.tryPlaceLetter(l.getChar());
             l.isInSlot = true;
              return true;
            }
        } 
        return false;
    }
   
    public void disableLetters(){
        for (Letter l : this.letters){
            l.setEnabled(false);
            
        }
    }
    
    public void enableLetters(){
        for (Letter l : this.letters){
            l.setEnabled(true);
        }
    }
   
    public boolean checkOrder() {
      for(Slot s: slots){
          if (!s.isCorrect()){
              return false;
          }
      }
    return true;
    }
       @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for(Slot s: slots){
        Color outline = new Color(0,3,156);
        g.setColor(outline);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(s.getX(), s.getY(), s.getR().width-1, s.getR().height-1);
        g.setColor(wordColor);}
}

    public void giveHint() {
         for(Slot s: slots){
          if (s.isCorrect()){
            for(Letter l: letters){
               if(l.getChar() == s.getCurrentChar() && l.isInSlot){
                   l.setBackground(Color.GREEN);
                   l.repaint();
               }
            }
            
          }
          else{
            for(Letter l: letters){
               if(l.getChar() == s.getCurrentChar() && l.isInSlot){
                   l.setBackground(Color.RED);
                   l.repaint();
               }
            }}
      
         }}
    
    public void paintNormal(){
        for(Letter l : letters){
            l.setBackground(wordColor);
            l.repaint();
        }
    }
    
}
