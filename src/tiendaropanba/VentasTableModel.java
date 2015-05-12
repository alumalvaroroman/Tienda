package tiendaropanba;

import javax.swing.table.AbstractTableModel;


public class VentasTableModel extends AbstractTableModel {
    private ListaVentas listaVentas;

    public VentasTableModel(ListaVentas venta) {
        this.listaVentas = venta;
    }
    
    @Override
    public int getRowCount() {
        if(listaVentas.getListaVentas() == null)
            return 0;
        return listaVentas.getListaVentas().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ventas venta = listaVentas.getListaVentas().get(rowIndex);
        switch(columnIndex) {
            case 0:
                return venta.getIdProducto().getNombreProducto();
            case 1:
                return venta.getCantidad();
            case 2:
                return venta.getPrecio();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nombre de producto";
            case 1:
                return "Cantidad";
            case 2:
                return "Precio";
            default:
                return null;
        }
    }  
    
}
