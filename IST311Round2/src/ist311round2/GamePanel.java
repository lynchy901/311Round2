
import java.awt.Color;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nml5182
 */
public class GamePanel extends JPanel {
    
    private MainFrame parentMainFrame;
    
    public GamePanel(MainFrame newMainFrame) {
        parentMainFrame = newMainFrame;
        
        initComponents();
    }
    
    public void initComponents() {
        this.setVisible(true);
        
        this.setBackground(Color.yellow);
    }
}
