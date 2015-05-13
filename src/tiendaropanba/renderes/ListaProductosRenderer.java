package tiendaropanba.renderes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import tiendaropanba.Producto;

public class ListaProductosRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Producto producto = (Producto)value;
        setText(producto.getNombreProducto());
        if(isSelected){
            this.setBackground(Color.CYAN);
            
        }else{
            this.setBackground(Color.white);
        }
        return this;
        
    }
    
}
