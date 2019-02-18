package snake;

import jdk.nashorn.internal.scripts.JO;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

// Dette er for morsomt...

public class Snake implements ActionListener, KeyListener
{

    public JMenuBar meny1 = new JMenuBar();
    public JMenu newGameMeny = new JMenu("Nytt spill");
    public JMenuItem easyGameMenuItem = new JMenuItem("Lett");
    public JMenuItem mediumGameMenuItem = new JMenuItem("Normal");
    public JMenuItem hardGameMenuItem = new JMenuItem("Vanskelig");

    public void menuDesign() {
        // Tar med ActionListener for nytt spill, her bestemmer jeg hvor fort jeg vil at slangen skal bevege seg senere når spillet starter...
        // Dette gjør jeg selvfølgelig etter å ha laget meny.
        meny1.add(newGameMeny);
        newGameMeny.add(easyGameMenuItem);
        newGameMeny.add(mediumGameMenuItem);
        newGameMeny.add(hardGameMenuItem);
        board.setJMenuBar(meny1);
    }

    public static Snake snake;

    public JFrame board;
    public GUI GUI;
    public Timer timer = new Timer(18, this);

    public ArrayList<Point> snakeParts = new ArrayList<Point>(); // her blir det lagret

    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10; // bruker final for å ikke få endret på disse verdiene på etterkant. Dette er verdier på tastatur knapper
    public int ticks = 0, direction = 5, score, tailLength = 10, time;

    public Point theHead, endOfTail;     // lagde Point for som spesifiserer kordinatet til tuppen og helt bakerste punkt (slutten av halen)
    public Random random;                // Genererer tilfeldige verdier
    public boolean over = false, paused; // Dette har jeg lagd for pause og da spillet er over.
    public Dimension dim;

    public Snake()
    {
        dim = Toolkit.getDefaultToolkit().getScreenSize(); // Get information about the screen so you can configure to the spesific screen resolution
        board = new JFrame("Snake");                 // Dette konfigurer for alle maskiner/Pcer osv...
        board.setVisible(true);
        board.setSize(800, 700);
        board.setResizable(false);
        board.setLocation(dim.width / 2 - board.getWidth() / 2, dim.height / 2 - board.getHeight() / 2);
        board.add(GUI = new GUI());
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.addKeyListener(this);
        menuDesign();
        startGame();

    }

    public void startGame()
    {
        Random randomNumber = new Random();
        int number1 = randomNumber.nextInt(60)+1;
        over = false;
        paused = false;
        time = 0;
        score = 0;
        tailLength = 5;
        ticks = 0;
        direction = 5;
        theHead = new Point(number1, number1);
        random = new Random();
        snakeParts.clear();
        endOfTail = new Point(random.nextInt(79), random.nextInt(66));
        timer.start();
//        JOptionPane.showMessageDialog(null, "Press Space to start!");

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        GUI.repaint();
        ticks++;



        if (ticks % 2 == 0 && theHead != null && !over && !paused)
        {
            time++;

            snakeParts.add(new Point(theHead.x, theHead.y));

            if (direction == UP)
            {
                if (theHead.y - 1 >= 0 && noTailAt(theHead.x, theHead.y - 1))
                {
                    theHead = new Point(theHead.x, theHead.y - 1);
                }
                else
                {
                    over = true;
                }
            }

            if (direction == DOWN)
            {
                if (theHead.y + 1 < 67 && noTailAt(theHead.x, theHead.y + 1))
                {
                    theHead = new Point(theHead.x, theHead.y + 1);
                }
                else
                {
                    over = true;
                }
            }

            if (direction == LEFT)
            {
                if (theHead.x - 1 >= 0 && noTailAt(theHead.x - 1, theHead.y))
                {
                    theHead = new Point(theHead.x - 1, theHead.y);
                }
                else
                {
                    over = true;
                }
            }

            if (direction == RIGHT)
            {
                if (theHead.x + 1 < 80 && noTailAt(theHead.x + 1, theHead.y))
                {
                    theHead = new Point(theHead.x + 1, theHead.y);

                }
                else
                {
                    over = true;
                }
            }

            if (snakeParts.size() > tailLength)
            {
                snakeParts.remove(0);
            }
            if (endOfTail != null)
            {
                if (theHead.equals(endOfTail)) // denne bestemmer hva som skjer når du treffer et eple og "spiser" den
                {
                    score += 5;
                    tailLength++;
                    System.out.println("You ate a green Apple, you're growing");
                    endOfTail.setLocation(random.nextInt(79), random.nextInt(66));
                }
            }
        }
    }

    public boolean noTailAt(int x, int y)
    {
        for (Point point : snakeParts)
        {
            if (point.equals(new Point(x, y))) // Hvis den treffer seg selv igjen er spillet over
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        snake = new Snake(); // starte spillet
    }

    @Override
    public void keyPressed(KeyEvent e) // legge til funksjoner til de forskjellige knappene poo tastaturet
    {
        int i = e.getKeyCode();

        if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT)
        {
            direction = LEFT;
            System.out.println("You pressed the LEFT key");
        }

        if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT)
        {
            direction = RIGHT;
            System.out.println("You pressed the RIGHT key");

        }

        if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN)
        {
            direction = UP;
            System.out.println("You pressed the UP key");

        }

        if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP)
        {
            direction = DOWN;
            System.out.println("You pressed the DOWN key");

        }

        if (i == KeyEvent.VK_SPACE) // bruke spacebar for restarte spillet, enklere...
        {
            if (over)
            {
                startGame();
            }
            else
            {
                paused = !paused;
            }
        }

        if (i == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }
}
