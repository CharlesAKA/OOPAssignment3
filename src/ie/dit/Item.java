package ie.dit;

import processing.core.*;

public class Item {
	float x;
	float y;

	int speed;
	int Cwidth;
	int Cheight;
	PApplet papplet;
	
	Item(PApplet p) {
		papplet = p;
		Cwidth = 30;
		Cheight = 20;
	}

	// create an item spring boost player speed
	public void render(PImage[] imgs) {
		papplet.fill(0);
		papplet.image(imgs[4], x + 10, y + 10);
		this.x += speed;
		if (this.x > papplet.width) {
			speed = -speed;
		}

		if (this.x < 0) {
			speed = speed * -1;
		}
	}

	public void Position(float x, float y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
}
