import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle[] AntimonyParticles = new Particle[100];
int r = (int)(Math.random()*256);
int g = (int)(Math.random()*256);
int b = (int)(Math.random()*256);

public void setup() {
    
    for(int i = 0; i < AntimonyParticles.length; i++) {
        if(i % 6 == 0) {
            AntimonyParticles[i] = new JumboParticle();
        } else {
            AntimonyParticles[i] = new NormalParticle();
        }
    }
    AntimonyParticles[0] = new OddballParticle();
}

public void mousePressed() {
    setup();
    r = (int)(Math.random()*256);
    g = (int)(Math.random()*256);
    b = (int)(Math.random()*256);
}

public void draw() {
    noStroke();
    fill(10, 10, 10, 30);
    rect(0, 0, width, height);
    for(int i = 0; i < AntimonyParticles.length; i++) {
        AntimonyParticles[i].move();
        AntimonyParticles[i].display();
    }
}

interface Particle {
    public void move();
    public void display();
}

class NormalParticle implements Particle {
    double x, y, angle, velocity;
    NormalParticle() {
        x = width/2;
        y = height/2;
        angle = Math.random()*Math.PI*2;
        velocity = (Math.random()/1.5f);
      }
    public void move() {
        x += Math.cos(angle) / velocity;
        y += Math.sin(angle) / velocity; 
        velocity -= 0.01f;
    }
    public void display() {
        fill(255);
        noStroke();
        ellipse((float)x, (float)y, 10, 10);
    }
}

class OddballParticle implements Particle { //uses an interface
    double x, y, velocity;
    OddballParticle() {
        x = width/2;
        y = height/2;
        velocity = Math.random()*10;
      }
    public void move() {
        x += ((int)(Math.random() * 5) - 2) * velocity;
        y += ((int)(Math.random() * 5) - 2) * velocity; 
    }
    public void display() {
        fill(255 - r, 255 - g, 255 - b);
        noStroke();
        rect((float)x, (float)y, 25, 25);
    }
}

class JumboParticle extends NormalParticle { //uses inheritance
    double x, y, angle, velocity;
    JumboParticle() {
        x = width/2;
        y = height/2;
        angle = Math.random()*Math.PI*2;
        velocity = (Math.random()/1.5f);
      }
    public void move() {
        x += Math.cos(angle) / velocity;
        y += Math.sin(angle) / velocity; 
        //velocity -= 0.01;
    }
    public void display() {
        fill(r, g, b);
        noStroke();
        ellipse((float)x, (float)y, 25, 25);
    }
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
