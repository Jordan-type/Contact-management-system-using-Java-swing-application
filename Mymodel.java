package cms;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JORDAN TYPE
 */
//create a table model to display the contacts images in jtable
public class Mymodel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public Mymodel() {
    }

    public Mymodel(Object[][] data, String[] columnsName) {

        this.columns = columnsName;
        this.rows = data;

    }

    @Override
    public Class getColumnClass(int col) {
        //The index of the image colum is 8
        if (col == 7) {
            return Icon.class;
        } else {

            return getValueAt(0, col).getClass();

        }
    }

    @Override
    public int getRowCount() {
         
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {

        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return this.rows[rowIndex][columnIndex];
        
    }
    
    @Override
    public String getColumnName(int col){
    
    return this.columns[col];
        
    }

}
