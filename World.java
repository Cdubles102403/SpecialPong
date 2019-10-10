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
    private Ball ball;
    private Timer timer;
    private PowerUp pu;

    public World() {
        super();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/50);
        player = new Player(800,600);
        enemy = new Enemy(800,600);
        ball = new Ball(800,600);
        pu = new PowerUp(800,600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        player.draw(g);
        enemy.draw(g);
        ball.draw(g);
        pu.draw(g);
    }
    
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            repaint();
            enemy.update();
            player.update();
            pu.update();
            ball.move();
            ball.sidebounce();
            scoreCheck();
            // enemyMech();
            //bounce if ball touches paddles
            if(player.getBounds().intersects(ball.getBounds())){
            ball.bounce();
            System.out.println("player score is" + player.getScore());
            }
            if(enemy.getBounds().intersects(ball.getBounds())){
            ball.bounce();
            
            System.out.println("player score is" + enemy.getScore());

            }
            ball.update();
            }
    }
    //enemy mechanics
    //work in progress, not in use
    public void enemyMech(){
        int enemyPos = enemy.getY();
        int ballPos = ball.getY();
        if(enemyPos > ballPos){
            while(enemyPos > ballPos){
                enemy.setY(-1);
            }
        }
        if(enemyPos < ballPos){
            while(enemyPos < ballPos){
                enemy.setY(1);
            }
        }
    }
    //power up collision
    public void puCollision(){
        if(ball.getBounds().intersects(pu.getBounds())){
            
        }
    }
    //ball score check
       public void scoreCheck(){
         if(ball.getX() >= 800){
           enemy.increasePoints();
           ball.reset();
         }
         if(ball.getX() <= 0){
             player.increasePoints();
             ball.reset();
         }
     }
//keyboard events
    public void keyPressed(KeyEvent e) {

         if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move("down");
        }
        //enemy keys (W and S)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            enemy.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            enemy.move("down");
        } 
    }
//release events
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            enemy.stop();
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            enemy.stop();
        }
    }
}
