
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

    private JLabel picture = new JLabel();
    private JLabel welcome = new JLabel("Welcome!");
    private ImageIcon theSplashImage;
    MainFrame parentMainFrame;
    
  

    public SplashPanel(MainFrame newMainFrame) {
     
     parentMainFrame = newMainFrame;
     theSplashImage = new ImageIcon(this.getClass().getResource("image.gif"));
     picture.setIcon(theSplashImage);
     theSplashImage.setImageObserver(picture);
     //System.out.println(this.getClass().getResource("splash.jpg"));    
     this.add(welcome);
     this.add(picture);
    }
}
