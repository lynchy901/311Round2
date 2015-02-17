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
        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
        
        try {
            Thread.sleep(10000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        theSplashUI.setVisible(false);
    }
    
    public void showMainMenuUI() {
        MainMenu theMainMenu = new MainMenu();
        this.getContentPane().add(theMainMenu);
        pack();
    }
    
  
}
