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



class CdView {
    
    final List<TableCellEditor> editors = new ArrayList<TableCellEditor>(15);
                                        
        
        public String columns[];
        
        ArrayList<CD> cds = Warehouse.getCDs();
        public Object[][] data = new Object[cds.size()][4];
        
         
         public CdView()
         {
             
            String []columns = {"Title", "Price", "Performer", "Available"};
            this.columns = columns;
            //System.out.println(cds);
            for(CD cd: cds)
            {
                //totalRevenue += book.getSold() * book.getPrice();
                //data[] = 
                data[cds.indexOf(cd)][0] = cd.getTitle();
                data[cds.indexOf(cd)][1] = cd.getPrice();
                data[cds.indexOf(cd)][2] = cd.getPerformer();
                data[cds.indexOf(cd)][3] = 0;
                
                String[] itemLevel = new String[cd.getAvailable()+1];//[Integer.parseInt(parts[j])+1];
                //System.out.println(cd.getAvailable());
                for (int k=0; k<=cd.getAvailable(); k++)
                    itemLevel[k] = Integer.toString(k);         
                
                JComboBox jcb = new JComboBox(itemLevel);
                DefaultCellEditor dce1 = new DefaultCellEditor( jcb );
                editors.add( dce1 );

            } 
            
            
         }
         


    }
    
