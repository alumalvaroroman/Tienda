package tiendaropanba.renderes;

import javax.swing.table.DefaultTableCellRenderer;

public class ReferenciaRenderer extends DefaultTableCellRenderer{
    @Override
    protected void setValue(Object value) {
        setHorizontalAlignment(LEFT);
    }
}
