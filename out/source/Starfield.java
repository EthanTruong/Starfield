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

NormalParticle[] jo = new NormalParticle[100];

public void setup() {
    
    for(int i = 0; i < jo.length; i++) {
        jo[i] = new NormalParticle();
    }
}

public void draw() {
    noStroke();
    fill(10, 10, 10, 30);
    rect(0, 0, width, height);
    for(int i = 0; i < jo.length; i++) {
        jo[i].move();
        jo[i].display();
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
    }
    public void display() {
        fill(255);
        noStroke();
        ellipse((float)x, (float)y, 10, 10);
    }
}

class OddballParticle { //uses an interface
    //your code here
}

class JumboParticle { //uses inheritance
    //your code here
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
