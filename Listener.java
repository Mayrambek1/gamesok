import java.awt.event.KeyListener;
import java.awt.event.*;

class Listener implements KeyListener{
	Canvas canvas;
	
	Listener(Canvas canvas){
		this.canvas=canvas;
	}
	public void keyTyped(KeyEvent e){
	}
	
	public void keyPressed(KeyEvent e){
	int code=e.getKeyCode();
	System.out.println(code);
	if(code == 39){
       canvas.move("Right");
	}

	/*if(code == 37){
       canvas.move("Left");
	}
	if(code == 40){
       canvas.move("Down");
	}
	if(code == 38){
       canvas.move("Up");
	}*/

	canvas.repaint();
	}

    
	public void keyReleased(KeyEvent e){
	}

}