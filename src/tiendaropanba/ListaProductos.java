package tiendaropanba;

import java.util.List;

public class ListaProductos {
    private List<Producto> listaProductos;

    public Producto getProducto(int index){
        return this.listaProductos.get(index);
    }   
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
}
