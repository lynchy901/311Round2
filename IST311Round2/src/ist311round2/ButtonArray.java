
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
        
        //this generates button array
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
        selectButton();
        
        
        
    }
    
    public JButton createButton(int x) {
        int value;
        value = (int)((Math.random())* 100 + 1);
        JButton tmpJButton = new JButton(value + "");
        return tmpJButton;
    }
    
    public void moveUp() {
        System.out.println("up");
        neutralizeButton();
        
        if (selectedButton >= 0 && selectedButton < arraySize) {
            selectedButton += ((arraySize-1) * arraySize);
        } else {
            selectedButton -= arraySize;
        }
        selectButton();
        
    }
    
    public void moveRight() {
        System.out.println("right");
        neutralizeButton();
        
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
        selectButton();
    }
    
    public void moveLeft() {
        System.out.println("left");
        neutralizeButton();
        
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
        selectButton();
        
    }
    
    public void moveDown() {
        System.out.println("down");
        
        neutralizeButton();
        
        if (selectedButton >= (arraySize*(arraySize-1)) && selectedButton < (arraySize*(arraySize-1)) + (arraySize)) {
            selectedButton -= ((arraySize-1) * arraySize);
        } else {
            selectedButton += arraySize;
        }
        selectButton();
    }
    
    public void selectCell() {
        Border correctBorder = new LineBorder(Color.GREEN, 12);
        Border incorrectBorder = new LineBorder(Color.RED, 12);
        
        int currNum = Integer.parseInt(buttonArray.get(selectedButton).getText());
        boolean prime = true;
        
        if (currNum == 1 || currNum == 2) {
        
        }else{
   
            for (int i = 2; i < currNum; i++) {
                if (currNum % i == 0) {
                    prime = false;
                }
            }
        }
        
        if (prime == false) {
            buttonArray.get(selectedButton).setBorder(incorrectBorder);
        } else {
            buttonArray.get(selectedButton).setBorder(correctBorder);
        }
        
    }
    
    public void neutralizeButton() {
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
    }
    
    public void selectButton() {
        buttonArray.get(selectedButton).setBackground(Color.YELLOW);
    }
   
    

}
