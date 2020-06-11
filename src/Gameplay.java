import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener {
	//zmienne s�u��ce do wczytania obraz�w potrzebnych do wizualizcji
	private ImageIcon titleImage;
	private ImageIcon snakeImage;
	private ImageIcon botImage;
	private ImageIcon botHeadImage;
	private ImageIcon fruitImage;
	//zmienne s�u��ce do wczytania obrazu w zale�no�ci od strony poruszania w�a
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	
	//utworzenie obiektu klasy Snake
	private Snake snake = new Snake();
	//utworzenie obiektu klasy botSnake
	private botSnake bot = new botSnake();
	//utworzenie obiektu klasy Fruit
	private Fruit fruit = new Fruit();
	
	
	//zmienna przechowuj�ca liczb� ruch�w
	private int moves = 0;
	//Utworzenie timera
	private Timer timer;
	//zmienna przechowuj�ca warto�� op�znienia
	private int delay = 100;
	
	
	//Konstruktor 
	//Ustawia podstawowe w�asno�ci klasy, tworzy i uruchamia timer
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		fruit = new Fruit();
		fruit.start();
	}
	
	//Metoda odpowiedzialna za rysowanie obiekt�w na planszy
	public void paint(Graphics g)
	{
		if(moves == 0)
		{
			snake = new Snake();
			snake.start();
			bot = new botSnake();
			bot.start();
		}
		
		//rysowanie ramki tytu�owego obrazka
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//rysowanie tyt�owego obrazka
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//rysowanie ramki pola do gry
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//rysowanie t�a pola do gry
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		//rysowanie wyniku gracza
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: "+snake.score, 780, 30);
		g.drawString("USER", 730, 40);
		
		//rysowanie d�ugo�ci w�a gracza
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: "+snake.lengthOfSnake, 780, 50);
		
		//rysowanie wyniku bota 
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: "+bot.botScore, 80, 30);
		g.drawString("BOT", 40, 40);
		
		//rysowanie d�ugo�ci w�a bota
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: "+bot.lengthOfBot, 80, 50);
		
		rightMouth = new ImageIcon("rightmouth.png");
		rightMouth.paintIcon(this, g, snake.snakeXLength[0], snake.snakeYLength[0]);
		
		//ustawienie odpowiednie obrazka dla konkretnych cz�ci w�a u�ytkownika
		//ustawienie g�owy w�a skierowanej w stron�, w kt�r� aktualnie si� porusza
		for(int a=0; a < snake.lengthOfSnake; a++)
		{
			if(a==0 && snake.right)
			{
				rightMouth = new ImageIcon("rightmouth.png");
				rightMouth.paintIcon(this, g, snake.snakeXLength[a], snake.snakeYLength[a]);
			}
			if(a==0 && snake.left)
			{
				leftMouth = new ImageIcon("leftmouth.png");
				leftMouth.paintIcon(this, g, snake.snakeXLength[a], snake.snakeYLength[a]);
			}
			if(a==0 && snake.down)
			{
				downMouth = new ImageIcon("downmouth.png");
				downMouth.paintIcon(this, g, snake.snakeXLength[a], snake.snakeYLength[a]);
			}
			if(a==0 && snake.up)
			{
				upMouth = new ImageIcon("upmouth.png");
				upMouth.paintIcon(this, g, snake.snakeXLength[a], snake.snakeYLength[a]);
			}
			if(a!=0)
			{
				snakeImage = new ImageIcon("snakeimage.png");
				snakeImage.paintIcon(this, g, snake.snakeXLength[a], snake.snakeYLength[a]);
			}
		}
		
		for(int i=0; i<bot.lengthOfBot; i++)
		{
			if(i==0)
			{
				botHeadImage = new ImageIcon("snakeAI_head.png");
				botHeadImage.paintIcon(this, g, bot.botXLength[i], bot.botYLength[i]);
			}
			else
			{
				botImage = new ImageIcon("snakeAI_.png");
				botImage.paintIcon(this, g, bot.botXLength[i], bot.botYLength[i]);
			}
		}
		
		fruitImage = new ImageIcon("enemy.png");
		
		//je�li u�ytkownik zbierze owoc to zwi�ksza si� rozmiar, punkty oraz generowany jest nowy owoc
		if((fruit.x == snake.snakeXLength[0] &&  fruit.y == snake.snakeYLength[0]))
		{
			snake.score++;
			snake.lengthOfSnake++;
			fruit = new Fruit();
			fruit.start();
		}
		//je�li bot zbierze owoc to zwi�ksza si� rozmiar, punkty oraz generowany jest nowy owoc
		if((fruit.x == bot.botXLength[0] && fruit.y == bot.botYLength[0]))
		{
			bot.botScore++;
			bot.lengthOfBot++;
			fruit = new Fruit();
			fruit.start();
		}
		
		fruitImage.paintIcon(this, g, fruit.x, fruit.y);
		
		//je�li u�ytkownik uderzy w �cian� lub zje swojego w�a to wy�wietli si� komunikat ko�ca gry
		if(snake.hitTheWall() || snake.eatItself())
		{
			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);
			
			g.setFont(new Font("arial", Font.BOLD, 20));
			g.drawString("Space to RESTART", 350, 340);
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		
		//generowanie owoca na pocz�tku rozgrywki
		if(moves != 0)
		{
			int x = bot.botXLength[0] - fruit.x;
			int y = bot.botYLength[0] - fruit.y;
			bot.moveAI(x, y);
		}
		//zmiana wsp�rz�dnych podczas poruszania si� w�a w prawo
		if(snake.right)
		{
			for(int i= snake.lengthOfSnake-1; i>=0; i--)
				snake.snakeYLength[i+1] = snake.snakeYLength[i];

			for(int i= snake.lengthOfSnake; i>=0; i--)
			{
				if(i==0)
					snake.snakeXLength[i] = snake.snakeXLength[i] + 25;
				else
					snake.snakeXLength[i] = snake.snakeXLength[i-1];
			}
			repaint();
		}
		
		//zmiana wsp�rz�dnych podczas poruszania si� w�a w lewo
		if(snake.left)
		{
			for(int i= snake.lengthOfSnake-1; i>=0; i--)
				snake.snakeYLength[i+1] = snake.snakeYLength[i];

			for(int i= snake.lengthOfSnake; i>=0; i--)
			{
				if(i==0)
					snake.snakeXLength[i] = snake.snakeXLength[i] - 25;
				else
					snake.snakeXLength[i] = snake.snakeXLength[i-1];
			}
			repaint();
		}
		
		//zmiana wsp�rz�dnych podczas poruszania si� w�a w d�
		if(snake.down)
		{
			for(int i= snake.lengthOfSnake-1; i>=0; i--)
				snake.snakeXLength[i+1] = snake.snakeXLength[i];
			
			for(int i= snake.lengthOfSnake; i>=0; i--)
			{
				if(i==0)
					snake.snakeYLength[i] = snake.snakeYLength[i] + 25;
				else
					snake.snakeYLength[i] = snake.snakeYLength[i-1];
			}
			repaint();	
		}
		
		//zmiana wsp�rz�dnych podczas poruszania si� w�a w g�r�
		if(snake.up)
		{
			for(int i= snake.lengthOfSnake-1; i>=0; i--)
				snake.snakeXLength[i+1] = snake.snakeXLength[i];
			
			for(int i= snake.lengthOfSnake; i>=0; i--)
			{
				if(i==0)
					snake.snakeYLength[i] = snake.snakeYLength[i] - 25;
				else
					snake.snakeYLength[i] = snake.snakeYLength[i-1];
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//przycisk SPACE restuje gr� 
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE)
		{
			moves = 0;
			snake.score = 0;
			bot.botScore = 0;
			snake.lengthOfSnake = 3;
			bot.lengthOfBot = 3;
			fruit = new Fruit();
			fruit.start();
			repaint();
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			snake.pressRightKey();
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			snake.pressLeftKey();
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			snake.pressUpKey();
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			snake.pressDownKey();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
