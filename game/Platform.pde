class Platform
{
  PVector position;
  float x;
  float y;
  int Pradius;
  int Pwidth;
  int Pheight;
  color Pcolor;
  int dir;
  int speed;
  int next;

  Platform()
  {
    dir = -5;
    Pradius = 5;
    Pwidth = 60;
    Pheight = 20;
    Pcolor = color(47, 120, 64);
    speed = 0;
    next = 0;
  }

  Platform(int spd)
  {
    dir = -5;
    Pradius = 5;
    Pwidth = 60;
    Pheight = 20;
    Pcolor = color(47, 120, 64);
    speed = spd;
    next = 0;
  }

  //creates grass platform and cloud platform when specific distance reach 
  void update()
  {
    fill(Pcolor);
    rect(x, y, Pwidth, Pheight, Pradius );

    if (dist > 4000 || dist < 4000 )
    {
      image(imgs[2], x+32, y+7, imgs[2].width+10, imgs[2].height+10);
      next = 1;
    }

    if (dist > 4000 && next == 1)
    {
      image(imgs[3], x+32, y+7, imgs[2].width+10, imgs[2].height+10);
    }

    this.x +=speed;
    if (this.x > width)
    {
      speed = -speed;
    }
    if (this.x < 0)
    {
      speed = speed*-1;
    }
  }

  void Position(float x, float y)
  {
    this.x = x;
    this.y = y;
  }
}
