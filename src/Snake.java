
public class Snake extends Thread implements Runnable {
	//tablice do przechowywania wspó³rzêdnych x, y ka¿dej czêœci wê¿a
	public int[] snakeXLength = new int[750];
	public int[] snakeYLength = new int[750];
	//zmienna przechowuj¹ca aktualny wynik u¿ytkownika
	public int score = 0;
	//zmienne logiczne wskazuj¹ce stronê poruszania siê wê¿a
	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;
	//zmienna przechowuj¹ca rozmiar wê¿a
	public int lengthOfSnake = 3;
	
	//po uruchomieni w¹tek ustawia wê¿a w pocz¹tkowej pozycji
	public void run()
	{
		snakeXLength[2] = 50;
		snakeXLength[1] = 75;
		snakeXLength[0] = 100;
		
		snakeYLength[2] = 100;
		snakeYLength[1] = 100;
		snakeYLength[0] = 100;
	}
	
	//metoda sprawdzaj¹ca czy w¹¿ nie zderzy³ siê ze œcian¹ i zwracaj¹ca odpowiedni¹ wartoœæ logiczn¹
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
		
	//metoda sprawdzaj¹ca czy w¹¿ nie zjad³ swojej czêœci i zwracaj¹ca odpowiedni¹ wartoœæ logiczn¹
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
	
	//zmiana wartoœci logicznych dla ruchu w prawo
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
	//zmiana wartoœci logicznych dla ruchu w lewo
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
	//zmiana wartoœci logicznych dla ruchu w górê
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
	//zmiana wartoœci logicznych dla ruchu w dó³
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
