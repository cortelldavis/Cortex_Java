/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

/**
 *
 * @author agent
 */
public class Cortex_Client {

    public static void main(String args[]) {
        Renderer r = new Renderer();
        View vw = new View();
        vw.setDisplayImage(r.renderAndGetNewScene());
        
        Control control = new Control();
        System.out.println("no keys pressed");

        //if key has been pressed, print the key that was pressed
        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(control);
        
       
        
    }
}
