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
//import com.essbase.eas.ui.ctable.ComboBoxRenderer;



class BooksView {
    
    final List<TableCellEditor> editors = new ArrayList<TableCellEditor>(15);
                                        
        
        public String columns[];
        
        ArrayList<Book> books = Warehouse.getBooks();
        public Object[][] data = new Object[books.size()][4];
        
         
         public BooksView()
         {
             
            String []columns = {"Title", "Price", "Author", "Available"};
            this.columns = columns;
            for(Book book: books)
            {
                //totalRevenue += book.getSold() * book.getPrice();
                //data[] = 
                data[books.indexOf(book)][0] = book.getTitle();
                data[books.indexOf(book)][1] = book.getPrice();
                data[books.indexOf(book)][2] = book.getAuthor();
                data[books.indexOf(book)][3] = 0;
                
                String[] itemLevel = new String[book.getAvailable()+1];//[Integer.parseInt(parts[j])+1];
                //System.out.println(book.getAvailable());
                for (int k=0; k<=book.getAvailable(); k++)
                    itemLevel[k] = Integer.toString(k);         
                
                JComboBox jcb = new JComboBox(itemLevel);
                DefaultCellEditor dce1 = new DefaultCellEditor( jcb );
                editors.add( dce1 );

            } 
            
            
         }
         


    }
    
