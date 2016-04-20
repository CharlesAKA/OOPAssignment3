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
}
