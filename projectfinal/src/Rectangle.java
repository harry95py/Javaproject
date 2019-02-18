
import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

public class Rectangle implements shapes{
	java.awt.Rectangle rect;

	@Override
	public void draw(Graphics2D g, Point A, Point B, Color LineColor,Stroke lineborder) {
		rect = new java.awt.Rectangle();
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
				rect.setBounds(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(rect);
				
			}
			else {
				rect.setBounds(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(rect);
			}
				
		}else {
			if(A.y>B.y) {
				rect.setBounds(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(rect);
			}else {
				rect.setBounds(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				g.draw(rect);
			}
		}
		
		
				
	}	
	void fill(Graphics2D g, Color FillColor) {
		g.setColor(FillColor);
		g.fill(rect);
		
	}
	
	void bufferlayer(Graphics2D g2D,BufferedImage bimg,Point A, Point B, Color LineColor,Stroke lineborder) {
		
		Graphics2D gb = bimg.createGraphics();
		gb.setColor(LineColor);
		
		// xet border
		if(lineborder==null) {		
			gb.setStroke(new BasicStroke(1.0f));
			lineborder = gb.getStroke();	
		}
		else {
			gb.setStroke(lineborder);
		}
		
		
		if(A.x>B.x) {
			if(A.y>B.y) {
				rect.setBounds(B.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(rect);
				;
			}
			else {
				rect.setBounds(B.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(rect);
			}
				
		}else {
			if(A.y>B.y) {
				rect.setBounds(A.x, B.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(rect);
			}else {
				rect.setBounds(A.x, A.y, Math.abs(A.x-B.x), Math.abs(A.y-B.y));
				gb.draw(rect);
			}
		}
			
	}

	void fillbuffer(Graphics2D g2D,BufferedImage bimg,Color FillColor) {
		g2D = bimg.createGraphics();
		g2D.setColor(FillColor);
		g2D.fill(rect);
		
	}

}
