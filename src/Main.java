public class Main {
    public static void main(String[] args){
        final int NUM_PRODUCERS = 5;
        // Escenario
        ColaConLimite buffer = new ColaConLimite();

        // Actores
        for (int i = 0; i <NUM_PRODUCERS;i++) {
            new Thread(new Productor(buffer)).start();
        }
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread tProductor = new Thread(productor);
        Thread tConsumidor = new Thread(consumidor);
        tProductor.start();
        tConsumidor.start();
    }
}