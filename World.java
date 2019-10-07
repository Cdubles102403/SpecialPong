/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialpong;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author CSchafer
 */
public class World extends JPanel {
    private Player player;
    private Enemy enemy;
    private Timer timer;

    public World() {
        super();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/50);
        player = new Player(800,600);
        enemy = new Enemy(800,600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        player.draw(g);
        enemy.draw(g);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
            enemy.update();
            player.update();
            
        }
    }

    public void keyPressed(KeyEvent e) {

         if (e.getKeyCode() == KeyEvent.VK_UP) {
             enemy.move();
            player.move("up");
            System.out.println("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move("down");
            enemy.move();
            System.out.println("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
            enemy.stop();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
            enemy.stop();
        }

    }
}
