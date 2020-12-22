import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private double mouseSensitivity = 2.5;
    private List<IEntity> entities;
    private int initialX, initialY;


    public EntityManager() {
        this.entities = new ArrayList<IEntity>();

    }

    public void init() {
        this.entities.add(BasicEntityBuilder.createDiamond(new Color(200, 40, 150), 100, 0,0,0));
       //this.entities.add(BasicEntityBuilder.createCube( 100, 100,100,100));
    }

    public void update(Mouse mouse) {

        int x = mouse.getMouseX();
        int y = mouse.getMouseY();
        if (mouse.getButton() == ClickTipe.LeftClick) {
            int xDif = x - initialX;
            int yDif = y - initialY;

            this.rotate(true, 0, -yDif / mouseSensitivity, -xDif / mouseSensitivity);

        } else if (mouse.getButton() == ClickTipe.RightClick) {
            int xDif = x - initialX;

            this.rotate(true, -xDif / mouseSensitivity, 0, 0);

        }

        if (mouse.isScrollingUp()) {
            PointConverter.zoomIn();
        } else if (mouse.isScrollingDown()) {
            PointConverter.zoomOut();
        }

        mouse.resetScroll();
        initialX = x;
        initialY = y;

    }

    public void render(Graphics g) {
        for (IEntity entity : this.entities) {
            entity.render(g);
        }
    }


    private void rotate(boolean direction, double xAngle, double yAngle, double zAngle) {
        for (IEntity entity : this.entities) {
            entity.rotate(direction, xAngle, yAngle, zAngle);
        }
    }
}
