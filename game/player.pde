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
}
