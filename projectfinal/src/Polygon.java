import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;

public class Polygon {
	java.awt.Polygon polyg = new java.awt.Polygon();;

	void drawPolygon(Graphics2D g, ArrayList<Point> list,Color LineColor,Stroke lineborder) {
		for(Point p : list) {
			polyg.addPoint(p.x,p.y);
		}
		g.setColor(LineColor);
		
		//xet border
		if(lineborder==null) {			
			g.setStroke(new BasicStroke(1.0f));
			lineborder = g.getStroke();	
		}
		else {
			g.setStroke(lineborder);
		}
		
		g.draw(polyg);
		
	}
	
	void drawBounds(Graphics2D g, Point A, Point B,Color LineColor) {
		g.setColor(LineColor);
		g.drawLine(A.x, A.y, B.x, B.y);
	}
	
	void fill(Graphics2D g, Color FillColor) {
		g.setColor(FillColor);
		g.fill(polyg);
		
	}
	
}
