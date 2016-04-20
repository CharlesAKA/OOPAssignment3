void setup()
{
  smooth();
  background(255);
  size(500, 700);
  frameRate(30);
  
  //set in setup to only initialise once
  imageMode(CENTER);
 
 //load images
  PImage[] imgs = new PImage[5];
  PImage[] bgs = new PImage[5]; 
  
   //image of player and platform
  imgs[0] = loadImage("qwe.png");
  imgs[1] = loadImage("qwe2.png");
  imgs[2] = loadImage("grass.png");
  imgs[3] = loadImage("cloud.png");
  imgs[4] = loadImage("spring.png");
  //image for background 
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
