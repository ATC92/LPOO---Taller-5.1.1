import java.io.*;

class Producto implements Serializable {
    // Atributos
    private String name;
    private double precio;
    // Constructor
    public Producto(String name, double precio){
        this.name = name;
        this.precio = precio;
    }
    // Setters
    void setNombre(String name){this.name = name;}
    void setPrecio(double precio){this.precio =  precio;}
    // Getters
    String getNombre(){return name;}
    double getPrecio(){return precio;}
}

public class Serializacion{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Objeto a serializar
        Producto producto = new Producto("Laptop", 1000.0);

        // Serialización
        FileOutputStream fileOutputStream = new FileOutputStream("producto.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(producto);
        oos.flush();
        oos.close();

        // Deserialización
        FileInputStream fileInputStream= new FileInputStream("producto.ser");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Producto productoDeserializado = (Producto) ois.readObject();
        ois.close();

        System.out.println("Producto: " + productoDeserializado.getNombre());
        System.out.println("Precio: " + productoDeserializado.getPrecio());

        // Comparar los objetos
        if (productoDeserializado.getPrecio() == producto.getPrecio()
                && productoDeserializado.getNombre().equals(producto.getNombre())) {
            System.out.println("Los objetos son iguales.");
        } else {
            System.out.println("Los objetos son diferentes.");
        }
    }
}


