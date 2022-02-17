import javax.swing.*;
import java.awt.*;

class Game{
	
Game(){
	Canvas canvas = new Canvas();
	canvas.setBounds(15,15,650,600);
	
	Listener listen = new Listener(canvas);	
	
	JFrame window = new JFrame();
	window.setSize(700,800);
	window.setLocation(100,100);
	window.setLayout(null);
	window.setTitle("Sokoban");
	window.add(canvas);
	window.addKeyListener(listen);
	
	window.setVisible(true);
}
}