import java.lang.invoke.SwitchPoint;

public class Player implements Entity{

  private int positionX, positionY, playerState;



  public Player(int i, int i1) {
    positionX = i;
    positionY = i1;
  }

  @Override
  public void Move() {
    switch (playerState) {
      case 1:
        if(positionX != 12) positionX++;
        break;
      case -1:
        if(positionX != 0) positionX--;
        break;
      case 2:

        break;
      default:
        break;
    }
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
