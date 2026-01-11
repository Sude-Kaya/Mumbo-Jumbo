
package mumbo.jumbo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class Letter extends JButton implements MouseListener, MouseMotionListener {
    private Word word;
    private char character;
    private Point offset;
    private boolean isDragging = false;
    boolean isInSlot = true;
    
    public Letter(char character, Word word){
        super(String.valueOf(character));
        this.character = character;
        this.word = word; 
        setOpaque(true);
        addMouseListener(this);   
        addMouseMotionListener(this);
        setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        setBackground(word.wordColor);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setFocusPainted(false);
        setContentAreaFilled(true);
        setOpaque(true);
        setSize(60, 60);
        
        
        
       
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
    }
 
     @Override
    public void mousePressed(MouseEvent e) {
       if (word.gameLocked) return;
       offset = e.getPoint();
       isDragging = true;
       
    }
    

    @Override
   public void mouseDragged(MouseEvent e) { 
    if (word.gameLocked) return;
    if (!isDragging) return;
    isInSlot = false;
    Point parentPoint = SwingUtilities.convertPoint(this, e.getPoint(), getParent());

    int newX = parentPoint.x - offset.x;
    int newY = parentPoint.y - offset.y;

    int pw = getParent().getWidth();
    int ph = getParent().getHeight();

    int lw = getWidth();
    int lh = getHeight();

    if (newX < 0) newX = 0;
    if (newX > pw - lw) newX = pw - lw;

    if (newY < 0) newY = 0;
    if (newY > ph - lh) newY = ph - lh;

    setLocation(newX, newY);
}


    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    
    @Override
    public void mouseReleased(MouseEvent e) {
      if (word.gameLocked) return;
      isDragging = false;
      Rectangle r = this.getBounds();
      word.snapToPlace(this, r);
  
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    public char getChar() {
      return this.character;
    }

   
    
}
