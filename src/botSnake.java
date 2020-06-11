
public class botSnake extends Thread implements Runnable {
	
	//tablice do przechowywania wspó³rzêdnych x, y ka¿dej czêœci wê¿a 
	public int[] botXLength = new int[750];
	public int[] botYLength = new int[750];
	
	//zmienna przechowuj¹ca aktualny wynik uzyskany przez bota
	public int botScore = 0;
	
	//zmienne logiczne wskazuj¹ce stronê poruszania siê bota
	public boolean botLeft = false;
	public boolean botRight = false;
	public boolean botUp = false;
	public boolean botDown = false;
	
	//zmienna przechowuj¹ca d³ugoœæ wê¿a bota
	public int lengthOfBot = 3;
	
	//uruchomienie w¹tku ustawia wê¿a w odpowiedniej pozycji
	public void run()
	{
		botXLength[0] = 450;
		botXLength[1] = 475;
		botXLength[2] = 500;
		
		botYLength[2] = 500;
		botYLength[1] = 500;
		botYLength[0] = 500;
	}
	
	
	//algorytm sterowania wê¿em przez AI
	// argument x - ró¿nica miêdzy wspó³rzêdn¹ x wê¿a, a owoca
	// argument y - ró¿nica miêdzy wspó³rzêdn¹ y wê¿a, a owoca
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
	
	//algorytm sterowania wê¿em przez AI
	// gorsza wersja
	public void snakeAI(int x, int y)
	{
		if(Math.abs(x) > Math.abs(y))
		{
			//jeœli ró¿nica wspó³rzêdnej x wê¿a i owocu jest ujemna to w¹¿ musi poruszaæ siê w prawo
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
			//jeœli ró¿nica wspó³rzêdnej x wê¿a i owocu jest dodatnie to w¹¿ musi poruszaæ siê w lewo
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
			//jeœli ró¿nica wspó³rzêdnej y wê¿a i owocu jest ujemna to w¹¿ musi poruszaæ siê w dó³
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
			//jeœli ró¿nica wspó³rzêdnej y wê¿a i owocu jest dodatnia to w¹¿ musi poruszaæ siê w górê
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
