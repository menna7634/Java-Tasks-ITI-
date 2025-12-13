import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeApplication extends JFrame {

    private JLabel dateTimeLabel; 
    private SimpleDateFormat dateFormat;

    public DateTimeApplication() {
        setTitle("Time & Date Application Thread");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); 
        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(dateTimeLabel);

        dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Thread timeThread = new Thread(new TimeUpdater());
        timeThread.start();

        setVisible(true);
    }

    private class TimeUpdater implements Runnable {
        @Override
        public void run() {
            while (true) {
                Date now = new Date();
                SwingUtilities.invokeLater(() -> dateTimeLabel.setText(dateFormat.format(now)));
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
