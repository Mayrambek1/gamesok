import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.*;


class Canvas extends JPanel{
	int indexI;
	int indexJ;
	int [][] desk;
	int level=1;
	
	
	Image Player;
	Image Box;
	Image Wall;
	Image Mark;

	
	Canvas(){
		
		IPlayer();
		setBackground(Color.lightGray);
		desk = new int [][]{
			{2,2,2,2,2,2,2,2,2,2},
			{2,0,0,0,0,0,0,0,0,2},
			{2,0,1,0,3,0,0,5,4,2},
			{2,0,0,0,4,0,0,0,0,2},
			{2,0,0,0,0,0,0,4,0,2},
			{2,0,0,4,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,2},
			{2,0,0,0,0,0,0,0,0,2},
			{2,2,2,2,2,2,2,2,2,2},
		};
	indexI=2;
	indexJ=2;
	desk[indexI][indexJ]=1;

    }
	public void paint(Graphics g) {
	super.paint(g);

	int a = 20;
	int b = 20;


	for(int i = 0; i < desk.length; i++) {
	a = 20;
	    for(int j = 0; j < desk[i].length; j++) {

		if(desk[i][j] == 0) {
		   g.setColor(Color.white);
		   g.fillRect(a, b, 50, 50);
		}
		if(desk[i][j] == 1) {
		   g.setColor(Color.yellow);
		   g.fillRect(a, b, 50, 50);
		   g.drawImage(Player, a, b, 50, 50, null);
		}

		if(desk[i][j] == 2) {
		   g.setColor(Color.red);
		   g.fillRect(a, b, 50, 50);
		}
		if(desk[i][j] == 3) {
		   g.setColor(Color.yellow);
		   g.fillRect(a, b, 50, 50);
		   g.drawImage(Box, a, b, 50, 50, null);
		}
		if(desk[i][j] == 4) {
		   g.setColor(Color.red);
		   g.fillRect(a, b, 50, 50);
		   g.drawImage(Wall, a, b, 50, 50, null);
		}
		if(desk[i][j] == 5) {
		   g.setColor(Color.red);
		   g.fillRect(a, b, 50, 50);
		   g.drawImage(Mark, a, b, 50, 50, null);
		}


		a = a + 53;
		}
		b = b + 53;
	}
print();	
	}
	
	public void move(String direction){
		if(direction=="Right"){
			moveRight();
		}


	}
		public void moveRight(){
        if (desk[indexI][indexJ + 1] == 4 || desk[indexI][indexJ + 1] == 2 ||
            (desk[indexI][indexJ + 1] == 3 && desk[indexI][indexJ + 2] == 2) ||
                (desk[indexI][indexJ + 1] == 3 && desk[indexI][indexJ + 2] == 4))
				{
           // return;
        } 
		else if(desk[indexI][indexJ + 1]==3 && desk[indexI][indexJ + 2]==5){
			desk[indexI][indexJ] = 0;
            indexJ = indexJ + 1;
            desk[indexI][indexJ] = 1;
			level=level+1;
			loadLevel(level);
			
		}
		else if (desk[indexI][indexJ + 1] == 0) {
            desk[indexI][indexJ] = 0;
            indexJ = indexJ + 1;
            desk[indexI][indexJ] = 1;

        } else if (desk[indexI][indexJ + 1] == 3) {
            desk[indexI][indexJ] = 0;
            desk[indexI][indexJ + 2] = 3;
            indexJ = indexJ + 1;
            desk[indexI][indexJ] = 1;
        }

	}
	
	public void print(){
		System.out.println();
		System.out.println();
		for(int i = 0; i < desk.length; i++) {
			for(int j = 0; j < desk[i].length; j++) {
				System.out.print(desk[i][j]+" ");
			}
		System.out.println();
		}
	}
	public void IPlayer(){
		File imagePlayer = new File("images/Meat.png");
		File imageBox = new File("images/Box.png");
		File imageWall = new File("images/Wall.png");
		File imageMark = new File("images/Mark.png");

		try{
			Player=ImageIO.read(imagePlayer);
			Box=ImageIO.read(imageBox);
			Wall=ImageIO.read(imageWall);
			Mark=ImageIO.read(imageMark);
	

		}catch(IOException e){
			System.out.println(e);
		}
	}
// load method
   private void loadLevel(int value) {

        int row = 0;
        int column = 0;

        BufferedReader inputStream = null;

        boolean d = true;


        try {
            inputStream = new BufferedReader(new FileReader("Levels/Level" + value + ".ume"));


            String l;
            while ((l = inputStream.readLine()) != null) {


                if (d) {
                    column = l.length() / 2;
                    d = false;

                }


                row++;
            }


            inputStream.close();


        } catch (IOException e) {

	    System.out.println(e);

        }


        desk = new int[row][column];


        FileReader inputStream1 = null;


        try {
            inputStream1 = new FileReader("Levels/Level" + value + ".ume");


            int c;
            row = 0;
            column = 0;
            while ((c = inputStream1.read()) != -1) {

                char symbol = (char) c;
                if ('0' <= symbol & symbol <= '9') {
                    Integer t = Integer.parseInt("" + symbol);
                    desk[row][column] = t;
                    if (t == 1) {
                        indexI = row;
                        indexJ = column;
                    }
                    column++;
                }

                if (symbol == '\n') {

                    row++;
                    column = 0;


                }

            }
            inputStream1.close();


        } catch (IOException e) {

	 //  System.out.println(e);

        }
    }

		
}
