import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Engine {
  private List<Entity> entityList = new ArrayList<>(Populate());
  Drawer draw = new Drawer();
  GUI gui = new GUI();
  private int playerAction = 0; //0 = no action; -1 = i kaire; 1 = i desine; 2 = sauti
//  List<Entity> list = new List<Entity> ();
  public Engine() {

    Run(Populate());
  }
  private List<Entity> Populate(){
    List<Entity> entityList = new ArrayList<>();
    entityList.add(new Player(6, 0));

    entityList.add(new Enemy(3, 14, 0));
    entityList.add(new Enemy(7, 14, 1));
    entityList.add(new Enemy(10, 14, 2));
    entityList.add(new Enemy(4, 12, 3));
    entityList.add(new Enemy(8, 12, 4));

    entityList.add(new Wall(2, 4));
    entityList.add(new Wall(3, 4));
    entityList.add(new Wall(9, 4));
    entityList.add(new Wall(10, 4));

    return entityList;
  }

  private void Run(List<Entity> entityList){
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        Update();
        String langas;
        langas = draw.Draw(entityList);
        gui.changeArea(langas);

      }
    }, 500,1000*2*60);

  }

  private boolean Update(){
      boolean isGame = true;
      for (Entity obj: entityList) {
        obj.Move();
        String className = obj.getClass().getName();
        switch (className) {
          case "Enemy":
            if(obj.GetState()==1) {
              CreateBullet(obj.GetX(), obj.GetY()-1, "enemy");
              obj.SetState(0);
            }

            break;
          case "Shot":
            int x = obj.GetX();
            int y = obj.GetY();
            for(int i = 0; i < entityList.size(); i++){
              if((x == entityList.get(i).GetX()) || (y == entityList.get(i).GetY()) || (obj.getClass().toString() != "Shot")){
                if((obj.GetState() == 1) && (entityList.get(i).getClass().getName() != "Enemy")){
                  entityList.remove(i);
                  for(int k = 0; k<entityList.size();k++){
                    String classId = obj.getClass().getName();
                    if((entityList.get(k).GetX() == x) && (entityList.get(k).GetY() == y) && (classId.equals("Shot"))){
                      entityList.remove(k);
                    }
                  }
                }
                if((obj.GetState() == 0) && (entityList.get(i).getClass().getName() != "Player")){
                  entityList.remove(i);
                  for(int k = 0; k<entityList.size();k++){
                    String classId = obj.getClass().getName();
                    if((entityList.get(k).GetX() == x) && (entityList.get(k).GetY() == y) && (classId.equals("Shot"))){
                      entityList.remove(k);
                    }
                  }
                }
              }

            }
            break;
          case "Player":
            obj.SetState(playerAction);
            if(playerAction == 2){
              CreateBullet(obj.GetX(), obj.GetY()+1, "player");
            }

            playerAction = 0;

            break;
          case "Wall":

            break;
        }
      }
      return isGame;

    }

  private void CreateBullet(int x, int y, String creator) {
    entityList.add(new Shot(x, y, creator));
  }



}

