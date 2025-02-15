/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author CSchafer
 */
public class Player {
   private int height, width, x, y, vy, score;
   private Rectangle bounds;
   private String pu;
   private boolean isDouble;
   private Color color;
   private int speed = 5;
   private boolean alive;
   
    public Player(int cWidth, int cHeight){
       this.alive = true;
       this.x = 700;
       this.y = cHeight /2;
       this.width = 30;
       this.height = 200;
       this.vy = 0;
       this.color = Color.YELLOW;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
       this.pu = "";
    }
    
    public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g;
       g2d.fill(bounds);  
    }

    public int getY() {
        return this.y;
    }
    
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    void stop() {
       vy = 0;
    }
    
    public void increasePoints(){
        if(this.isDouble){
            this.score +=2;
        }
        else{
            this.score +=1;
        }
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void setPU(String inp){
       inp = this.pu;
    }
    //set power up
    public void powerUpApply(){
        if(this.pu.equals("speedUp")){
            this.speed = 8;
        }
        if(this.pu.equals("freeze")){
          stop();  
        }
        if(this.pu.equals("Double")){
         this.isDouble = true;
        }
        if(this.pu.equals("mini")){
         this.height = 50;   
        }
    }
    
    public void update(){
       this.y +=vy;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }
    
    //movment
    public void move(String direction){
    if(direction.equals("up")){
           this.vy = -speed;
        }
      else if(direction.equals("down")){
           this.vy = speed;
        }
    }
}
