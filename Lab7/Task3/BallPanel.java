import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class BallPanel extends JPanel implements ActionListener {
    private double x = 50, y = 50; 
    private double dx, dy;
    private final Timer timer;
    private final Image ballImage;

    public BallPanel() {
        setBackground(Color.WHITE);
        ballImage = new ImageIcon("shahd.jpeg").getImage();

        Random rand = new Random();
        dx = (rand.nextBoolean() ? 1 : -1) * (rand.nextInt(4) + 2);
        dy = (rand.nextBoolean() ? 1 : -1) * (rand.nextInt(4) + 2);

        timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int size = Math.max(20, getWidth() / 10); 
        x += dx;
        y += dy;

        if (x < 0) { x = 0; dx = -dx; }
        if (x + size > getWidth()) {
             x = getWidth() - size; dx = -dx; 
            }
        if (y < 0) 
            {
                 y = 0;
                 dy = -dy; 
                }
        if (y + size > getHeight()) { 
            y = getHeight() - size; dy = -dy; 
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.max(20, getWidth() / 10); 
        g.drawImage(ballImage, (int)x, (int)y, size, size, this);
    }
}
