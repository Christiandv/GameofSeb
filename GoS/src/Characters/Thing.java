
package Characters;
import java.awt.*;
import javax.swing.ImageIcon;

public class Thing {


    public int x;
    public int y;
    public int width;
    public int height;
    public boolean isSolid;
    protected Image image;

    public Thing()
    {
        x = 0;
        y = 0;
    }


    public Thing(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public void setImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public void draw(Graphics g){
        g.drawImage(image, x*16, y*16,16,16,null);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

