import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Movable Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JButton btn1 = new JButton("btn1");
        btn1.setBounds(100, 100, 80, 30);

        btn1.addMouseListener(new MouseAdapter() {
            Point mouseDownCompCoords = null;

            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
        });

        btn1.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                btn1.setLocation(currCoords.x - frame.getLocationOnScreen().x - btn1.getMousePosition().x,
                        currCoords.y - frame.getLocationOnScreen().y - btn1.getMousePosition().y);
            }
        });

        frame.add(btn1);
        frame.setVisible(true);
    }
}