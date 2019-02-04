public class Wall implements Entity{

  private int positionX, positionY;

  public Wall(int i, int i1) {
    positionX = i;
    positionY = i1;
  }

  @Override
  public void Move() {

  }

  @Override
  public int GetX() {
    return 0;
  }

  @Override
  public int GetY() {
    return 0;
  }

  @Override
  public int GetState() {
    return 0;
  }

  @Override
  public void SetState(int state) {

  }
}
