import java.util.Random;

public class Fruit extends Thread implements Runnable {
		//tablica ze wszystkimi mo¿liwymi wartoœciami planszy na wspó³rzêdnej x
		private int[] xPos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
				325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 
				700, 725, 750, 775, 800, 825, 850};
		
		//tablica ze wszystkimi mo¿liwymi wartoœciami planszy na wspó³rzêdnej y
		private int[] yPos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
				325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
		
		//zmienna s³u¿aca do generowania liczb losowych
		private Random random = new Random();	
		
		//wspó³rzêdne owoca
		public int x;
		public int y;
		
		//uruchomienie w¹tku generuje pozycjê owoca 
		public void run()
		{
			x = xPos[random.nextInt(34)];
			y = yPos[random.nextInt(23)];
		}
}
