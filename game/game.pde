//Global arraylist and variables
ArrayList platforms;
ArrayList fallobjects;
Background background;

void setup()
{
  smooth();
  background(255);
  size(500, 700);
  background = new Background();
  platforms = new ArrayList();
  fallobjects = new ArrayList();
  initializePlatforms();
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

//Initialising the first platforms when game starts
void initializePlatforms()
{
  for (int i = 0; i < 24; i+=2 )
  {
    Platform platform = new Platform();
    platform.Position( random(0, 450), i * 30);
    platforms.add(platform);
  }
}



//display platforms
void displayPlatform()
{
  //calculations when to start the platform to move
  //creation for the illusion of player moving up
  if (player.position.y <= height/2)
  { 
    player.position.y = height/2;
  }
  if (player.floating == boost)
  {
    player.floating = 0;
    player.moveUp = false;
    boost = 23;
    fast = 10;
    player.up = 10;
  }

  if (player.moveUp && player.position.y <= height/2)
  {
    for (int i = 0; i < items.size(); i++)
    {
      Item item = (Item) items.get(i);
      item.y += fast;
    }
    
    //creating and removing platforms
    for (int i = 0; i < platforms.size(); i++)
    {

      dist++;
      Platform p = (Platform) platforms.get(i);
      p.update();
      p.y += fast;

      if (p.y >= 750)
      {
        platforms.remove(p);

        int r, speed;
        r = (int)random(0, 2);

        if (dist < 500)
        {
          r = 0;
        }

        if (r == 0)
        {
          Platform platform = new Platform();
          platform.Position( random(0, 450), i * 30);
          platforms.add(platform);
        }
        if (r == 1 && dist >= 500)
        {
          speed = (int) random(0, 3);
          Platform platform = new Platform(speed);
          platform.Position( random(0, 450), i * 30);
          platforms.add(platform);
        }
      }
    }
  }
}
}
//INITIALIZE FALLING OBJECT
void Fallingobjects()
{

  //initialize every 1.5s and when dist = 1000
  if (frameCount % 45 == 0 && dist >= 1000) 
  {
    FallingObjects f = new FallingObjects();
    f.position( random(50, 450), 0 );
    fallobjects.add(f);
  }
 
  //creating, removing and display falling objects
  for (int i = 0; i < fallobjects.size(); i++)
  {
    FallingObjects fo = (FallingObjects) fallobjects.get(i);
    fo.render();

    if (player.moveUp && player.position.y <= height/2)
    {
      fo.y += fast;
    }

    if (fo.y >= 750)
    {
      fallobjects.remove(fo);
    }

    //collision for player and fallobjects
    if (player.position.x + 30 >= fo.x &&
      player.position.x  <= (fo.x + fo.size) &&
      player.position.y + 30 >= fo.y &&
      player.position.y  <= (fo.y +fo.size))
    {
      fallobjects.remove(fo);
      player.health--;
    }
  }
}