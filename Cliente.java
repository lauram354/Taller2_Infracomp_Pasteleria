import java.util.Random;

public class Cliente extends Thread{

    Pastel pastel;

    public Cliente(Pastel pastel){
        this.pastel = pastel;

    }

    @Override
    public void run(){

        Random random = new Random();
        System.out.println( horaActual() + " Cliente: Realizando pedido...");
        
        try {
            int tiempoPedido = 3000 + random.nextInt(10000); 
            System.out.println("Tiempo de pedido: " + Math.round(tiempoPedido/1000) + " segundos");
            Thread.sleep(tiempoPedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(horaActual() + " Cliente: Pedido listo.");
        pastel.hacerPedido();

        synchronized(pastel){
            try {
                pastel.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(horaActual() + " Cliente: Pastel recibido.");
    }

    public String horaActual(){
        return java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
