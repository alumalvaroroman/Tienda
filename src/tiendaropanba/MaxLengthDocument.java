package tiendaropanba;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MaxLengthDocument extends PlainDocument {
    private int maxLength;

    // Se le debe pasar por parámetro el número máximo de caracteres permitidos
    public MaxLengthDocument(int maxLength) {
        this.maxLength = maxLength;
    }
   
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // Sólo se ejecuta el insertString original si no se sobrepasa el
        //  límite establecido
        if(getLength() + str.length() <= maxLength) {
            super.insertString(offs, str, a);
        }
    }
}
