import javax.swing.JFrame;

import javax.swing.WindowConstants;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;

import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JFileChooser;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
public class mainApp implements ActionListener{
	private JFrame frame;
	private JPanel panel;
	private Point pS,pE;
	private JColorChooser colorchooser,colorchooser1;
	private Color linecolor = Color.WHITE,fillcolor;
	private BufferedImage bimg;
	private boolean flag_rect=false,flag_elip=false,flag_cir=false,flag_poly=false;
	ArrayList<Point> point_list = new ArrayList<Point>();
	private Graphics2D g2D;
	private Stroke lineborder_;
	mainApp() {
		try {
			
			pS = new Point(); pE = new Point();
			frame = new JFrame("My Paint Application");
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.getContentPane().setLayout(null);
			
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBorder(new LineBorder(Color.ORANGE));
			panel.setBounds(140, 0, 644, 550);
				
			frame.getContentPane().add(panel);
			bimg = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
			colorchooser = new JColorChooser(Color.BLACK);
			frame.setSize(807, 618);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 0, 141, 550);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JButton btnCircle = new JButton("CIRCLE");
			btnCircle.setBounds(10, 69, 118, 47);
			panel_1.add(btnCircle);
			btnCircle.setFont(new Font("Times New Roman", Font.BOLD, 12));
			btnCircle.addActionListener(this);
			btnCircle.setActionCommand("draw_a_cir");
			
			JButton btnRectangle = new JButton("RECTANGLE");
			btnRectangle.setBounds(10, 11, 118, 47);
			panel_1.add(btnRectangle);
			btnRectangle.setFont(new Font("Times New Roman", Font.BOLD, 12));
			btnRectangle.addActionListener(this);
			btnRectangle.setActionCommand("draw_a_rect");
			
			JButton btnEclipse = new JButton("ELLIPSE");
			btnEclipse.setBounds(10, 127, 118, 47);
			panel_1.add(btnEclipse);
			btnEclipse.setFont(new Font("Times New Roman", Font.BOLD, 12));
			btnEclipse.addActionListener(this);
			btnEclipse.setActionCommand("draw_an_elip");
			JButton btnPolygon = new JButton("POLYGON");
			btnPolygon.setBounds(10, 185, 118, 47);
			panel_1.add(btnPolygon);
			btnPolygon.setFont(new Font("Times New Roman", Font.BOLD, 12));
			btnPolygon.addActionListener(this);
			btnPolygon.setActionCommand("draw_a_poly");
			
			JButton btnLineColor = new JButton("Line Color");
			btnLineColor.setBounds(10, 300, 118, 35);
			panel_1.add(btnLineColor);
			btnLineColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JButton btnFillColor = new JButton("Fill Color");
			btnFillColor.setBounds(10, 346, 118, 35);
			panel_1.add(btnFillColor);
			btnFillColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JButton btnClear = new JButton("Clear");
			btnClear.setBounds(10, 392, 118, 35);
			btnClear.addActionListener(this);
			btnClear.setActionCommand("clear_all");
			panel_1.add(btnClear);
			
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 463, 67, 35);
		panel_1.add(comboBox);
		
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5	");
		
		JLabel lblBorder = new JLabel("Border");
		lblBorder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBorder.setBounds(10, 429, 56, 32);
		panel_1.add(lblBorder);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				g2D= (Graphics2D) panel.getGraphics();
				float thickness;
				
				
				
				if(e.getStateChange()==ItemEvent.SELECTED) {
					
					if(comboBox.getSelectedItem().equals("2")) {
						
						thickness = 2.5f;
						g2D.setStroke(new BasicStroke(thickness));
						lineborder_ = g2D.getStroke();								
					}
					
					
					else if(comboBox.getSelectedItem().equals("3")) {
						
						thickness = 5.0f;						
						g2D.setStroke(new BasicStroke(thickness));		
						lineborder_=g2D.getStroke();		
					}
											
					else if (comboBox.getSelectedItem().equals("4")) {
						thickness = 7.5f;
						g2D.setStroke(new BasicStroke(thickness));
						lineborder_ = g2D.getStroke();						
					}
										
					else {
						
						thickness = 10.0f;
						g2D.setStroke(new BasicStroke(thickness));
						lineborder_ = g2D.getStroke();													
					}						
				}
				
			}
		});
			
			btnFillColor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						fillcolor = colorchooser1.showDialog(btnFillColor, "Color Panel",null); 
						
					} catch (Exception e1) {
						
					}
					
					
				}
			});
			btnLineColor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						linecolor = colorchooser.showDialog(btnLineColor, "Color Panel",null);
															
					} catch (Exception e) {
						
						
					}
					
				}
			});
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JMenu mnFile = new JMenu("File");
			menuBar.add(mnFile);
			
			JMenuItem mntmSaveImage = new JMenuItem("Save Image");
			mntmSaveImage.setHorizontalAlignment(SwingConstants.CENTER);
			mnFile.add(mntmSaveImage);
			mntmSaveImage.addActionListener(this);
			mntmSaveImage.setActionCommand("save_image");
			
			JMenuItem itemOpen= new JMenuItem("Open");
			mnFile.add(itemOpen);
			itemOpen.addActionListener(this);
			itemOpen.setActionCommand("Open_image");
			
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		mainApp m = new mainApp();
	}
	
	void clearcanvas() {
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.ORANGE));
		panel.setBounds(140, 0, 644, 550);
		
		int w_=panel.getWidth();
		int h_=panel.getHeight();
		
		
		doClearBuffer(bimg, w_,h_);
				
	}
	

	public void doClearBuffer(BufferedImage bimg,int w, int h){
		Graphics2D g2d=bimg.createGraphics();
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, w, h);
	}
	
	void exportImage() {
		try {
			
			JFileChooser fc = new JFileChooser();
			if(fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
				File newfile = fc.getSelectedFile();
				ImageIO.write(bimg, "png",newfile); 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void importImage() {
		try {
			
			JFileChooser fChoose= new JFileChooser();
			if(fChoose.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION) {
				
			File file= fChoose.getSelectedFile();
			bimg =ImageIO.read(file);
			 
			Graphics2D g2= (Graphics2D)panel.getGraphics();
			g2.drawImage(bimg, 0, 0, null);
			
			}
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	
	void drawShape() {
		try {
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pS = e.getPoint();

					super.mousePressed(e);
				}
			
				@Override
				public void mouseReleased(MouseEvent e) {
					pE = e.getPoint();
					g2D = (Graphics2D)panel.getGraphics();
					if(flag_rect == true) {
						Rectangle rect = new Rectangle();
						rect.draw(g2D, pS, pE, linecolor,lineborder_);
						rect.bufferlayer(g2D, bimg, pS, pE, linecolor,lineborder_);
						if(fillcolor!=null) {
							rect.fill(g2D, fillcolor);
							rect.fillbuffer(g2D, bimg, fillcolor);
						}
					
					}
					else if(flag_elip == true) {
						Ellipse elip = new Ellipse();
						elip.draw(g2D, pS, pE, linecolor,lineborder_);
						elip.bufferlayer(g2D, bimg, pS, pE, linecolor,lineborder_);
						if(fillcolor!=null) {
							elip.fill(g2D, fillcolor);
							elip.fillbuffer(g2D, bimg, fillcolor);
						}
					}
					else if(flag_cir == true) {
						System.out.println(flag_cir);
						Circle cir = new Circle();
						cir.draw(g2D, pS, pE, linecolor,lineborder_);
						cir.bufferlayer(g2D, bimg, pS, pE, linecolor,lineborder_);
						if(fillcolor!=null) {
							cir.fill(g2D, fillcolor);
							cir.fillbuffer(g2D, bimg, fillcolor);
						}
							
					}

					super.mouseReleased(e);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					Graphics2D g2D = (Graphics2D)panel.getGraphics();
					if(flag_poly==true) {
						Polygon poly = new Polygon();
						if(e.getClickCount()==1) {
							point_list.add(e.getPoint());
							try {
								for(int i=0;i<point_list.size();i++) {
									poly.drawBounds(g2D, point_list.get(i), point_list.get(i+1), linecolor);
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						else {
							poly.drawPolygon(g2D, point_list,linecolor,lineborder_);
							point_list.clear();
							if(fillcolor!=null) {
								poly.fill(g2D, fillcolor);
							}
						}
						} 
					super.mouseClicked(e);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		switch (cmd) {
		case "draw_a_rect":
			flag_rect = true;
			flag_elip = false;
			flag_cir = false;
			flag_poly = false;
			drawShape();
			break;
		case "draw_an_elip":
			flag_rect = false;
			flag_elip = true;
			flag_cir = false;
			flag_poly = false;
			drawShape();
			break;
		case "draw_a_cir":
			flag_rect = false;
			flag_elip = false;
			flag_cir = true;
			flag_poly = false;
			drawShape();
			break;
		case "draw_a_poly":
			flag_rect = false;
			flag_elip = false;
			flag_cir = false;
			flag_poly = true;
			drawShape();
			break;
		case "clear_all":
			clearcanvas();
			break;
		case "save_image":
			exportImage();
			break;
		case "Open_image":
			importImage();
		default:
			break;
		}
		
	}
}
