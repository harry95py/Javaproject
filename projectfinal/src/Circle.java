import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import java.awt.image.BufferedImage;

public class Circle implements shapes{
	Ellipse2D.Float cir;
	@Override
	public void draw(Graphics2D g, Point A, Point B, Color LineColor,Stroke lineborder) {
		cir = new Ellipse2D.Float(0, 0, 0, 0);
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
				cir.setFrame(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				g.draw(cir);
				;
			}
			else {
				cir.setFrame(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				g.draw(cir);
			}
				
		}else {
			if(A.y>B.y) {
				cir.setFrame(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				g.draw(cir);
			}else {
				cir.setFrame(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				g.draw(cir);
			}
		}
				
	}
	
	void fill(Graphics2D g, Color FillColor) {
		g.setColor(FillColor);
		g.fill(cir);
		
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
				cir.setFrame(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				gb.draw(cir);
				;
			}
			else {
				cir.setFrame(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				gb.draw(cir);
			}
				
		}else {
			if(A.y>B.y) {
				cir.setFrame(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				gb.draw(cir);
			}else {
				cir.setFrame(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.x-B.x));
				gb.draw(cir);
			}
		}
		
	}
	
	void fillbuffer(Graphics2D g2D,BufferedImage bimg,Color FillColor) {
		g2D = bimg.createGraphics();
		g2D.setColor(FillColor);
		g2D.fill(cir);
		
	}
}
