public class ColaConLimite {

    public static final int TAM=16;
    public int[] valores = new int[TAM];
    private int posicion=0;

    public synchronized void ponConBloqueo(int nuevoValor)throws InterruptedException{
        while(isFull())
            wait();
        notifyAll();
        valores[++posicion] = nuevoValor;
    }

    public synchronized int quitaConBloqueo()throws InterruptedException{
        while(isEmpty())
            wait();
        notifyAll();
        return valores[posicion--];
    }

    private boolean isFull(){
        return posicion == TAM-1;
    }

    public boolean isEmpty(){
        return posicion == -1;
    }
}
