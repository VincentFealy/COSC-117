import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class CircleClass {
	private int center_x;
	private int center_y;
	private int radius;
	private int velocity_x;
	private int velocity_y;
	private Color color;
	
	public CircleClass(int maxX, int maxY) {
		
		Random rand = new Random();
		center_x = rand.nextInt(maxX + 1);
		center_y = rand.nextInt(maxY + 1);
		
		velocity_x = rand.nextInt(8) - 2;
		velocity_y = rand.nextInt(8) - 2;
		
		radius = rand.nextInt(11);

		float R = rand.nextFloat();
		float G = rand.nextFloat();
		float B = rand.nextFloat();
		color = new Color(R, G, B);
	}

	public void move(int maxX, int maxY) {
		if((center_x + velocity_x > maxX) || (center_x + velocity_x < 0)) {
			velocity_x *= -1;
		}
		if((center_y + velocity_y > maxY) || (center_y + velocity_y < 0)) {
			velocity_y *= -1;
		}
		center_x += velocity_x;
		center_y += velocity_y;
	}
	
	public void playerMove(int maxX, int maxY, int dir) {
		if(dir == 0) {
			if(center_y + velocity_y > maxY) {
			} else {
				center_y += velocity_y;
			}
		} else if(dir == 1) {
			if(center_y - velocity_y <= 0) {
			} else {
				center_y -= velocity_y;
			}
		} else if(dir == 2) {
			if(center_x - velocity_x <= 0) {
			} else {
				center_x -= velocity_x;
			}
		} else if(dir == 3) {
			if(center_x + velocity_x > maxX) {
			} else {
				center_x += velocity_x;
			}
		}
	}
	
	public void draw(Graphics canvas) {
		canvas.setColor(color);
		canvas.fillOval(center_x, center_y, radius, radius);
	}
	//The distance formula would not properly work but i tried to improvise.
	public boolean overlapsWith(CircleClass other) {
		int distSq = (center_x - other.center_x) * (center_x - other.center_x) + (center_y - other.center_y) * (center_y - other.center_y);
		int radSumSq = (radius + other.radius) * (radius + other.radius);
		
		if(distSq < radSumSq) {
			return true;
		}
		return false;
	}
	
	public void setSize(int s) {
		radius = s;
	}
	
	public int getSize() {
		return radius;
	}
	
	public void centerPlayer(int x, int y) {
		center_x = x;
		center_y = y;
	}
	
	public void setVelocity(int v) {
		velocity_x = v;
		velocity_y = v;
	}
}
