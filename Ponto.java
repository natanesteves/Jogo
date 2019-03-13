package Jogo;
import java.awt.Color;
import java.awt.Graphics;

public class Ponto {

    private int xCoor, yCoor, width, height;

    public Ponto(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor+8;
        this.yCoor = yCoor+8;
        width = tileSize;
        height = tileSize;
    }
    public void tick() {

    }
    public void draw(Graphics g) {
        // deffinições do ponto cor.
        g.setColor(Color.RED);
        //mas ja deixa pronto aqui para ele aumentar de tamanho junto com a tela
        g.fillRect(xCoor * width , yCoor * height, width+4, height+4);
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
