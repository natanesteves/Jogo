package Jogo;
import java.awt.Color;
import java.awt.Graphics;

public class CorpoCobra {
    //variaveis da cobra
    private int xCoor, yCoor, width, height;

    public CorpoCobra(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }
    public void tick() {

    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(xCoor * width, yCoor * height, width+2, height+2);
        // aqui fica declarado o crescimento do render da cobra mesma coisa pro ponto
        // g.fillRect(xCoor * width + 2, yCoor * height + 2, width -4, height-4);
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
    public void setyCoor(int yCoor) {

        this.yCoor = yCoor;
    }

}