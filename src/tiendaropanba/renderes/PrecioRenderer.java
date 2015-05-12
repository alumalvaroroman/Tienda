package tiendaropanba.renderes;

import java.text.NumberFormat;
import javax.swing.table.DefaultTableCellRenderer;

public class PrecioRenderer extends DefaultTableCellRenderer{
    @Override
    protected void setValue(Object value) {
        NumberFormat formato = NumberFormat.getCurrencyInstance();
        // Aplicar el formato al valor que se reciba por parámetro y mostrarlo
        //   en el JTable
        setText(formato.format(value));
        // Alinear a la derecha
        setHorizontalAlignment(RIGHT);
    }
}
