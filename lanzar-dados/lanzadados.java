package lanzadado;
/**
 *
 * @author Javier Vega
 */
public class LanzaDado {

    public static void lanzarDado(){
        int numDado = (int) (Math.random()*6+1);
        System.out.println("El resultado del dado es: " + numDado + "\n");
    }
    
    public static void main(String[] args) {
        lanzarDado();
    }
    
}
