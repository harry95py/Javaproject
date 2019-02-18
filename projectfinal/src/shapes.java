import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

public interface shapes {
	
	void draw(Graphics2D g,Point A, Point B,Color LineColor, Stroke lineborder);
	
}
