
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class ButtonArray extends JPanel {
    
    private ArrayList<JButton> buttonArray = new ArrayList<JButton>();
    int selectedButton = 0;
    int arraySize;
    boolean flag = false;
    JButton testButton = new JButton();
    
    public ButtonArray(int arraySize) {
        this.arraySize = arraySize;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setLayout(new GridLayout(arraySize, arraySize));
        this.setPreferredSize(new Dimension(900, 900));
        this.setSize(900, 900);
        
        if (arraySize > 0 ) {
            for (int i = 0; i < (arraySize*arraySize); i++) {
                buttonArray.add(createButton(i));
                this.add(buttonArray.get(i));
            }
        }
        this.setVisible(true);
        initComponents();
        
        
    }
    
    public void initComponents() {
        buttonArray.get(selectedButton).setBackground(Color.yellow);
        
        
        
    }
    
    public JButton createButton(int x) {
        JButton tmpJButton = new JButton(x + " ");
        return tmpJButton;
    }
    
    public void moveUp() {
        System.out.println("up");
        
    }
    
    public void moveRight() {
        System.out.println("right");

        for (int i = 0; i < arraySize; i++) {
            if (selectedButton == (arraySize-1) + arraySize*i) {
                if (selectedButton == (arraySize-1) + arraySize*(arraySize-1)) {
                    
                    buttonArray.get(selectedButton).setBackground(testButton.getBackground());
                    selectedButton = 0;
                    flag = true;
                    break;
                } else {
                    //System.out.println("the current position is " + selectedButton);
                    buttonArray.get(selectedButton).setBackground(testButton.getBackground());
                    selectedButton = arraySize* (i+1);
                    //System.out.println("Move the selection to " + selectedButton);                
                    flag = true;
                    break;
                }
            }      
        }
        if (flag == false) {
            
            buttonArray.get(selectedButton).setBackground(testButton.getBackground());
            selectedButton += 1;
           //buttonArray.get(selectedButton).setBackground(Color.yellow);    
        } 
        flag = false;
        buttonArray.get(selectedButton).setBackground(Color.yellow);
    }
    
    public void moveLeft() {
        System.out.println("left");
    }
    
    public void moveDown() {
        System.out.println("down");
    }
   
    

}
