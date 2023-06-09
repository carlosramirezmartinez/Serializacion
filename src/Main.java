import java.util.Scanner;

// Crear la clase Producto y completar los metodos


public class Main{
    // Defino como estaticas para que puedan usarse 
    // dentro de la clase sin necesidad de pasarlas como 
    // parametros.
	static private ModeloAbs almacen;
    static private Scanner sc;
    
    public static void main(String[] args){
    	almacen = new ModeloArrayList ();
    	//almacen = new ModeloHashMap ();
        sc = new Scanner(System.in);
        int opcion=0;
        do{
		mostrarMenu();
                opcion=leerOpcion(1,9);
                switch(opcion){
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                }
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                sc.nextLine();
        }while(opcion!=9);
        sc.close();
        
    }

	private static void mostrarMenu(){
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al minimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opcion (1-9)");        
    }
    
    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo){
        int valor = leerEntero();
        while ( valor <primero || valor > ultimo){
            valor = leerEntero();
        }
        return valor;
    }
    
    static private int leerEntero(){
        boolean error = false;
         int  valor =0;
         String cadena;
         do {
         error = false;  
           try {
              // Intento leer directamente un entero  
              cadena = sc.nextLine();
              valor = Integer.parseInt(cadena);
              
             } catch(NumberFormatException e){
               System.out.println("Error en formato.");
               error = true;
             }
         }
        while ( error);
        return valor; 
     }
    
    static private float leerFloat(){
        // Implementar (Ver teoria try and catch) con el escaner
		// trato de controlar la excepcion NumberFormatException
        boolean error = false;
        float valor =0;
        String cadena;
        do {
        error = false;  
          try {
             // Intento leer directamente un entero  
             cadena = sc.nextLine();
             valor = Float.parseFloat(cadena);
             
            } catch(NumberFormatException e){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while (error);
       return valor;
    }
    
    private static void listarPocoStock() {
		// TODO Auto-generated method stub
		
	}
    //Listado de productos
	private static void listar() {
		// TODO Auto-generated method stub
		System.out.println("<LISTAR>");
        almacen.listarProductosTodos();
	}

	private static void vender() {
		// TODO Auto-generated method stub
		
	}

	//5. Comprar productos
	private static void comprar() {
		   System.out.println("<COMPRAR>");
	       System.out.println("Introduce codigo");
	       // IMPLEMENTAR => se pone el producto y cuantos son
		   System.out.println("Introduce el codigo del producto:");
	        int codigo= leerEntero();
	        System.out.println("Introduzca cantidad que quiera vender:");
	        int cantidad = leerEntero();
	        Producto p = almacen.buscarProducto(codigo);
	        if (p != null && cantidad>0) {
	     	   p.setStock(p.getStock()+cantidad);
	        }else {
				System.out.println("No existe este producto y/o cantidad erronea");
	        }
	}

	private static void modificarPrecio() {
		 System.out.println("<MODIFICAR PRECIO>");
	       System.out.println("Introduzca un codigo");
	       // IMPLEMENTAR => busco producto y actualizo con set
		   int codigo= leerEntero();
	       Producto p = almacen.buscarProducto(codigo);
	       System.out.println("Introduzca el nuevo precio: ");
	       float precio = leerFloat();
	       if (precio>0) {
	       p.setPrecio(precio);
	       } else {
				System.out.println("precio erroneo");
	       }
		}
	
	//3 - Eliminar productos
	private static void borrar() {
		// TODO Auto-generated method stub
		System.out.println("<ELIMINAR>");
	      System.out.println("Introduzca un codigo: ");
	      // IMPLEMENTAR -> si esta se borra, si no, pues no se puede
		  int codigo = leerEntero();
		  //Confirmacion
		  System.out.println("Desea borrar el codigo? si esta seguro pulse 'S'");
		  String letra = sc.nextLine();
		  if("s".equals(letra.toLowerCase())){
	      if (almacen.borrarProducto(codigo)){
	    	  System.out.println("El producto ha sido borrado");
	      }else {
	          System.out.println("No se puede eliminar");    	  
	      	}
		  }
	}

	//2- Consultar productos
	private static void consultar() {
		   System.out.println("<CONSULTA>");
	       System.out.print("Introduzca codigo:");
	       int codigo = leerEntero();
	       Producto p = almacen.buscarProducto(codigo);
	       if ( p == null){
	           System.out.println("El producto no se encuentra en almacen");
	        }
	       else {
	           System.out.println("PRODUCTO "+p);
	        }
	}
	
	//1- Nuevos Productos
	private static void crear() {
		System.out.println("<NUEVO PRODUCTO>");
	       System.out.println("Introduzca un codigo: ");
	       int codigo = leerEntero();
	       System.out.println("Introduzca el nombre: ");
	       String nombre = sc.next();
	       Producto p = new Producto (codigo,nombre);
	       
	       //No supe implementar el stock
	       
	       //System.out.println("Introduzca Stock_min: ");
	       //int stock_min = leerEntero();
	       //p.setStock_min(stock_min);
		
	}

	
}