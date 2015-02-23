/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nml5182
 */

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
    SplashPanel theSplashUI;
    GamePanel theGamePanel;
    ButtonArray theGameGrid;
    
    public MainFrame()
    {
        showSplashUI();
        showMainMenuUI(); 
        
    }
    
    public void showSplashUI() {
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setLayout(new BorderLayout());
        theSplashUI = new SplashPanel(this);
        this.add(theSplashUI);
        this.setSize(450, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        try {
            Thread.sleep(4000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        theSplashUI.setVisible(false);
        
        
        
    }
    
    public void showMainMenuUI() {
        MainMenu theMainMenu = new MainMenu(this);
        this.getContentPane().add(theMainMenu);
        pack();
    }
    
    public void showGameUI() {
        theGamePanel = new GamePanel(this);
        this.getContentPane().add(theGamePanel, "North");
        pack();
    }
    
    public GamePanel getGamePanelControl() {
        return theGamePanel;
    }
    
    public void showGameGrid(String grid) {
        int gridSize = 0;
        
        if (grid.equals("4x4")) {
            gridSize = 4;
        } else if (grid.equals("5x5")) {
            gridSize = 5;
        } else if (grid.equals("6x6")) {
            gridSize = 6;
        } else if (grid.equals("7x7")) {
            gridSize = 7;
        } else if (grid.equals("8x8")) {
            gridSize = 8;
        } else if (grid.equals("9x9")) {
            gridSize = 9;
        } else if (grid.equals("10x10")) {
            gridSize = 10;
        }
        
        theGameGrid = new ButtonArray(gridSize, this);
        this.getContentPane().add(theGameGrid);
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        
        this.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 38) {
                //up
                 theGameGrid.moveUp();   
                } else if (e.getKeyCode() == 39) {
                 //right
                    theGameGrid.moveRight(); 
                } else if (e.getKeyCode() == 40) {
                //down
                    theGameGrid.moveDown(); 
                } else if (e.getKeyCode() == 37) {
                //left
                    theGameGrid.moveLeft(); 
                } else if (e.getKeyCode() == 32) {
                    theGameGrid.selectCell();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
  
}
