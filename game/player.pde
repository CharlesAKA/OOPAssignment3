class Player
{
  float radius;
  PVector position;
  int dir;
  boolean moveUp;
  int floating;
  int health;
  int up;
  
  Player()
  {
    dir = 5;
    radius = 15;
    moveUp = false;
    floating = 0;
    health = 5;
    up = 10;
    position = new PVector(width/2, height/2);
  }
  
   void update()
  {
    stroke(0);
    fill(0);

    if (!moveUp)
    {
      position.y += dir;
      image(imgs[1], position.x, position.y);
    }

    if (moveUp)
    {

      player.floating ++;
      position.y -= up;
      image(imgs[0], position.x, position.y);
    }

    fill(255);
    text("Health: " + health, 10, 60);
    println("ball y"+position.y);
    println(moveUp);
    println(floating);
    control();

    if (position.y > height)
    {
      position.y = height/2;
      health--;
    }
    if (position.x > width)
    {
      position.x = 15;
    }
    if (position.x < 15)
    {
      position.x = width;
    }
  }
  
  
  void control()
  {

    if (keyPressed)
    {
      if (key == 'a' || key == 'A')
      {
        position.x -= 4;
      }

      if (key == 'd' || key == 'D')
      {
        position.x += 4;
      }
    }
  }
}
}
