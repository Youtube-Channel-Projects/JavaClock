package Clock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    JLabel clockLabel;
    JLabel dateLabel;

    MyJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));  // center alignment, spacing

        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        this.add(clockLabel);
        this.add(dateLabel);

        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock();
        this.setVisible(true);
    }

    void updateClock() {
        LocalTime now = LocalTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        clockLabel.setText(time);

        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dateLabel.setText(date);
    }
}
