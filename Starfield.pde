void setup() {
    size(500, 500);
}

void draw() {
	//your code here
}

interface Particle{
    public void display();
    public void move();
}

class NormalParticle implements Particle {
    public void display() {
  
    }  
    public void move() {
    
    }
}

class OddballParticle implements Particle {
  	public void display() {
  
    } 
    public void move() {
    
    }
}

class JumboParticle extends NormalParticle {
    public void display() {
  
    }
    public void move() {
    
    }
}
