package com.mycompany.clinicaveterinaria.TableModel;
import com.mycompany.clinicaveterinaria.Model.DAO.ClientDAO;
import com.mycompany.clinicaveterinaria.Model.DAO.SpeciesDAO;
import com.mycompany.clinicaveterinaria.Model.POJO.Animal;
import com.mycompany.clinicaveterinaria.Model.POJO.Client;
import com.mycompany.clinicaveterinaria.Model.POJO.Species;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


public class AnimalTableModel extends AbstractTableModel {
    protected ArrayList<Animal> vDados;
    protected String[] colunas;
    
    private ClientDAO clientDAO = new ClientDAO();
    private SpeciesDAO speciesDAO = new SpeciesDAO();

    public AnimalTableModel(List vDados, String[] colunas) {
        this.colunas = colunas;
        this.vDados = (ArrayList)vDados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return vDados.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    // Metodos auxiliares:
    public Object getItem(int indiceLinha) {
        if (indiceLinha < 0) {
            return null;
        }
        return vDados.get(indiceLinha);
    }

    public void addItem(Animal obj) {
        vDados.add(obj);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeItem(int indiceLinha) {
        vDados.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListOfItems(List<Animal> vItens) {
        this.clear();
        for (Animal obj : vItens){
            this.addItem(obj);
        }
    }

    public void clear() {
        vDados.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return vDados.isEmpty();
    }

    public void setColumnWidth(JTable myTable, int[] vWidth) {
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < vWidth.length; i++) {
            TableColumn col = myTable.getColumnModel().getColumn(i);
            col.setPreferredWidth(vWidth[i]);
        }
    }

    public void selectAndScroll(JTable table, int rowIndex) {
        table.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
        scrollToVisible(table, rowIndex);
    }

    public void scrollToVisible(JTable table, int rowIndex) {
        scrollToVisible(table, rowIndex, 0);
    }

    public void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        this.setViewPortPosition((JViewport) table.getParent(), table.getCellRect(rowIndex, vColIndex, true));
    }

    private void setViewPortPosition(JViewport viewport, Rectangle position) {
        Point pt = viewport.getViewPosition();
        position.setLocation(position.x - pt.x, position.y - pt.y);
        viewport.scrollRectToVisible(position);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = this.vDados.get(rowIndex);
        
        var species = speciesDAO.getSpeciesById(animal.getSpeciesId());
        if (species == null) { 
            species = new Species(0,"Não encontrado");
        }
        
        var client = clientDAO.getUserById(animal.getClientId());
        if (client == null) { 
            client = new Client(-1,"Não encontrado", "", "", -1, ""); 
        }
        
        switch(columnIndex) {
            case 0:
                return animal.getId();
            case 1:
                return animal.getName();
            case 2:
                return animal.getGenre();
            case 3:
                return species.getName();
            case 4:
                return client.getName();
            default:
                return new Object();
        }
    }
}//GenericTableModel
