
import java.awt.Color;
import java.awt.Dimension;
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
    
    
    public MainMenu() {
        initComponents();
        setVisible(true);
    }
    
    public void initComponents() {
        startButton = new JButton("Start");
        difficulty = new JComboBox(difficulties);
        this.add(startButton);
        this.add(difficulty);
        this.setPreferredSize(new Dimension(900, 900));
        revalidate();
        repaint();
    }
}
