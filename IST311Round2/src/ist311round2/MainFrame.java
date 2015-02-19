/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nml5182
 */

import java.util.*;
import javax.swing.JFrame;
public class MainFrame extends JFrame
{
    SplashPanel theSplashUI;
    
    public MainFrame()
    {
        showSplashUI();
        showMainMenuUI(); 
        
    }
    
    public void showSplashUI() {
        
        
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
        GamePanel theGamePanel = new GamePanel(this);
        this.getContentPane().add(theGamePanel);
        pack();
    }
    
  
}
