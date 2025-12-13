import javax.swing.*;

public class MarqueeApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scrolling Marquee");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 200);

            frame.add(new MarqueePanel("Java World - This is a scrolling marquee string!", 30));

            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
    }
}
