package specialpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author CSchafer
 */
public class Ball {
   private int width, x, y, vy,vx,rx,ry;
   private Rectangle bounds;
   private Color color;
    
    public Ball(int cWidth, int cHeight){
       this.x = cWidth/2;
       this.y = cHeight /2;
       this.rx = cWidth/2;
       this.ry = cHeight /2;
       this.width = 30;
       this.vy = 2;
       this.vx = -1;
       this.color = Color.blue;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.width); 
    }
    public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g; 
       g2d.draw(bounds);
       g2d.fillOval(x,y,width,width);  
    }
    public void update(){
        this.x += vx;
       this.y += vy;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.width);
    }
    public void bounce(){
    int ran1 =(int) (Math.random()*6+1);
    if(this.vy > 0){
        this.vy = ran1;
    }
    if(this.vy<0){
        this.vy = -ran1;
    }
    this.vx = -this.vx;
    this.vy = -this.vy;
    
    move();
    move();
    move();
    move();
    }
        //movment
    public void move(){
        this.x +=vx;
        this.y +=vy;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void sidebounce(){
       if(this.y >= 600-width){
           this.vy = -vy;
       }
       if(this.y <= 0){
           this.vy = -vy;
       }
   }
    public void reset(){
       this.x = rx;
       this.y = ry;
       this.vy = 2;
       this.vx = -1;
    }
}
