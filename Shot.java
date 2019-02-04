public class Shot implements Entity {
  private int positionX, positionY, state;//0 = player made; 1 = enemy
  public Shot(int x, int y, String creator) {
    positionX = x;
    positionY = y;
    if(creator.equals("player")){
      state = 0;
    } else {
      state = 1;
    }
  }

  @Override
  public void Move() {
    if(state == 0){
      positionY++;
    }
    if(state == 1){
      positionY--;
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
