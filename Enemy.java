public class Enemy implements Entity{

  private int positionX, positionY, moveIterator = 0, shootIterator, directionCounter = 0, isShooting = 0;
  private boolean direction = true;

  public Enemy(int i, int i1, int i2) {
    positionX = i;
    positionY = i1;
    shootIterator = i2;
  }



  @Override
  public void Move() {
    moveIterator++;
    shootIterator++;

    if(moveIterator == 3){
      moveIterator = 0;
      if(direction){
        positionX++;
        directionCounter++;
      }
      if(!direction){
        positionX--;
        directionCounter++;
      }
      if(directionCounter == 4){
        direction = !direction;
        positionY--;
        directionCounter = 0;
      }
    }
    if(shootIterator == 15){
      shootIterator = 0;
      isShooting = 1;
    }
  }

  @Override
  public int GetX() {
    return positionX;
  }

  @Override
  public int GetY() {
    return positionY;
  }

  @Override
  public int GetState() {
    return isShooting;
  }

  @Override
  public void SetState(int state) {
    isShooting = state;
  }
}
