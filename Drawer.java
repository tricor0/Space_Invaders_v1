import java.util.List;

public class Drawer {

  public String Draw(List<Entity> entityList) {
    String line = "#############/n";
    for(int y = 14; y > -1; y--){
      for(int x = 0; x < 13; x--){
        for(Entity obj : entityList){
          if(checkLocation(obj, x, y)){
            line += getType(obj);
          } else {
            line += ".";
          }
        }
      }
      line += "/n";
    }
    return line;

  }
  private boolean checkLocation(Entity obj, int x, int y){
    if((obj.GetX() == x) && (obj.GetY() == y)){
      return true;
    }
    return false;
  }


  private char getType(Entity obj) {
    String className = obj.getClass().getName();
    switch (className) {
      case "Enemy":
        return 'H';

      case "Player":
        return '@';

      case "Wall":
        return '#';

      case "Shot":
        return '|';

    }
    return '^';
  }

}
