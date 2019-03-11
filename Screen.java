package Jogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;
 //tamanho da janela
    public static final int WIDTH = 800, HEIGHT = 800;

    //hit box da tela
    private Thread thread;

    // e declarando o estado da cobra pq da ruim se n declarar
    private boolean running = false;

    // instanciando a cobra e o ponto
    private CorpoCobra b;
    private ArrayList<CorpoCobra> snake;

    private Ponto ponto;
    private ArrayList<Ponto> Pontos;

    // pro spwan da cobra ser random mesmo dentro do tamonho de tela q vc der
    private Random r;
    //render da cobra
    private int xCoor = 10, yCoor = 10;
    //tamanho da cobra em quadradinhos
    private int size = 5;

    // direção do spwan
    private boolean right = true, left = false, up = false, down =false;

    private int ticks = 0;

    // declarando a tela com os objetos dentro
    public Screen() {
        setFocusable(true);

        addKeyListener(this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();

        snake = new ArrayList<CorpoCobra>();
        Pontos = new ArrayList<Ponto>();

        start();
    }

    public void tick() {
        //spwan da cobra limite de até onde ele pode ir tem q mudar sempre q mudar o tamanho da janela
        if (snake.size() == 0) {
            b = new CorpoCobra(xCoor, yCoor, 10);
            snake.add(b);
        }
        // spawn dos pontos limite de até onde ele pode ir tem q mudar sempre q mudar o tamanho da janela
        if(Pontos.size() == 0) {
            int xCoor = r.nextInt(70);
            int yCoor = r.nextInt(70);

            ponto = new Ponto(xCoor, yCoor, 10);
            Pontos.add(ponto);
        }

        //atualizando onde vc e o ponto estão, para poder saber se vc comeu o ponto e se sim dar spawn em outro e retirar o velho
        for(int i = 0; i < Pontos.size(); i++) {
            if(xCoor == Pontos.get(i).getxCoor() &&
                    yCoor == Pontos.get(i).getyCoor()) {
                size++;
                Pontos.remove(i);
                i++;
            }
        }
        for(int i =0; i < snake.size(); i++) {
            if(xCoor == snake.get(i).getxCoor() &&
                    yCoor == snake.get(i).getyCoor()) {
                if(i != snake.size() - 1) {
                    stop();
                }
            }
        }

        //hit box da parade faz regra de 3 pra saber quando vc mudar o tamanho da janela
        if(xCoor < 0 || xCoor > 78 || yCoor < 0 || yCoor > 78) {
            stop();
        }

        // define a velocidade baseado na quantidade de atualizações dos fps ´um calculo muito grande vai testando no erro ou acerto
        ticks++;

        if(ticks > 2500000) {
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new CorpoCobra(xCoor, yCoor, 10);
            snake.add(b);

            if(snake.size() > size) {
                snake.remove(0);
            }
        }
    }

    public void paint(Graphics g) {
        //definiçõeas do fundo do jogo tipo cor tamanho etc
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.blue);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // definições das linhas dos fundo
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for (int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);
        }

        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for(int i = 0; i < Pontos.size(); i++) {
            Pontos.get(i).draw(g);
        }

    }
    // importando os eventos para começar e parar o jogo. receber o input das teclas. checar se esta correndo
    public void start() {

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // só pra atualizar o render da cobrinha
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left) {
            up = false;
            down = false;
            right = true;
        }
        if(key == KeyEvent.VK_LEFT && !right) {
            up = false;
            down = false;
            left = true;
        }
        if(key == KeyEvent.VK_UP && !down) {
            left = false;
            right = false;
            up = true;
        }
        if(key == KeyEvent.VK_DOWN && !up) {
            left = false;
            right = false;
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    public void keyTyped(KeyEvent arg0) {
    }
}