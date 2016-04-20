class Background
{
  int next;
  Background()
  {
    next = 0;
  }

  //changing background every specific distance reach
  void render()
  {
    if (dist > 1000 || dist < 1000 )
    {
      image(bgs[0], width/2, height/2 );
      next = 1;
    }
    if (dist > 2500  && next == 1)
    {
      image(bgs[1], width/2, height/2 );
      next = 2;
    }
    if (dist > 4000  && next == 2)
    {
      image(bgs[2], width/2, height/2 );
      next = 3;
    }
    if (dist > 8000  && next == 3)
    {
      image(bgs[3], width/2, height/2 );
    }
  }
}