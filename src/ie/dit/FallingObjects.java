package ie.dit;

import processing.core.*;

public class FallingObjects {
	int speed;
	float x;
	float y;
	int size;
	int c;
	PApplet papplet;
	// creates random object with random speed and size
	FallingObjects(PApplet p) {
		papplet = p;
		speed = (int) papplet.random(1, 10);
		size = (int) papplet.random(15, 30);
		c = papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255));
	}

	public void render() {
		papplet.fill(c);
		papplet.ellipse(x, y, size, size);
		y += speed;
	}

	public void position(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
