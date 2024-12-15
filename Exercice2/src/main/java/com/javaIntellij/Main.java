package com.javaIntellij;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        int[] array = {1,2,3,4,5,6,7,8,9,10};


        Sommeur sommeur1 = new Sommeur(array,0,array.length/3);
        Sommeur sommeur2 = new Sommeur(array,array.length / 3,2 * array.length / 3);
        Sommeur sommeur3 = new Sommeur(array,2 * array.length / 3, array.length);


        Thread thread1 = new Thread(sommeur1);
        Thread thread2 = new Thread(sommeur2);
        Thread thread3 = new Thread(sommeur3);
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("la somme du tableau est : " +(sommeur1.getSum()+sommeur2.getSum()+sommeur3.getSum()));


    }
}