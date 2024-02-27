import java.util.List;

public class Kolmnurk {
    List<Double> xCoords;
    List<Double> yCoords;

    public Kolmnurk(List<Double> xCoords, List<Double> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;

    }

    public double lisaJaAnnaYmberm66t(double newX, double newY) {
        xCoords.add(newX);
        yCoords.add(newY);
//Math.paw();
        return newX;
    }



}