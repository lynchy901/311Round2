
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
    JButton stopButton = new JButton("Stop");
    JLabel scoreLabel = new JLabel("Score: ");
    JLabel score = new JLabel("0");
    private int currScore = 0;
    
    public GamePanel(MainFrame newMainFrame) {
        parentMainFrame = newMainFrame;
        this.setSize(900, 900);
        initComponents();
    }
    
    public void initComponents() {
        this.setVisible(true);
        this.add(stopButton);
        this.add(scoreLabel);
        this.add(score);
        
    }
    
    public void setScore(int scoreChange) {
        this.currScore += scoreChange;
        score.setText(currScore + "");
    }
}
