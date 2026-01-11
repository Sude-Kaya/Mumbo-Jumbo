
package mumbo.jumbo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;


public class Slot extends JPanel{
    private Rectangle r;
    private char trueChar;
    private char currentChar;
    private boolean isOccupied = true;
    private final int width = 60;
    private final int height = 60;
    private int x;
    private int y;
    
    public Slot(char trueChar, char currentChar, int x , int y){
        this.trueChar = trueChar;
        this.currentChar = currentChar;
        this.x = x;
        this.y = y;
        r = new Rectangle(x,y,width,height);
        setSize(width, height);
        setOpaque(false);
        setBounds(r);
    }
    public boolean tryPlaceLetter(char letterChar){
        if(!isOccupied){
            this.currentChar = letterChar;
            this.isOccupied = true;
            return true;
        }
        return false;
    }
    public void clearSlot(){
        this.currentChar = '0';
        this.isOccupied = false;      
    }
    public Rectangle getR(){
        return this.r;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public char getCurrentChar(){
        return this.currentChar;
    }
    public void setCurrentChar(char c){
        this.currentChar = c;
    }
     public boolean isOccupied() {
        return this.isOccupied;
    }
     public boolean isCorrect(){
          if (currentChar == 0) {
        return false;
    }
         return isOccupied && this.getCurrentChar() == this.trueChar;
     }
     public void setOccupied(boolean b){
         this.isOccupied = b;
     }
   






}
