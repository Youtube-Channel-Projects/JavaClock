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
        // for the program
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setSize(200, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));  // center alignment, spacing

        // initialize clock label
        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        // initialize date label
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // add labels to the window 
        this.add(clockLabel);
        this.add(dateLabel);

        // create a timer that updates every second (100ms)
        Timer timer = new Timer(1000, e -> update());
        timer.start();

        // update clock at start up
        update();
        this.setVisible(true);
    }

    // method to update clock and date
    void update() {
        // get and format time
        LocalTime now = LocalTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        clockLabel.setText(time);

        // get and format date
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dateLabel.setText(date);
    }
}
