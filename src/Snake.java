
public class Snake extends Thread implements Runnable {
	//tablice do przechowywania wsp�rz�dnych x, y ka�dej cz�ci w�a
	public int[] snakeXLength = new int[750];
	public int[] snakeYLength = new int[750];
	//zmienna przechowuj�ca aktualny wynik u�ytkownika
	public int score = 0;
	//zmienne logiczne wskazuj�ce stron� poruszania si� w�a
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	//zmienna przechowuj�ca rozmiar w�a
	public int lengthOfSnake = 3;
	
	//po uruchomieni w�tek ustawia w�a w pocz�tkowej pozycji
	public void run()
	{
		snakeXLength[2] = 50;
		snakeXLength[1] = 75;
		snakeXLength[0] = 100;
		
		snakeYLength[2] = 100;
		snakeYLength[1] = 100;
		snakeYLength[0] = 100;
	}
	
	//metoda sprawdzaj�ca czy w�� nie zderzy� si� ze �cian� i zwracaj�ca odpowiedni� warto�� logiczn�
	public boolean hitTheWall()
	{
		if(snakeXLength[0] > 850 || snakeXLength[0] < 25 || snakeYLength[0] > 625 || snakeYLength[0] < 75)
		{
			right = false;
			left = false;
			up = false;
			down = false;
			
			return true;
			}
		else 
			return false;
	}
		
	//metoda sprawdzaj�ca czy w�� nie zjad� swojej cz�ci i zwracaj�ca odpowiedni� warto�� logiczn�
	public boolean eatItself()
	{
		for(int i=1; i<lengthOfSnake; i++)
		{
			if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0])
			{
				right = false;
				left = false;
				up = false;
				down = false;
				return true;
			}
		}
		return false;
	}	
	
	//zmiana warto�ci logicznych dla ruchu w prawo
	public void pressRightKey()
	{
		right = true;
		if(!left)
		{
			right = true;
		}
		else
		{
			right = false;
			left = true;
		}
		up = false;
		down = false;
	}
	//zmiana warto�ci logicznych dla ruchu w lewo
	public void pressLeftKey()
	{
		left = true;
		if(!right)
		{
			left = true;
		}
		else
		{
			left = false;
			right = true;
		}
		up = false;
		down = false;
	}
	//zmiana warto�ci logicznych dla ruchu w g�r�
	public void pressUpKey()
	{
		up = true;
		if(!down)
		{
			up = true;
		}
		else
		{
			up= false;
			down = true;
		}
		left = false;
		right = false;
	}
	//zmiana warto�ci logicznych dla ruchu w d�
	public void pressDownKey()
	{
		down = true;
		if(!up)
		{
			down = true;
		}
		else
		{
			down = false;
			up = true;
		}
		left = false;
		right = false;
	}
}
