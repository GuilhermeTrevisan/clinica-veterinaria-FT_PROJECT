package TableModel;
import com.mycompany.clinicaveterinaria.Model.POJO.MedicalAppointment;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;


public class EmptyTableModel extends AbstractTableModel {

    public EmptyTableModel() {}

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "";
    }

    // Metodos auxiliares:
    public Object getItem(int indiceLinha) {
        return new Object();
    }

    public void addItem(MedicalAppointment obj) {}

    public void removeItem(int indiceLinha) {}

    public void addListOfItems(List<MedicalAppointment> vItens) {}

    public void clear() {}

    public boolean isEmpty() {
        return true;
    }

    public void setColumnWidth(JTable myTable, int[] vWidth) {}

    public void selectAndScroll(JTable table, int rowIndex) {}

    public void scrollToVisible(JTable table, int rowIndex) {
        scrollToVisible(table, rowIndex, 0);
    }

    public void scrollToVisible(JTable table, int rowIndex, int vColIndex) {}

    private void setViewPortPosition(JViewport viewport, Rectangle position) {}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return new Object();
    }
}//GenericTableModel
