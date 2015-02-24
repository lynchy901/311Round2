
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nml5182
 */
public class GamePanel extends JPanel implements ActionListener {
    
    private MainFrame parentMainFrame;
    JButton stopButton = new JButton("Stop");
    JLabel scoreLabel = new JLabel("Score: ");
    JLabel score = new JLabel("0");
    JLabel timerLabel = new JLabel();
    JLabel instructionLabel = new JLabel("       Choose as many prime numbers as you can before the time runs out! Press any key to begin");
    int time = 30;
    private int currScore = 0;
    Timer timer;
    
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
        this.add(timerLabel);
        this.add(instructionLabel);
        timerLabel.setText("    Time: " + time);
        timer = new Timer(1000, this);
        
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theStopButtonActionPerformed(evt);
            }
        });
    }
    
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        
        if (obj == timer) {
            time--;
            timerLabel.setText("    Time: " + time);
            parentMainFrame.theGameGrid.checkWin();
        }
            
    }
    
    public void theStopButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
        
    }
    
    public void setScore(int scoreChange) {
        this.currScore += scoreChange;
        score.setText(currScore + "");
    }
}
