public class Consumidor implements Runnable {
    ColaConLimite buffer;

    public Consumidor(ColaConLimite buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            esperaUnSegundo();
            try{
                int leido = this.buffer.quitaConBloqueo();
                System.out.println("El número leído es: " + leido);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void esperaUnSegundo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
