
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
public class ButtonArray extends JPanel {
    
    private ArrayList<JButton> buttonArray = new ArrayList<JButton>();
    private int primeSelections = 0;
    int selectedButton = 0;
    int arraySize;
    boolean flag = false;
    JLabel instructionLabel = new JLabel("Select as many prime numbers as you can before the time runs out!");
    MainFrame parentMainFrame;
    JButton testButton = new JButton();
    
    
    public ButtonArray(int arraySize, MainFrame parentMainFrame) {
        this.parentMainFrame = parentMainFrame;
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
                this.buttonArray.get(i).setFocusable(false);
            }
            if (primeSelections == 0) {
                
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
        
        if (checkPrime(value)) {
            primeSelections++;
        }
        
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
        LineBorder correctBorder = new LineBorder(Color.GREEN, 12);
        LineBorder incorrectBorder = new LineBorder(Color.RED, 12);
        int currNum = Integer.parseInt(buttonArray.get(selectedButton).getText());
        
        if (!checkPrime(currNum)) {
            
            if (buttonArray.get(selectedButton).getBorder().equals(testButton.getBorder()) ) {
                
                parentMainFrame.getGamePanelControl().setScore(-5);
            }
            buttonArray.get(selectedButton).setBorder(incorrectBorder);
                
        } else {
            if (buttonArray.get(selectedButton).getBorder().equals(testButton.getBorder()) ) {
                
                parentMainFrame.getGamePanelControl().setScore(5);
                
                if (primeSelections != 0) {
                    primeSelections--;
                }
            }
            buttonArray.get(selectedButton).setBorder(correctBorder);
            checkWin();
        } 
        
    }
    
    public void neutralizeButton() {
        buttonArray.get(selectedButton).setBackground(testButton.getBackground());
    }
    
    public void selectButton() {
        buttonArray.get(selectedButton).setBackground(Color.YELLOW);
    }
   
    public boolean checkPrime(int currNum) {
        
        
        boolean prime = true;
        
        if (currNum == 1 || currNum == 2) {
        
        } else {
   
            for (int i = 2; i < currNum; i++) {
                if (currNum % i == 0) {
                    prime = false;
                }
            }
        }
        return prime;
    }
      
    public void checkWin() {
        if (primeSelections == 0 || parentMainFrame.theGamePanel.time <= 0) {
            parentMainFrame.theGamePanel.timer.stop();
            if (primeSelections == 0) { 
            
                JOptionPane.showMessageDialog(this, "Game Over! Your score is: " + parentMainFrame.theGamePanel.score.getText());  
                
           } else {
               
               JOptionPane.showMessageDialog(this, "Time is up, your score is: " + parentMainFrame.theGamePanel.score.getText());
               
           }
            
            parentMainFrame.theGameGrid.setVisible(false);
            parentMainFrame.theGamePanel.setVisible(false);
            selectedButton = 0;
            System.exit(0);
            
        }
    }
    
    public int getPrimeSelections() {
        return primeSelections;
    }



}
