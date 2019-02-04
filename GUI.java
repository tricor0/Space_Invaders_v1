import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI implements KeyListener {

  private JTextArea textArea1;
  private JTextField textField1;
  private int playerAction = 0; //0 = no action; -1 = i kaire; 1 = i desine; 2 = sauti

  public GUI() {
    this.playerAction = playerAction;
  }

  public void changeArea(String langas){
    textArea1.setText(langas);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
      playerAction = -1;
    }

    if (key == KeyEvent.VK_RIGHT) {
      playerAction = 1;
    }

    if (key == KeyEvent.VK_SPACE) {
      playerAction = 2;
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
