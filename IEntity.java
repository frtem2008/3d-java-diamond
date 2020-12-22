import java.awt.*;

public interface IEntity {

    void render(Graphics g);

    void rotate(boolean CW, double XDegrees, double YDegrees, double ZDegrees);


}