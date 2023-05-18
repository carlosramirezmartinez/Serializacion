
/**
 * Arraylist
 * 
 * @author Carlos
 * @version 1.0
 */

import java.util.ArrayList;
public class ModeloArrayList extends ModeloAbs {
	 private ArrayList <Producto> lista;	 
	 
	 public ModeloArrayList()
	    {
	       lista = new ArrayList <Producto>();
	    }
	@Override
	public boolean insertarProducto(Producto p) {
		lista.add(p);
	    return true;
	}

	@Override
	boolean borrarProducto(int codigo) {
		Producto aux;
    	boolean borrar=false;
    	for (int i = 0; i < lista.size(); i++) {
    		aux = lista.get(i);
    		if (aux.codigo==codigo) {
    			lista.remove(lista.get(i));
    			borrar=true;
    			break;
    		}
    	}
    	return borrar;
    }

	@Override
	public Producto buscarProducto(int codigo) {
		Producto aux=null;
    	
    	for (int i = 0; i < lista.size(); i++) {
    	aux = lista.get(i);
    	if (aux.codigo==codigo) {
    		break;
    		}
    	}
        return aux;
	}

	@Override
	void listarProductosTodos() {
		System.out.println("----- MIS PRODUCTOS -----");
    	for (int i = 0; i < lista.size(); i++) {
        	System.out.println(lista.get(i));
        	}
	}

	@Override
	void listarProductosStockMin() {
		// TODO Auto-generated method stub

	}

	@Override
	boolean modificarProducto(Producto nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

}
