import java.util.Random;

public class Cliente extends Thread{

    Pastel pastel;

    public Cliente(Pastel pastel){
        this.pastel = pastel;

    }

    @Override
    public void run(){

        Random random = new Random();
        System.out.println("- Cliente: Realizando pedido...");
        try {
            int tiempoPedido = 10000 + random.nextInt(10000); 
            System.out.println("Tiempo de pedido: " + Math.round(tiempoPedido/1000) + " segundos");
            Thread.sleep(tiempoPedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("- Cliente: Pedido listo.");
        pastel.hacerPedido();
    }
}
