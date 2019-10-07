package specialpong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame; 
/**
 * @author CSchafer
 */
public class SpecialPong {

  
    public static void main(String[] args) {
       JFrame j = new JFrame("Special pong");
        World c = new World();
        j.add(c);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(800, 600);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                c.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                c.keyReleased(e);
            }
        });
    }
    
}
