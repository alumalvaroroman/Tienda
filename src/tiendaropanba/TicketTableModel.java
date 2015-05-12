package tiendaropanba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;


public class TicketTableModel extends AbstractTableModel{
    private ListaTickets listaTicket;

    public TicketTableModel(ListaTickets ticket) {
        this.listaTicket = ticket;
    }
    
    
    @Override
    public int getRowCount() {
        if(listaTicket.getListaTicket() == null)
            return 0;
        return listaTicket.getListaTicket().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket ticket = listaTicket.getListaTicket().get(rowIndex);
        switch(columnIndex) {
            case 0:
                return ticket.getIdTicket();
            case 1:
                return ticket.getNombreEmpresa();
            case 2:
                return ticket.getNombreVendedor();
            case 3:
                return ticket.getFecha();
            case 4:
                return ticket.getHora();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Id Ticket";
            case 1:
                return "Nombre empresa";
            case 2:
                return "Nombre Vendedor";
            case 3:
                return "Fecha";
            case 4:
                return "Hora";
            default:
                return null;
        }
    }  
   
}
