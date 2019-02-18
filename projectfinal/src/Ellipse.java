import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Ellipse implements shapes{
	Ellipse2D.Float elip;
	@Override
	public void draw(Graphics2D g, Point A, Point B, Color LineColor,Stroke lineborder) {
		elip = new Ellipse2D.Float(0, 0, 0, 0);
		g.setColor(LineColor);
		
		//xet border
		if(lineborder==null) {
			
			g.setStroke(new BasicStroke(1.0f));
			lineborder = g.getStroke();	
		}
		else {
			g.setStroke(lineborder);
		}
		
		if(A.x>B.x) {
			if(A.y>B.y) {
				elip.setFrame(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(elip);
				;
			}
			else {
				elip.setFrame(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(elip);
			}
				
		}else {
			if(A.y>B.y) {
				elip.setFrame(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(elip);
			}else {
				elip.setFrame(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(elip);
			}
		}
		
		
				
	}
	
	void fill(Graphics2D g, Color FillColor) {
		g.setColor(FillColor);
		g.fill(elip);
		
	}
	
	void bufferlayer(Graphics2D g2D,BufferedImage bimg,Point A, Point B, Color LineColor,Stroke lineborder) {
		
		Graphics2D gb = bimg.createGraphics();
		gb.setColor(LineColor);
		
		//xet border
		if(lineborder==null) {		
			gb.setStroke(new BasicStroke(1.0f));
			lineborder = gb.getStroke();	
		}
		else {
			gb.setStroke(lineborder);
		}
		
		
		if(A.x>B.x) {
			if(A.y>B.y) {
				elip.setFrame(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(elip);
				;
			}
			else {
				elip.setFrame(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(elip);
			}
				
		}else {
			if(A.y>B.y) {
				elip.setFrame(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(elip);
			}else {
				elip.setFrame(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(elip);
			}
		}
		
	}
	
	void fillbuffer(Graphics2D g2D,BufferedImage bimg,Color FillColor) {
		g2D = bimg.createGraphics();
		g2D.setColor(FillColor);
		g2D.fill(elip);
		
	}
	
}
