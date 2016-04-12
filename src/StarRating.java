// referred code from given links on blaclboard.
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StarRating extends JPanel {

    private BufferedImage starImage;
    Graphics2D graphicHandler =null;
    Point me=null;
    static int urating = 0;
    public StarRating() {
        try 
        {
        	starImage = ImageIO.read(new File("stars.jpg"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(starImage.getWidth(), starImage.getHeight()));
        
        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                    me = e.getPoint();
                    repaint();
            }

        });
    }

    private BufferedImage process(BufferedImage old) 
    {
        Composite originalComposite = graphicHandler.getComposite();
        int width = old.getWidth();
        int height = old.getHeight();
        Rectangle   rect = new Rectangle(0, 0, width/10, height);
        if(me!=null)
        {
        	urating=1;
            while(!rect.contains(me))
            {
            	urating++;
                rect = new Rectangle(0, 0, urating*(width/10), height);
            }
        }
//        System.out.println(i);
        Rectangle   fillRect = new Rectangle(0, 0, urating*(width/10), height);
        
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphicHandler = img.createGraphics();
        graphicHandler.drawImage(old, 0, 0, null);
//        graphicHandler.draw3DRect(0, 0, w/10, h,false);
        graphicHandler.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f)));
        graphicHandler.setPaint(Color.LIGHT_GRAY);
        graphicHandler.fill(fillRect);
//        graphicHandler.setPaint(Color.red);
//        graphicHandler.setFont(new Font("Serif", Font.BOLD, 20));
//        String s = "Hello, world!";
//        FontMetrics fm = graphicHandler.getFontMetrics();
//        int x = img.getWidth() - fm.stringWidth(s) - 5;
//        int y = fm.getHeight();
//        graphicHandler.drawString(s, x, y);
        
        graphicHandler.setComposite(originalComposite);
//        int type = AlphaComposite.SRC_OVER;
//        graphicHandler.setComposite((AlphaComposite.getInstance(type, 1f)));
        
//        graphicHandler.translate(w/10, 0);
//        graphicHandler.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        graphicHandler = (Graphics2D)g;
        BufferedImage imageDraw = process(starImage);
        g.drawImage(imageDraw, 0, 0, null);
    }

   /* private static void create() {
         JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new StarRating());
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }*/
}
