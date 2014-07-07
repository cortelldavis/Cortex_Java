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
public class Cortex_Java {

   public static void main(String args[]) {

		View vw = new View();

		boolean running = true;
		while (running) {
			vw.setDisplay(ResourceLoader.getImage("img.png"));			
			running = false;
		}
	}
}
