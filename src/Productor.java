public class Productor implements Runnable {
    ColaConLimite buffer;
    public Productor(ColaConLimite buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int numeroNuevo;
        while(true){
            esperaUnSegundo();
            try{
                numeroNuevo = (int) (Math.random()*10)+1;
                this.buffer.ponConBloqueo(numeroNuevo);
                System.out.println(Thread.currentThread().getName()+"Numero generado"+numeroNuevo);
            } catch (InterruptedException e) {}
        }
}

    private static void esperaUnSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
