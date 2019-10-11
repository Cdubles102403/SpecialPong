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
 * @author CSchafer
 */

/**
 *1.) speed up
 * 2.) player freeze
 * 3.)double points
 * 4.)player mini
 */
public class PowerUp {
    private int  width, x, y;
    private String current;
    private Rectangle bounds;
    private Color color;
    private String[] powerups = new String[4];
    public PowerUp(int cWidth, int cHeight){
       this.x =(int) (Math.random() *470) + 50; 
       this.y = (int) (Math.random() *370) + 50;
       this.width = 30;
       this.color = Color.green;
       this.bounds = new Rectangle(this.x, this.y, this.width, this.width);
       this.powerups[0] = "speedUp";
       this.powerups[1] = "freeze";
       this.powerups[2] = "Double";
       this.powerups[3] = "mini";
       this.current = "";
    }
    
   public void draw(Graphics g){
       g.setColor(this.color);
       Graphics2D g2d = (Graphics2D) g;
       g2d.fillOval(x,y,width,width);  
    }
   
    public void update(){
       this.bounds = new Rectangle(this.x, this.y, this.width, this.width);
    }
    
    public String getPU(){
        return this.current;
    }
    
       //pick power up
    public void picker(){
       double num = (int) (Math.random()*4);
       if(num == 0){
           this.current = powerups[0];
       }
       if(num == 1){
           this.current = powerups[1];
       }
       if(num == 2){
           this.current = powerups[2];
       }
       if(num ==3){
           this.current = powerups[3];
       }
    }
    public void reset(){
       this.x =(int) (Math.random() *470) + 50; 
       this.y = (int)(Math.random() *370) + 50;
       picker();
    }
    public Rectangle getBounds() {
       return bounds;
    }
}
