
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
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
        
        if (selectedButton >= 0 && selectedButton < arraySize) {
            selectedButton += ((arraySize-1) * arraySize);
        } else {
            selectedButton -= arraySize;
        }
        buttonArray.get(selectedButton).setBackground(Color.yellow);
        
    }
    
    public void moveRight() {
        System.out.println("right");
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
        
        for (int i = 0; i < arraySize; i++) {
            if (selectedButton == (arraySize-1) + arraySize*i) {
                    
                    selectedButton = selectedButton - (arraySize-1);                
                    flag = true;
                    break;
                
            }      
        }
        if (flag == false) {
            
            selectedButton += 1;  
        } 
        flag = false;
        buttonArray.get(selectedButton).setBackground(Color.yellow);
    }
    
    public void moveLeft() {
        System.out.println("left");
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
        
        for (int i = 0; i < arraySize; i++) {
            if (selectedButton == arraySize*i) {
                    
                    selectedButton = selectedButton + (arraySize-1);                
                    flag = true;
                    break;
                
            }      
        }
        if (flag == false) {
            
            selectedButton -= 1;  
        } 
        flag = false;
        buttonArray.get(selectedButton).setBackground(Color.yellow);
        
    }
    
    public void moveDown() {
        System.out.println("down");
        
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
        
        if (selectedButton >= (arraySize*(arraySize-1)) && selectedButton < (arraySize*(arraySize-1)) + (arraySize)) {
            selectedButton -= ((arraySize-1) * arraySize);
        } else {
            selectedButton += arraySize;
        }
        buttonArray.get(selectedButton).setBackground(Color.yellow);
    }
   
    

}
