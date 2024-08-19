import java.util.Random;

public class Pastelero extends Thread{

    Pastel pastel;

    public Pastelero(Pastel pastel){
        this.pastel = pastel;
    }

    @Override
    public void run(){

        // Esperar que el cliente termine de crear el pastel
        boolean flag = true;
        while(flag){
            System.out.println("Pastelero revisando el pedido...");
            if(pastel.consultarDetallesPedido() == -1){
                System.out.println("Aún no hay un pedido para preparar. Esperando...");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Pedido listo para preparar.");
                flag = false;
            }
        }

        // Preparar pastel
        Random random = new Random();
        System.out.println("Preparando pastel...");
        try {
            int tiempoPreparacion = 5000 + random.nextInt(10000); 
            System.out.println("Tiempo de preparación: " + tiempoPreparacion + "ms");
            Thread.sleep(tiempoPreparacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Pastel listo.");

    }

}
