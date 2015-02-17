
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nml5182
 */
public class MainMenu extends JPanel {
  
    //start game button,
    private JButton startButton;
    private JComboBox difficulty;
    private JLabel picture;
    private String[] difficulties = {"Easy", "Medium", "Hard"};
    private MainFrame parentMainFrame;
    
    
    public MainMenu(MainFrame newMainFrame) {
        parentMainFrame = newMainFrame;
        initComponents();
        setVisible(true);
    }
    
    public void initComponents() {
        //this.setLayout(new GridLayout(2, 0));
        startButton = new JButton("Start");
        difficulty = new JComboBox(difficulties);
        this.add(startButton);
        this.add(difficulty);
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(200, 200));
        revalidate();
        repaint();
        
        startButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        theStartButtonActionPerformed(evt);
                    }
                });
    }
    
    
    public void theStartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        parentMainFrame.showGameUI();
        
    }
}
