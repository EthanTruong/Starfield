NormalParticle[] jo = new NormalParticle[100];

void setup() {
    size(500, 500);
    for(int i = 0; i < jo.length; i++) {
        jo[i] = new NormalParticle();
    }
}

void draw() {
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
        velocity = (Math.random()/1.5);
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