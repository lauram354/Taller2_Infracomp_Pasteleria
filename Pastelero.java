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

            System.out.println(horaActual() + " Pastelero: Revisando el pedido...");


            if(pastel.consultarDetallesPedido() == -1){

                System.out.println(horaActual() + " Pastelero: Aún no hay un pedido para preparar, volveré a revisar en 5 segundos");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else{
                
                flag = false;
            }
        }

        // Preparar pastel
        Random random = new Random();
        System.out.println(horaActual() + " Pastelero: Preparando pastel...");
        try {
            int tiempoPreparacion = 5000 + random.nextInt(10000); 
            System.out.println("Tiempo de preparación: " + Math.round(tiempoPreparacion/1000) + " segundos");
            Thread.sleep(tiempoPreparacion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(horaActual() + " Pastelero: Pastel listo.");
        synchronized(pastel){
            pastel.notify();
        }

    }

    public String horaActual(){
        return java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
