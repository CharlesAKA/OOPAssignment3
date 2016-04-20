class Item
{
  float x;
  float y;
  
  int speed;
  int Cwidth;
  int Cheight;
  Item()
  {
    Cwidth = 30;
    Cheight = 20;
  }
  
  //create an item spring boost player speed
  void render()
  {
    fill(0);
    image(imgs[4], x+10, y+10);
    this.x+=speed;
    if (this.x > width)
    {
      speed = -speed;
    }
    
    if (this.x < 0)
    {
      speed = speed*-1;
    }
  }
  
  void Position(float x,float y,int speed)
  {
    this.x = x;
    this.y = y;
    this.speed = speed;
  }
}