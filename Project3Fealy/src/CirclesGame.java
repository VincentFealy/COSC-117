/**
 * Vincent Fealy
 * project 3 '
 * in this project i used the already implemented game starter code to create the circle game
 * Using past projects to get the circles to move correctly
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *  This file can be used to create very simple animations.  Just fill in
 *  the definition of drawFrame with the code to draw one frame of the 
 *  animation, and possibly change a few of the values in the rest of
 *  the program as noted below. Note that if you change the name of the
 *  class, you must also change the name in the main() routine!
 */
public class CirclesGame extends JPanel implements ActionListener, KeyListener {
  // track the current frame number being drawn
  private int frameNum;

  // Set the parameters of the game window
  private static int FRAME_width = 1000;
  private static int FRAME_height = 1000;

  // Add any additional "global" game variables here
  private ArrayList<CircleClass> ambient = new ArrayList<CircleClass>();
  private ArrayList<CircleClass> food = new ArrayList<CircleClass>();
  
  private CircleClass player;
  private boolean gameOver = false;

  // Note: this is the constructor, must match the class name
  public CirclesGame(){
    // These commands use the ActionListener and KeyListener features
    // to take keyboard input events and process them
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);

    // Put any other code that you want to run at the start of the game here
    // This will get run when the main function creates a new GameStarter class
    for(int i = 0; i < 10; i ++) {
    	ambient.add(new CircleClass(FRAME_width, FRAME_height));
    }
    for(int i = 0; i < 50; i++) {
    	food.add(new CircleClass(FRAME_width, FRAME_height));
    }
    player = new CircleClass(FRAME_width, FRAME_height);
    player.centerPlayer(FRAME_width/3, FRAME_height/2);
    player.setSize(20);
    player.setVelocity(10);
  }

  /**
   * Draws one frame of an animation. This subroutine is called re
   * second and is responsible for redrawing the entire drawing area.  The
   * parameter g is used for drawing. The frameNumber starts at zero and
   * increases by 1 each time this subroutine is called.  The parameters width
   * and height give the size of the drawing area, in pixels.  
   * The sizes and positions of the rectangles that are drawn depend
   * on the frame number, giving the illusion of motion.
   */
  public void drawFrame(Graphics g, int frameNumber, int width, int height) {
    // Add code to update the state of the game based on the simulation parameters
    // You'll have to calculate the positions of all the new blobs, as well as the new
    // player position. Then, check for any collisions or absorptions. You can also
    // test to see if the game needs to stop or not and then render an ending screen/message

    // Add code here to process the next state of the game...

    // Next, draw the new state of the game. Keep in mind that you can pass the "Graphics g"
    // parameter to other objects' methods and let them draw themselves on the canvas.
    // For example, if you have a global "player" variable, you can say player.draw(g)
    // to have the player render itself onto the screen

    // This will print a small counter to the bottom of the screen so that the
    // user can see when the frame updates.
    g.setColor(Color.BLACK);
    g.drawString("Frame counting at: "+frameNumber, width-600, height-600);
    for (int i = 0; i < ambient.size(); i++) {
    	ambient.get(i).draw(g);
    	ambient.get(i).move(width, height);
    	for (int j = 0; j < food.size(); j++) {
    		if(ambient.get(i).overlapsWith(food.get(j))) {
    			if(ambient.get(i).getSize() > food.get(j).getSize()) {
    				food.remove(j);
    				ambient.get(i).setSize(ambient.get(i).getSize() + 1);
    			} else if(ambient.get(i).getSize() < food.get(j).getSize()) {
    				ambient.remove(i);
    				food.get(j).setSize(food.get(j).getSize() + 1);
    			}
    		}
    	}
    	ambient.get(i).draw(g);
    }
    for (int i = 0; i < food.size(); i++) {
    	food.get(i).setSize(8);
    	food.get(i).draw(g);
    }
    player.draw(g);
    for (int i = 0; i < ambient.size(); i++) {
    	if(player.overlapsWith(ambient.get(i))) {
    		if(ambient.get(i).getSize() > player.getSize()) {
    			gameOver = true;
				g.drawString("Game is over, You Lost!", width/2, height/2);
			} else if(ambient.get(i).getSize() < player.getSize()) {
				ambient.remove(i);
				player.setSize(player.getSize() + 1);
			}
    	}
    }
    for (int i = 0; i < food.size(); i++) {
    	if(player.overlapsWith(food.get(i))) {
    		if(food.get(i).getSize() > player.getSize()) {
				gameOver = true;
			} else if(food.get(i).getSize() < player.getSize()) {
				food.remove(i);
				player.setSize(player.getSize() + 1);
			}
    	}
    }
    player.draw(g);
    if(gameOver) {
    	g.drawString("Game is over, You Lost!", width/2, height/2);
    }
    if(food.isEmpty() && ambient.isEmpty()) {
    	g.drawString("Game is over, You Won!", width/2, height/2);
    }
    
  }

  /**
   * This function runs whenever a user presses the keyboard.
   * Use it to control the logic of the Player in the game.
   */
  public void keyTyped(KeyEvent evt){
    // Print out the key typed as an example of how to get information about the keyTyped event
    System.out.println("You pressed: " + evt.getKeyChar());
    if(!gameOver) {
		if(evt.getKeyChar() == 'w') {
			player.playerMove(FRAME_width, FRAME_height, 1);
		} else if(evt.getKeyChar() == 's') {
			player.playerMove(FRAME_width, FRAME_height, 0);
		} else if(evt.getKeyChar() == 'a') {
			player.playerMove(FRAME_width, FRAME_height, 2);
		} else if(evt.getKeyChar() == 'd') {
			player.playerMove(FRAME_width, FRAME_height, 3);
		}
    }
  }

  /* You should not need to modify anything below here unless you're changing the name of the class */


  //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------
  // You should not need to modify the main function. But it could be helpful
  // to try reading through it and looking at the Java documentation
  // to see what it is doing and why.
  public static void main(String[] args) {
    /* NOTE:  The string in the following statement goes in the title bar
     * of the window.
     */
    JFrame window = new JFrame("Game Starter");

    /*
     * NOTE: If you change the name of this class, you must change
     * the name of the class in the next line to match!
     */
    CirclesGame drawingArea = new CirclesGame();

    // Set up a blank drawing area
    drawingArea.setBackground(Color.WHITE);
    window.setContentPane(drawingArea);

    /* NOTE:  In the next line, the numbers 600 and 450 give the
     * initial width and height of the drawing array.  You can change
     * these numbers to get a different size.
     */
    drawingArea.setPreferredSize(new Dimension(FRAME_width,FRAME_height));

    window.pack();
    window.setLocation(100,50);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    /*
     * Note:  In the following line, you can change true to
     * false.  This will prevent the user from resizing the window,
     * so you can be sure that the size of the drawing area will
     * not change.  It can be easier to draw the frames if you know
     * the size.
     */
    window.setResizable(true);

    /* NOTE:  In the next line, the number 20 gives the time between
     * calls to paintComponent().  The time is given in milliseconds, where
     * one second equals 1000 milliseconds.  You can increase this number
     * to get a slower animation.  You can decrease it somewhat to get a
     * faster animation, but the speed is limited by the time it takes
     * for the computer to draw each frame. 
     */
    Timer frameTimer = new Timer(20,drawingArea);

    window.setVisible(true);
    frameTimer.start();

  } // end main


  // This function is what drives the graphic drawing.
  // You should not need to modify this.
  public void actionPerformed(ActionEvent evt) {
    frameNum++;
    repaint();

    // Need this on linux to force a sync.
    // Otherwise, will stutter unless the mouse is moving
    getToolkit().sync();
  }

  // Calls the drawFrame function, you should not need to modify this
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawFrame(g, frameNum, getWidth(), getHeight());
  }


  // These are needed for the override, but you should use keyTyped instead to
  // handle input events.
  public void keyPressed(KeyEvent evt){ }
  public void keyReleased(KeyEvent evt){ }
}