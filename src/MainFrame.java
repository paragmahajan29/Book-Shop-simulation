/**
 * Movie class defines each movies information.
 * 
 * @author Parag Mahajan
 * @version 1.2 25 Oct 2014
 */
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.table.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MainFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    
    JFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    
    JPanel panelCont; 
    JPanel SalesPn;
    JPanel top;
    JPanel middle;
    JPanel bottom;
    
    JPanel purchasePn;
    
    JPanel StatisticsPn;
    
    JPanel RatingPn;
    JPanel starPn;
    
    JButton cartButton;
    JButton purchaseButton;
    JButton rateButton = new JButton("Rate");
    
    StarRating sr;
    
    String[] items = {"CD", "Movie", "Book"};
    JComboBox c = new JComboBox(items);
    
    JComboBox ratingCombo;
    JTextArea selectedItems= new JTextArea(5, 40);
    
    JTextArea ratedItems= new JTextArea(5, 40);
   
    CardLayout c1;
    BooksView bv = new BooksView();
    DefaultTableModel modelBook = new DefaultTableModel(bv.data, bv.columns);
    JTable tableBook = new JTable(modelBook)
    {
        //  Determine editor to be used by row
        public TableCellEditor getCellEditor(int row, int column)
        {
            int modelColumn = convertColumnIndexToModel( column );
    
            if (modelColumn == 3)
                return bv.editors.get(row);
            else
                return super.getCellEditor(row, column);
        }
    };
    //JTable table = new JTable(mm);
    
    CdView cv = new CdView();
    DefaultTableModel modelCd = new DefaultTableModel(cv.data, cv.columns);
    JTable tableCd = new JTable(modelCd)
    {
        //  Determine editor to be used by row
        public TableCellEditor getCellEditor(int row, int column)
        {
            int modelColumn = convertColumnIndexToModel( column );
    
            if (modelColumn == 3)
                return cv.editors.get(row);
            else
                return super.getCellEditor(row, column);
        }
    };
    
    MoviesView mv = new MoviesView();
    DefaultTableModel modelMovie = new DefaultTableModel(mv.data, mv.columns);
    JTable tableMovie = new JTable(modelMovie)
    {
        //  Determine editor to be used by row
        public TableCellEditor getCellEditor(int row, int column)
        {
            int modelColumn = convertColumnIndexToModel( column );
    
            if (modelColumn == 3)
                return mv.editors.get(row);
            else
                return super.getCellEditor(row, column);
        }
    };
    
    ArrayList<Media> cartList = new ArrayList<Media>(); 
    ArrayList<Media> soldList = new ArrayList<Media>();
    String currentTable = "";
    String currentRatingMedia = "";
    
    /**
     * Constructor for objects of class MainFrame
     */
    public MainFrame()
    {
        
        makeFrame();
        makeMenubar();
    }
    
 
    
    public void makeFrame()
    {
        frame = new JFrame("Media Shop");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);  
        frame.setVisible(true);
        //frame.setSize(600,600);
        label1 = new JLabel("Welcome");
        label2 = new JLabel("");
        label3 = new JLabel("You have purchased order successfully");
        label4 = new JLabel("");
        label5 = new JLabel("");
        
        sr = new StarRating();
        
        cartButton = new JButton("Add to Cart");
        purchaseButton = new JButton("Purchase");
        
        
        panelCont = new JPanel();
        
        SalesPn = new JPanel();
        top = new JPanel();
        middle = new JPanel();
        bottom = new JPanel();
        purchasePn = new JPanel();
        StatisticsPn = new JPanel();
        RatingPn = new JPanel();
        starPn = new JPanel();
        
        StatisticsPn.add(label4);
        purchasePn.add(label3);
        starPn.add(sr);
        
        top.add(label1); 
        top.add(label2); 
        //middle.add(label3);
        SalesPn.add(top, BorderLayout.NORTH);
        SalesPn.add(middle, BorderLayout.CENTER);
        SalesPn.add(bottom, BorderLayout.SOUTH);
        selectedItems.setEditable(false);
        ratedItems.setEditable(false);
        StatisticsPn.add(ratedItems);
        
        
        
        c1 =  new CardLayout();
        panelCont.setLayout(c1);
        panelCont.add("Sales",SalesPn );
        panelCont.add("Purchase", purchasePn);
        panelCont.add("Stats", StatisticsPn);
        panelCont.add("Rating", RatingPn);
        
        c1.show(panelCont, "Sales");
        
        frame.add(panelCont);
        
        
        
        
        c.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
            
                String s = c.getSelectedItem().toString();
                if(s.equals("Book"))
                {
                    middle.removeAll();
                    label2.setText(s);
                    middle.repaint();
                    middle.add(new JScrollPane(tableBook));
                    currentTable = "Book";
                    
                }else if(s.equals("CD"))
                    {
                        middle.removeAll();
                        label2.setText(s);
                        middle.repaint();
                        middle.add(new JScrollPane(tableCd));
                        currentTable = "CD";
                        
                    }else if(s.equals("Movie")){
                        middle.removeAll();
                        label2.setText(s);
                        middle.repaint();
                        middle.add(new JScrollPane(tableMovie));
                        currentTable = "Movie";
                        
                    }
            }
        
        });
        
               
       cartButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               
                if(currentTable.equals("Book"))
                {
                    int noOfRows =  tableBook.getRowCount();
                    for (int i = 0; i < noOfRows; i++ )
                    {
                        String a =(String) String.valueOf(tableBook.getValueAt(i, 3));
                        int selectedCopies = Integer.parseInt(a);
                        if(selectedCopies > 0)
                        {
                            Book b = bv.books.get(i);
                            if(!cartList.contains(b))
                            {
                                b.selected = selectedCopies;
                                cartList.add(b);
                            }
                            else
                                b.selected = selectedCopies;
                                
                                
                        }
                    }
                } else if(currentTable.equals("CD"))
                        {
                            int noOfRows =  tableCd.getRowCount();
                            for (int i = 0; i < noOfRows; i++ )
                            {
                                String a =(String) String.valueOf(tableCd.getValueAt(i, 3));
                                int selectedCopies = Integer.parseInt(a);
                                if(selectedCopies > 0)
                                {
                                    CD c = cv.cds.get(i);
                                    if(!cartList.contains(c))
                                    {
                                        c.selected = selectedCopies;
                                        cartList.add(c);
                                    }
                                    else
                                        c.selected = selectedCopies;
                                        
                                }
                            }
                        }   else if(currentTable.equals("Movie"))
                            {
                                int noOfRows =  tableMovie.getRowCount();
                                for (int i = 0; i < noOfRows; i++ )
                                {
                                    String a =(String) String.valueOf(tableMovie.getValueAt(i, 3));
                                    int selectedCopies = Integer.parseInt(a);
                                    if(selectedCopies > 0)
                                    {
                                        Movie m = mv.movies.get(i);
                                        if(!cartList.contains(m))
                                        {
                                            m.selected = selectedCopies;
                                            cartList.add(m);
                                        }
                                        else
                                            m.selected = selectedCopies;
                                            
                                    }
                                }
                            }
                            
                            selectedItems.setText("");
                            for(Media media : cartList)
                            {
                                selectedItems.append("Price: "+media.getPrice() +" Title: "+ media.getTitle() +" Price: "+ media.getPrice()*media.selected +  " Quntity: "+ media.selected +" Added to Cart \n");
                            }
                            
                            bottom.add(purchaseButton,BorderLayout.EAST); 
                            bottom.revalidate();
                            bottom.repaint();
                        
              }
           });
           
           purchaseButton.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                
                c1.show(panelCont, "Purchase");
                selectedItems.setText("");
                for(Media m: cartList)
                {
                    m.sellCopies(m.selected);
                    soldList.add(m);
                }
                
                cartList.clear();

            }
            
        });
           
           /*ratingCombo.addActionListener(new ActionListener(){
               
               public void actionPerformed(ActionEvent e){
            	   
            	   //String s = ratingCombo.getSelectedItem().toString();
            	   
               }
               
           });*/
           
           
      }
        
    
    
    
    public void makeMenubar()
    {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu filemenu = new JMenu("Open");
        menuBar.add(filemenu);
        
        JMenuItem saleItem = new JMenuItem("Sales");
        filemenu.add(saleItem);
        saleItem.addActionListener(this);
        
        JMenuItem statisticsItem = new JMenuItem("Statistics");
        filemenu.add(statisticsItem);
        statisticsItem.addActionListener(this);
        
        JMenuItem ratingItem = new JMenuItem("Rating");
        filemenu.add(ratingItem);
        ratingItem.addActionListener(this);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        //System.out.println(e.getActionCommand());
        if(command.equals("comboBoxChanged"))
        {
        	RatingPn.add(rateButton);
        	RatingPn.add(label5);
        	RatingPn.revalidate();
        	RatingPn.repaint();
        	
        	
        	rateButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            currentRatingMedia = ratingCombo.getSelectedItem().toString();
            	for(Media med: soldList)
            	{
            		if(med.getTitle().equals(currentRatingMedia))
            		{
            			int j = StarRating.urating;
            			med.updateRating(j);
            		}
            	}
            	label5.setText("Rating for "+currentRatingMedia+" has beed saved with rating " + StarRating.urating);
                RatingPn.revalidate();
            	RatingPn.repaint();
            }
        	});
            
        	
        	
        }
        if(command.equals("Sales"))
        {
           // panelCont.removeAll();
            panelCont.revalidate();
            panelCont.repaint();
            c1.show(panelCont, "Sales");
            label1.setText("Select Media");
            top.add(c);
            bottom.add(cartButton,BorderLayout.WEST);
            bottom.repaint();
            bottom.revalidate();
            bottom.add(new JScrollPane(selectedItems));
            //p.add(new JScrollPane(tableBook));
            
        }else if(command.equals("Statistics"))
                {
                   //label1.setText("Statistics Data");
                   int soldBooks = 0;
                   int soldCds = 0;
                   int soldMovies = 0;
                   double revenue = 0.0;
                   
                   for(Media md:soldList)
                   {
                       if(md instanceof Book)
                       {
                           soldBooks += md.getSold();
                           revenue += md.getSold()*md.getPrice();
                        }else if(md instanceof CD)
                            {
                               soldCds += md.getSold();
                               revenue += md.getSold()*md.getPrice();
                            }else if(md instanceof Movie)
                               {
                                   soldMovies += md.getSold();
                                   revenue += md.getSold()*md.getPrice();
                                }
                   }
                   
                   label4.setText(soldBooks +" Books sold. \n" + soldCds +" CDs sold. \n"+ soldMovies +" Movies Sold. \n" + " Total Revenue: "+revenue);
                   for(Media med : soldList)
                   {
                	   ratedItems.append( med.getTitle()+" Rating: "+ med.r.getAvarageRating() + "\n");
                	   
                   }
                   c1.show(panelCont, "Stats");
                } else if(command.equals("Rating"))
                		{
                			RatingPn.revalidate();
                			RatingPn.repaint();
                			String [] selctedItems = new String[soldList.size()];
                			int i = 0;
                			for(Media m : soldList)
                			{
                				selctedItems[i] = m.getTitle(); 
                				i++;
                			
                			}
                			ratingCombo = new JComboBox(selctedItems);
                			ratingCombo.addActionListener(this);
                			JLabel tp = new JLabel("Give rating to following Items.");
                			RatingPn.add(tp);
                			RatingPn.add(ratingCombo);
                			RatingPn.add(starPn);
                			c1.show(panelCont, "Rating");
                	
                		}
        
    }
    
    public static void main(String args[])
    {
        MainFrame mf = new MainFrame();
    }
}

