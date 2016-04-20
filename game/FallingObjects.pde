class FallingObjects
{
  int speed;
  float x;
  float y;
  int size;
  int c;
  
    //creates random object with random speed and size
  FallingObjects()
  {
    speed = (int)random(1,10);
    size = (int)random(15,30);
    c = color(random(0,255),random(0,255),random(0,255));
  }
  void render()
  {
    fill(c);
    ellipse(x,y,size,size);
    y += speed;
  }
  
  void position(float x, float y)
  {
    this.x = x;
    this.y = y;
  }

}