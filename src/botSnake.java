
public class botSnake extends Thread implements Runnable {
	
	//tablice do przechowywania wsp�rz�dnych x, y ka�dej cz�ci w�a 
	public int[] botXLength = new int[750];
	public int[] botYLength = new int[750];
	
	//zmienna przechowuj�ca aktualny wynik uzyskany przez bota
	public int botScore = 0;
	
	//zmienne logiczne wskazuj�ce stron� poruszania si� bota
	public boolean botLeft = false;
	public boolean botRight = false;
	public boolean botUp = false;
	public boolean botDown = false;
	
	//zmienna przechowuj�ca d�ugo�� w�a bota
	public int lengthOfBot = 3;
	
	//uruchomienie w�tku ustawia w�a w odpowiedniej pozycji
	public void run()
	{
		botXLength[0] = 450;
		botXLength[1] = 475;
		botXLength[2] = 500;
		
		botYLength[2] = 500;
		botYLength[1] = 500;
		botYLength[0] = 500;
	}
	
	
	//algorytm sterowania w�em przez AI
	// argument x - r�nica mi�dzy wsp�rz�dn� x w�a, a owoca
	// argument y - r�nica mi�dzy wsp�rz�dn� y w�a, a owoca
	public void moveAI(int x, int y)
	{
		if(x>0 && botRight==false)
		{
	        botLeft = true;
	        botUp= false;
	        botDown = false;
	        for(int i= lengthOfBot-1; i>=0; i--)
			{
				botYLength[i+1] = botYLength[i];
			}
			for(int i= lengthOfBot; i>=0; i--)
			{
				if(i==0)
				{
					botXLength[i] = botXLength[i] - 25;
				}
				else
				{
					botXLength[i] = botXLength[i-1];
				}
			}
	    }
	    else if(x<0 && botLeft==false)
	    {
	        botRight = true;
	        botUp = false;
	        botDown = false;
	        for(int i= lengthOfBot-1; i>=0; i--)
			{
				botYLength[i+1] = botYLength[i];
			}
			for(int i= lengthOfBot; i>=0; i--)
			{
				if(i==0)
				{
					botXLength[i] = botXLength[i] + 25;
				}
				else
				{
					botXLength[i] = botXLength[i-1];
				}
			}
	    }
	    else if(y<0 && botUp==false)
	    {
	        botRight = false;
	        botLeft = false;
	        botDown = true;
	        for(int i= lengthOfBot-1; i>=0; i--)
			{
				botXLength[i+1] = botXLength[i];
			}
			for(int i= lengthOfBot; i>=0; i--)
			{
				if(i==0)
				{
					botYLength[i] = botYLength[i] + 25;
				}
				else
				{
					botYLength[i] = botYLength[i-1];
				}
			}
	    }
	    else if(y>0 && botDown==false)
	    {
	        botRight = false;
	        botLeft = false;
	        botUp = true;
	        for(int i = lengthOfBot-1; i>=0; i--)
			{
				botXLength[i+1] = botXLength[i];
			}
			for(int i= lengthOfBot; i>=0; i--)
			{
				if(i==0)
				{
					botYLength[i] = botYLength[i] - 25;
				}
				else
				{
					botYLength[i] = botYLength[i-1];
				}
			}
	    }
	}
	
	//algorytm sterowania w�em przez AI
	// gorsza wersja
	public void snakeAI(int x, int y)
	{
		if(Math.abs(x) > Math.abs(y))
		{
			//je�li r�nica wsp�rz�dnej x w�a i owocu jest ujemna to w�� musi porusza� si� w prawo
			if(x < 0)
			{
				botRight = true;
				botLeft = false;
				botUp = false;
				botDown = false;
				for(int i= lengthOfBot-1; i>=0; i--)
				{
					botYLength[i+1] = botYLength[i];
				}
				for(int i= lengthOfBot; i>=0; i--)
				{
					if(i==0)
					{
						botXLength[i] = botXLength[i] + 25;
					}
					else
					{
						botXLength[i] = botXLength[i-1];
					}
				}
			}
			//je�li r�nica wsp�rz�dnej x w�a i owocu jest dodatnie to w�� musi porusza� si� w lewo
			if(x > 0)
			{
				botLeft = true;
				botRight = false;
				botUp = false;
				botDown = false;
				for(int i= lengthOfBot-1; i>=0; i--)
				{
					botYLength[i+1] = botYLength[i];
				}
				for(int i= lengthOfBot; i>=0; i--)
				{
					if(i==0)
					{
						botXLength[i] = botXLength[i] - 25;
					}
					else
					{
						botXLength[i] = botXLength[i-1];
					}
				}
			}
		}
		else
		{
			//je�li r�nica wsp�rz�dnej y w�a i owocu jest ujemna to w�� musi porusza� si� w d�
			if(y < 0)
			{
				botRight = false;
				botLeft = false;
				botUp = false;
				botDown = true;
				for(int i= lengthOfBot-1; i>=0; i--)
				{
					botXLength[i+1] = botXLength[i];
				}
				for(int i= lengthOfBot; i>=0; i--)
				{
					if(i==0)
					{
						botYLength[i] = botYLength[i] + 25;
					}
					else
					{
						botYLength[i] = botYLength[i-1];
					}
				}
			}
			//je�li r�nica wsp�rz�dnej y w�a i owocu jest dodatnia to w�� musi porusza� si� w g�r�
			if(y > 0)
			{
				botRight = false;
				botLeft = false;
				botUp = true;
				botDown = false;
				for(int i = lengthOfBot-1; i>=0; i--)
				{
					botXLength[i+1] = botXLength[i];
				}
				for(int i= lengthOfBot; i>=0; i--)
				{
					if(i==0)
					{
						botYLength[i] = botYLength[i] - 25;
					}
					else
					{
						botYLength[i] = botYLength[i-1];
					}
				}
			}
		}
	}
	
}
