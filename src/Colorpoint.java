
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nima Mirzaei
 */
public class Colorpoint implements Serializable {

    private int x; //x coordinate on a plane
    private int y; //y coordinate on a plane
    private int colorR; //red color component
    private int colorB; //blue color component
    private int colorG; //green color component

    public Colorpoint() {

        x = 0;
        y = 0;
        colorR = 0;
        colorB = 0;
        colorG = 0;
    }

    public Colorpoint(int cordX, int cordY, int colR, int colG, int colB) {
        x = cordX;
        y = cordY;
        colorR = colR;
        colorB = colB;
        colorG = colG;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    public void setRGB(int colorR, int colorG, int colorB) throws InvalidRgbException {
        // specify the cause of the error in message by throwing Exception
        if (colorR < 0 || colorR > 255) {
            throw new InvalidRgbException("Invalid entry of R value . 0 To 255" + colorR);

        } else if (colorG < 0 || colorG > 255) {
            throw new InvalidRgbException("Ivalid entry of G number . 0 To 255" + colorG);

        } else if (colorB < 0 || colorB > 255) {
            throw new InvalidRgbException("Ivalid entry of B number . 0 To 255" + colorB);
        } else {
            this.colorR = colorR;
            this.colorG = colorG;
            this.colorB = colorB;
        }
    }

    /**
     * @return the colorR
     */
    public int getColorR() {
        return colorR;
    }

    /**
     * @return the colorB
     */
    public int getColorB() {
        return colorB;
    }

    /**
     * @return the colorG
     */
    public int getColorG() {
        return colorG;
    }

    @Override
    public String toString() {
        return "The cordination of X is: " + x + " and the cordination of Y is: " + y;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Colorpoint) {

            Colorpoint cp = (Colorpoint) o;

            if (this.x == cp.x && this.y == cp.y
                    && this.colorB == cp.colorB
                    && this.colorG == cp.colorG
                    && this.colorR == cp.colorR) {
                return true;
            }
        }

        return false;
//return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

}
