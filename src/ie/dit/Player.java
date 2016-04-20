package ie.dit;

import processing.core.*;

public class Player {
	float radius;
	PVector position;
	int dir;
	boolean moveUp;
	int floating;
	int health;
	int up;
	PApplet papplet;
	
	Player(PApplet p) {
		papplet = p;
		dir = 5;
		radius = 15;
		moveUp = false;
		floating = 0;
		health = 5;
		up = 10;
		position = new PVector(papplet.width / 2, papplet.height / 2);
	}

	public void update(PImage[] imgs) {
		papplet.stroke(0);
		papplet.fill(0);

		if (!moveUp) {
			position.y += dir;
			papplet.image(imgs[1], position.x, position.y);
		}

		if (moveUp) {

			floating++;
			position.y -= up;
			papplet.image(imgs[0], position.x, position.y);
		}

		papplet.fill(255);
		papplet.text("Health: " + health, 10, 60);
//		println("ball y" + position.y);
//		println(moveUp);
//		println(floating);
		control();

		if (position.y > papplet.height) {
			position.y = papplet.height / 2;
			health--;
		}
		if (position.x > papplet.width) {
			position.x = 15;
		}
		if (position.x < 15) {
			position.x = papplet.width;
		}
	}

	public void control() {

		if (papplet.keyPressed) {
			if (papplet.key == 'a' || papplet.key == 'A') {
				position.x -= 4;
			}

			if (papplet.key == 'd' || papplet.key == 'D') {
				position.x += 4;
			}
		}
	}
}
