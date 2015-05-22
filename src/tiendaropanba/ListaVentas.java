package tiendaropanba;

import java.util.List;

public class ListaVentas {
    private List<Ventas> listaVentas;

    public List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    public double getTotal(){
        double total = 0;
        if (listaVentas != null) {
            for (int i = 0; i < listaVentas.size(); i++) {
            total += listaVentas.get(i).getPrecio();
        }
        }
        
        return total;
    }
}
