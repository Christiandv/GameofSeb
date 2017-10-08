
package Characters;
import java.awt.*;
import javax.swing.ImageIcon;

public class Thing {



    public int width;
    public int height;
    public boolean isSolid;
    protected Image image;

    public Thing()
    {

    }


    public Thing(int width,int height) {
        this.width = width;
        this.height = height;

    }

    public void setImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(this.getClass().getResource(imageName));
        image = ii.getImage();
    }

    public void draw(Graphics g,int x, int y){
        g.drawImage(image, x*16, y*16,width*16,height*16,null);
        g.setColor(Color.black);
        g.drawRect( x*16, y*16,width*16,height*16);
    }

    public Image getImage() {
        return image;
    }


}

