import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MarqueePanel extends JPanel implements ActionListener {

    private final String message;
    private int xPos;
    private final Timer timer;

    public MarqueePanel(String message, int delay) {
        this.message = message;
        this.xPos = 500; 
        setFont(new Font("SansSerif", Font.BOLD, 24));
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xPos -= 2; 
        if (xPos < -getFontMetrics(getFont()).stringWidth(message)) {
            xPos = getWidth();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yPos = (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent();
        g.drawString(message, xPos, yPos);
    }
}
