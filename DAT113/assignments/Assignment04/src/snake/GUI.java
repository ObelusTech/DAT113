package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

// dette er for morsomt

public class GUI extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Snake snake = Snake.snake;

        g.setColor(Color.GRAY);

        g.fillRect(0, 0, 800, 700);

        g.setColor(Color.RED);

        for (Point point : snake.snakeParts)
        {
            g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
        }

        g.fillRect(snake.theHead.x * Snake.SCALE, snake.theHead.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);

        g.setColor(Color.GREEN);

        g.fillRect(snake.endOfTail.x * Snake.SCALE, snake.endOfTail.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);

        String string = "Poengsum: " + snake.score + ", Lengde: " + snake.tailLength;

        g.setColor(Color.BLACK);

        g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10); // This shows what the points and lenght of the snake are, on the top.

        string = "Du tapte dessverre";

        if (snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }

        string = "Pause";

        if (snake.paused && !snake.over)
        {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }
    }
}
