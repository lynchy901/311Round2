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
    public MainFrame()
    {
        SplashPanel theSplashUI = new SplashPanel();
        this.add(theSplashUI);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
}
