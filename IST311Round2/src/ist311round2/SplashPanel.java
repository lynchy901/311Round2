
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nml5182
 */
public class SplashPanel extends JPanel {

    JLabel title;

    private JLabel picture = new JLabel("TEST");
    private ImageIcon theSplashImage;
    MainFrame parentMainFrame;
    
  

    public SplashPanel(MainFrame newMainFrame) {
     
     parentMainFrame = newMainFrame;
     
     theSplashImage = new ImageIcon(this.getClass().getResource("image.gif"));
     //System.out.println(this.getClass().getResource("splash.jpg"));       

    }

    @Override
   public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        System.out.println("test");
        g.drawImage(theSplashImage.getImage(),0,0,null);
    }
}
