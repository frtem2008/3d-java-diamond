import java.awt.*;

public class Tetrahedron {

    private MyPolygon[] polygons;
    private Color color;

    Tetrahedron(Color color, boolean decayColor, MyPolygon... polygons) {
        this.color = color;
        this.polygons = polygons;
        if (!decayColor)
            this.setPolygonColor();
        else
            //this.setDecayingPolygonColor();
            this.setRandomPolygonColor();
        this.sortPolygons();
    }

    Tetrahedron(MyPolygon... polygons) {
        this.color = Color.WHITE;
        this.polygons = polygons;

    }

    public void render(Graphics g) {
        for (MyPolygon poly : this.polygons) {
            poly.render(g);
        }
    }

    public void rotate(boolean CW, double XDegrees, double YDegrees, double ZDegrees) {
        for (MyPolygon p : this.polygons) {
            p.rotate(CW, XDegrees, YDegrees, ZDegrees);
        }
        this.sortPolygons();
    }

    private void sortPolygons() {
        MyPolygon.sortPolygons(this.polygons);
    }

    private void setPolygonColor() {
        for (MyPolygon poly : this.polygons) {
            poly.setColor(this.color);
        }
    }

    private void setDecayingPolygonColor() {
        double decayFactor = 0.97;
        for (MyPolygon poly : this.polygons) {
            poly.setColor(this.color);
            int r = (int) (this.color.getRed() * decayFactor);
            int g = (int) (this.color.getGreen() * decayFactor);
            int b = (int) (this.color.getBlue() * decayFactor);
            this.color = new Color(r, g, b);
        }
    }

    private void setRandomPolygonColor() {
        for (MyPolygon poly : this.polygons) {
            poly.setColor(this.color);
            this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        }
    }
}
