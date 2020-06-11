import java.util.Random;

public class Fruit extends Thread implements Runnable {
		//tablica ze wszystkimi mo�liwymi warto�ciami planszy na wsp�rz�dnej x
		private int[] xPos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
				325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 
				700, 725, 750, 775, 800, 825, 850};
		
		//tablica ze wszystkimi mo�liwymi warto�ciami planszy na wsp�rz�dnej y
		private int[] yPos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
				325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
		
		//zmienna s�u�aca do generowania liczb losowych
		private Random random = new Random();	
		
		//wsp�rz�dne owoca
		public int x;
		public int y;
		
		//uruchomienie w�tku generuje pozycj� owoca 
		public void run()
		{
			x = xPos[random.nextInt(34)];
			y = yPos[random.nextInt(23)];
		}
}
