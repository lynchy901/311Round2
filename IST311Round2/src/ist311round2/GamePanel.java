
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Timer;

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
    JLabel timerLabel = new JLabel();
    int time = 90;
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
        this.add(timerLabel);        
        
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theStopButtonActionPerformed(evt);
            }
        });
        
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (time >= 0 ) {
                    
                    time -= 1;
                    timerLabel.setText(time + "");
                
                }
            }
            
        };
        
        //Timer timer = new Timer(1000, listener);
        //timer.start();
        
    }
    
    public void theStopButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
        
    }
    
    public void setScore(int scoreChange) {
        this.currScore += scoreChange;
        score.setText(currScore + "");
    }
}
