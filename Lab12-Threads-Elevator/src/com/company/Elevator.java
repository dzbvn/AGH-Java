package com.company;

public class Elevator {
    // tworzymy 3 wątki
    static ElevatorCar car = new ElevatorCar();
    static ExternalPanelsAgent externalPanelAgent = new ExternalPanelsAgent(car);
    static InternalPanelAgent internalPanelAgent = new InternalPanelAgent(car);

    // symulacja przywołania windy z panelu zewnętrznego
    static void makeExternalCall(int atFloor,boolean directionUp){
        try {
            externalPanelAgent.input.put(new ExternalPanelsAgent.ExternalCall(atFloor,directionUp));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // symulacja wyboru pietra w panelu wewnętrznym
    static void makeInternalCall(int toFloor){
        try {
            internalPanelAgent.input.put(new InternalPanelAgent.InternalCall(toFloor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // uruchomienie wątków
    static void init(){
        car.start();
        externalPanelAgent.start();
        internalPanelAgent.start();
    }

    // miesjce na kod testowy
    public static void main(String[] args) throws InterruptedException {
        init();
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        //test6();
    }
    //sleep zmieniony na 3000 aby kolejnosc polecen byla zachowana(ktos najpierw wola winde z zewnatrz a potem wybiera pietro w srodku
    public static void test1() throws InterruptedException {
        makeExternalCall(4,false);
        Thread.currentThread().sleep(3000);
        makeInternalCall(2);
    }
    public static void test2() throws InterruptedException {
        //ktos wola na 8 i chce jechac na 4
        makeExternalCall(8,false);
        Thread.currentThread().sleep(3000);
        makeInternalCall(4);
        Thread.currentThread().sleep(3000);
        //ktos wola na 2 i chce jechac na 8
        makeExternalCall(2,false);
        Thread.currentThread().sleep(3000);
        makeInternalCall(8);

    }
    public static void test3() throws InterruptedException {
        //ktos wola na 8 i chce jechac na 4
        makeExternalCall(8,false);
        Thread.currentThread().sleep(3000);
        makeInternalCall(4);
        Thread.currentThread().sleep(3000);
        //ktos wola na 2 i chce jechac na 8
        makeExternalCall(2,true);
        Thread.currentThread().sleep(3000);
        makeInternalCall(8);

    }

    public static void test4() throws InterruptedException{
        //na 5 pietrze czekaja 2 osoby, jedna jedzie na 7, druga na 8, na 8 wsiada osoba jadaca na 1 pietro
        makeExternalCall(5, true);
        Thread.currentThread().sleep(3000);
        makeInternalCall(7);
        Thread.currentThread().sleep(100);
        makeInternalCall(8);
        Thread.currentThread().sleep(100);
        makeInternalCall(1);
        Thread.currentThread().sleep(100);
        //ktos zamowil winde na parter
        makeExternalCall(0, true);
    }

    public static void test5() throws InterruptedException{
        //na 3 pietrze wsiadaja 4 osoby, jada 5, 6, 7 i 2 pietro
        //(klikniety przycisk w gore)
        makeExternalCall(3, true);
        Thread.currentThread().sleep(3000);
        makeInternalCall(7);
        Thread.currentThread().sleep(50);
        makeInternalCall(5);
        Thread.currentThread().sleep(50);
        makeInternalCall(6);
        Thread.currentThread().sleep(50);
        makeInternalCall(2);
    }

    public static void test6() throws InterruptedException{
        //ktos z parteru jedzie na 7 pietro, nastepnie winda zostaje przywolana na 5 pietro i wsiadaja osoby jadace na 2, 4 i 8 pietro
        //(klikniety przycisk w dol)
        makeInternalCall(7);
        Thread.currentThread().sleep(2000);
        makeExternalCall(5, false);
        Thread.currentThread().sleep(3000);
        makeInternalCall(8);
        Thread.currentThread().sleep(50);
        makeInternalCall(4);
        Thread.currentThread().sleep(50);
        makeInternalCall(2);

    }





}
