package Jogo;
import javax.swing.JFrame;
// po é o main só isso
public class Janelinha {

    public Janelinha() {

        JFrame frame = new JFrame();
        Screen screen = new Screen();

        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Jogo da Cobrinha do Nokia Boladão");
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Janelinha();
    }
}
