package ie.dit;

import processing.core.*;


public class Background {
	int next;
	PApplet papplet;
	
	Background(PApplet p) {
		papplet = p;
		next = 0;
	}

	// changing background every specific distance reach
	public void render(int dist, PImage[] bgs) {
		if (dist > 1000 || dist < 1000) {
			papplet.image(bgs[0], papplet.width / 2, papplet.height / 2);
			next = 1;
		}
		if (dist > 2500 && next == 1) {
			papplet.image(bgs[1], papplet.width / 2, papplet.height / 2);
			next = 2;
		}
		if (dist > 4000 && next == 2) {
			papplet.image(bgs[2], papplet.width / 2, papplet.height / 2);
			next = 3;
		}
		if (dist > 8000 && next == 3) {
			papplet.image(bgs[3], papplet.width / 2, papplet.height / 2);
		}
	}
}
