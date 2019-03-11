package Jogo;
import java.awt.Color;
import java.awt.Graphics;

public class Ponto {

    private int xCoor, yCoor, width, height;

    public Ponto(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }
    public void tick() {

    }
    public void draw(Graphics g) {
        // deffinições do ponto cor. tamanho  são declarados na outra classe
        g.setColor(Color.RED);
        //mas ja deixa pronto aqui para ele aumentar de tamanho junto com a tela
        g.fillRect(xCoor * width , yCoor * height, width, height);
    }

    public int getxCoor() {
        return xCoor;
    }
    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }
    public int getyCoor() {

        return yCoor;
    }
    public void setyCoor(int yCoor)
    {
        this.yCoor = yCoor;
    }

}
