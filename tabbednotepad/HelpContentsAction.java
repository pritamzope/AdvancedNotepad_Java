import java.awt.*;
import javax.swing.*;
public class HelpContentsAction extends JFrame
{
    Image image;
  public HelpContentsAction()
  {
      Container cp=getContentPane();
      JLabel lb=new JLabel("Advanced Tabbed Notepad in Java");
      lb.setFont(new Font("SansSerif",Font.PLAIN,22));

      JPanel jp=new JPanel();
      jp.add(lb);

      MyPanel mp=new MyPanel();

      cp.add(jp,BorderLayout.NORTH);
      cp.add(mp,BorderLayout.CENTER);

  }

  class MyPanel extends JPanel
  {
      public MyPanel()
      {
          image=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/tabbednotepad.png"));

      }
      public void paintComponent(Graphics g)
      {
          super.paintComponent(g);
          g.drawImage(image, 0,0, null);
      }
  }
}
