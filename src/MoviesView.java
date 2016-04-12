import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import javax.swing.ComboBoxEditor;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;



class MoviesView {
    
    final List<TableCellEditor> editors = new ArrayList<TableCellEditor>(15);
                                        
        
        public String columns[];
        
        ArrayList<Movie> movies = Warehouse.getMovies();
        public Object[][] data = new Object[movies.size()][4];
        
         
         public MoviesView()
         {
             
            String []columns = {"Title", "Price", "Director", "Available"};
            this.columns = columns;
            for(Movie movie: movies)
            {
                //totalRevenue += book.getSold() * book.getPrice();
                //data[] = 
                data[movies.indexOf(movie)][0] = movie.getTitle();
                data[movies.indexOf(movie)][1] = movie.getPrice();
                data[movies.indexOf(movie)][2] = movie.getDirector();
                data[movies.indexOf(movie)][3] = 0;
                
                String[] itemLevel = new String[movie.getAvailable()+1];//[Integer.parseInt(parts[j])+1];
                //System.out.println(movie.getAvailable());
                for (int k=0; k<=movie.getAvailable(); k++)
                    itemLevel[k] = Integer.toString(k);         
                
                JComboBox jcb = new JComboBox(itemLevel);
                DefaultCellEditor dce1 = new DefaultCellEditor( jcb );
                editors.add( dce1 );

            } 
            
            
         }
         
    }
    
