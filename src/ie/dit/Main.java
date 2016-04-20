package ie.dit;

import processing.core.*;
import java.util.ArrayList;;

public class Main extends PApplet {

	// Use for main menu
	int state = 0;
	final int Main_menu = 0;
	final int Instructions = 1;
	final int Game = 2;
	final int Pause = 3;
	final int Continue = 4;
	final int Game_over = 5;

	// Global arraylist and variables
	ArrayList<Platform> platforms = new ArrayList<Platform>();
	ArrayList<FallingObjects> fallobjects = new ArrayList<FallingObjects>();
	ArrayList<Item> items = new ArrayList<Item>();

	Player player;
	Background background;
	boolean hit = false;
	float currentY = 0;
	PImage[] imgs = new PImage[5];
	PImage[] bgs = new PImage[5];
	int dist; // distance equals score
	int boost; // make player float longer
	int fast; // use for player to go faster

	public void settings() {
		size(500, 700);
	}

	// Initialise of variables
	public void setup() {
		smooth();
		background(255);
		size(500, 700);
		player = new Player(this);
		background = new Background(this);
		// platforms = new ArrayList();
		// fallobjects = new ArrayList();
		// items = new ArrayList();
		initializePlatforms();
		frameRate(30);
		dist = 0;
		boost = 23;
		fast = 10;

		// set in setup to only initialise once
		imageMode(CENTER);
		// image of player and platform
		imgs[0] = loadImage("qwe.png");
		imgs[1] = loadImage("qwe2.png");
		imgs[2] = loadImage("grass.png");
		imgs[3] = loadImage("cloud.png");
		imgs[4] = loadImage("spring.png");
		// image for background
		bgs[0] = loadImage("dirtq.PNG");
		bgs[1] = loadImage("skygrad.jpg");
		bgs[2] = loadImage("Starry-Night-Sky.jpg");
		bgs[3] = loadImage("space_galaxy_blue_wallpaper_by_thegoldenbox-d6kfnkl.png");
		bgs[4] = loadImage("images.jpg");
		bgs[0].resize(width, height);
		bgs[1].resize(width, height);
		bgs[2].resize(width, height);
		bgs[3].resize(width, height);
		bgs[4].resize(width, height);
	}

	public void draw() {
		// Main menu choices
		switch (state) {
		case Main_menu:
			background(bgs[4]);
			text("MENU:\n\n1.To see instructions press 1\n2.To play the game press 2\n3.To pause the game presss 3\n4.To continue press 4\n5.To return to main menu press 0",
					10, 100);
			break;
		case Game:
			background(255);
			background.render(dist, bgs);
			collision();
			displayPlatform();
			Fallingobjects();
			items();
			player.update(imgs);
			textSize(15);
			fill(255);
			text("Distance: " + dist, 10, 30);
			break;
		case Instructions:
			background(bgs[4]);
			text("INSTRUCTIONS:\n\n1.Use the 'A' and 'D' keys to move left and right\n2.The objective of the game is to avoid the obstacles\n and try and get to the next level",
					10, 100);
			break;
		case Pause:
			text("GAME PAUSED!!Press 4 to continue\bSCORE: " + dist, width / 2 - 200, height / 2 + 20);
			break;
		case Continue:

			break;
		case Game_over:
			text("GAME OVER!!   Press 2 to play again\nSCORE: " + dist, width / 2 - 150, height / 2 + 20);
			break;
		}
		if (key == '0') {
			state = 0;
		}
		if (key == '1') {
			state = 1;
		}
		if (key == '2') {
			state = 2;
		}
		if (key == '3') {
			state = 3;
		}
		if (key == '4') {
			state = 2;
		}
		if (player.position.y > 700 || player.health <= 0) {
			state = 5;
			if(key=='2')
			{
				player = new Player(this);
				background = new Background(this);
//				platforms = new Platform(this);
//				fallobjects = new FallingObjects(this);
//				items = new Item(this);
//				initializePlatforms();
				frameRate(30);
				dist = 0; // distance equals score
				 boost =23; // make player float longer
				fast = 10; // use for player to go faster
			
				
			}
		}
	}

	// Initialising the first platforms when game starts
	public void initializePlatforms() {
		for (int i = 0; i < 24; i += 2) {
			Platform platform = new Platform(this);
			platform.Position(random(0, 450), i * 30);
			platforms.add(platform);
		}
	}

	public void displayPlatform() {
		// calculations when to start the platform to move
		// creation for the illusion of player moving up
		if (player.position.y <= height / 2) {
			player.position.y = height / 2;
		}
		if (player.floating == boost) {
			player.floating = 0;
			player.moveUp = false;
			boost = 23;
			fast = 10;
			player.up = 10;
		}

		if (player.moveUp && player.position.y <= height / 2) {
			for (int i = 0; i < items.size(); i++) {
				Item item = (Item) items.get(i);
				item.y += fast;
			}

			// creating and removing platforms
			for (int i = 0; i < platforms.size(); i++) {

				dist++;
				Platform p = (Platform) platforms.get(i);
				p.update(dist, imgs);
				p.y += fast;

				if (p.y >= 750) {
					platforms.remove(p);

					int r, speed;
					r = (int) random(0, 2);

					if (dist < 500) {
						r = 0;
					}

					if (r == 0) {
						Platform platform = new Platform(this);
						platform.Position(random(0, 450), i * 30);
						platforms.add(platform);
					}
					if (r == 1 && dist >= 500) {
						speed = (int) random(0, 3);
						Platform platform = new Platform(speed);
						platform.Position(random(0, 450), i * 30);
						platforms.add(platform);
					}
				}
			}
		}
	}

	// INITIALIZE FALLING OBJECT
	public void Fallingobjects() {

		// initialize every 1.5s and when dist = 1000
		if (frameCount % 45 == 0 && dist >= 1000) {
			FallingObjects f = new FallingObjects(this);
			f.position(random(50, 450), 0);
			fallobjects.add(f);
		}

		// creating, removing and display falling objects
		for (int i = 0; i < fallobjects.size(); i++) {
			FallingObjects fo = (FallingObjects) fallobjects.get(i);
			fo.render();

			if (player.moveUp && player.position.y <= height / 2) {
				fo.y += fast;
			}

			if (fo.y >= 750) {
				fallobjects.remove(fo);
			}

			// collision for player and fallobjects
			if (player.position.x + 30 >= fo.x && player.position.x <= (fo.x + fo.size)
					&& player.position.y + 30 >= fo.y && player.position.y <= (fo.y + fo.size)) {
				fallobjects.remove(fo);
				player.health--;
			}
		}
	}

	public void items() {
		// create a item every 5s
		if (frameCount % 150 == 0) {
			int r;
			r = (int) random(0, platforms.size());
			Platform p = (Platform) platforms.get(r);
			Item item = new Item(this);
			item.Position(p.x + p.Pwidth / 4, p.y - p.Pheight / 2, p.speed);
			items.add(item);
		}

		// display and removing item
		for (int i = 0; i < items.size(); i++) {
			Item item = (Item) items.get(i);
			item.render(imgs);

			if (item.y >= 750) {
				items.remove(i);
			}

			// collision for player and item
			if (player.position.x > item.x && player.position.x < item.x + item.Cwidth && player.moveUp == false) {
				if (player.position.y + player.radius > item.y
						&& player.position.y + player.radius < item.y + item.Cheight) {
					boost = 50;
					fast = 15;
					player.up = 20;
				}
			}
		}
	}

	// collission for player and platform
	public void collision() {
		println(currentY);
		for (int i = 0; i < platforms.size(); i++) {
			Platform p = (Platform) platforms.get(i);
			p.update(dist, imgs);

			// detects top platform
			if (player.position.x > p.x && player.position.x < p.x + p.Pwidth && player.moveUp == false) {
				if (player.position.y + player.radius > p.y && player.position.y + player.radius < p.y + p.Pheight) {
					player.moveUp = true;
					// p.Pcolor = 255;
					currentY = p.y;
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Main());
	}

	
}
