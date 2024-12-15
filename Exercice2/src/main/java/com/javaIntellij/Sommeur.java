package com.javaIntellij;

public class Sommeur implements Runnable{
    private int[] tab;
    private int debut;
    private int fin;
    private int sum;
    public Sommeur(int[] tab, int debut, int fin) {
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
        this.sum = 0;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public void run() {
        for (int i = this.debut; i < this.fin; i++) {
            this.sum += tab[i];
        }
    }
}
