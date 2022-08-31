import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class Board extends JPanel {
    private int size;
    private static int w;
    private static int h;
    static boolean hasPar = false;
    static boolean hasMess = false;

    public Board(int size) {
        this.setPreferredSize(new Dimension(size, size));
        this.size = size;
    }

    public void paint(Graphics g) {
        super.paintComponent(g);

//        g.setColor(Color.BLACK);

        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);

        if (hasPar == false) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Insert height");
            String height = sc.nextLine();
            System.out.print("Insert weight");
            String weight = sc.nextLine();

            w = Integer.parseInt(weight);
            h = Integer.parseInt(height);

            if (h > 8 || h < 0) {
                System.out.print("Insert weight between 1 and 8");
                hasMess = true;
            }
            if (w > 8 || w < 0) {
                if (hasMess != true) {
                    System.out.print("Insert weight between 1 and 8");
                    hasMess = true;
                }
            }
            if (w == 0 || h == 0) {
                if (hasMess != true) {
                    System.out.print("Insert weight between 1 and 8");
                    hasMess = true;
                }
            }

            hasPar = true;
        }

        int tileSize = size / 8;

//        int tileSizeY = size / h;

        if (hasMess == false) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (i % 2 == j % 2) {
                        g.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                    }

                }
            }
        }
    }


    public static void main(String args[]) {

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new Board(600));
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }


}