package com.company;

public class ElevatorCar extends Thread{
    int floor=0;

    public int getFloor() {
        return floor;
    }

    enum Tour {UP, DOWN};
    Tour tour = Tour.UP;
    enum Movement {STOP,MOVING};
    Movement movementState = Movement.STOP;


    public void run(){
        for(;;){
            System.out.println("--- floor " + floor + " --- tour " + tour + " --- movement " + movementState + " ---");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(floor == ElevatorStops.get().MAX_FLOOR){
                if(ElevatorStops.get().hasStopBelow(floor)){
                    movementState = Movement.MOVING;
                    tour = Tour.DOWN;
                }
                else{
                    movementState = Movement.STOP;
                    tour = Tour.DOWN;
                }
            }

            if(floor == ElevatorStops.get().MIN_FLOOR){
                if(ElevatorStops.get().hasStopAbove(floor)){
                    movementState = Movement.MOVING;
                    tour = Tour.UP;
                }
                else{
                    movementState = Movement.STOP;
                    tour = Tour.UP;
                }
            }


            if(movementState == Movement.MOVING) {
                if (tour == Tour.UP) {
                    if (ElevatorStops.get().whileMovingUpShouldStopAt(floor)) {
                        System.out.println("Stopped at " + floor);
                        ElevatorStops.get().clearStopUp(floor);
                        if(ElevatorStops.get().hasStopAbove(floor)){
                            floor++;
                        }
                        else if (ElevatorStops.get().hasStopBelow(floor)){
                            tour = Tour.DOWN;
                            floor--;
                        }
                        else {
                            movementState = Movement.STOP;
                        }
                    }
                    else if(floor == ElevatorStops.get().getMaxSetFloor()){
                        if(ElevatorStops.get().whileMovingDownShouldStopAt(floor)){
                            System.out.println("Stopped at " + floor);
                            ElevatorStops.get().clearStopDown(floor);
                            tour = Tour.DOWN;
                            floor--;
                        }
                    }
                    else {
                        floor++;
                    }
                }
                else {
                    if (ElevatorStops.get().whileMovingDownShouldStopAt(floor)) {
                        System.out.println("Stopped at " + floor);
                        ElevatorStops.get().clearStopDown(floor);
                        if(ElevatorStops.get().hasStopBelow(floor)){
                            floor--;

                        }
                        else if (ElevatorStops.get().hasStopAbove(floor)){
                            tour = Tour.UP;
                        }
                        else {
                            movementState = Movement.STOP;
                        }
                    }
                    else if(floor == ElevatorStops.get().getMinSetFloor()){
                        if(ElevatorStops.get().whileMovingUpShouldStopAt(floor)){
                            System.out.println("Stopped at " + floor);
                            ElevatorStops.get().clearStopUp(floor);
                            tour = Tour.UP;
                            floor++;
                        }
                    }
                    else {
                        floor--;
                    }
                }

            }

            else{
                if(ElevatorStops.get().hasStopAbove(floor)){
                    movementState = Movement.MOVING;
                    tour = Tour.UP;
                }
                else if(ElevatorStops.get().hasStopAbove(floor)){
                    movementState = Movement.MOVING;
                    tour = Tour.DOWN;
                }
                else {
                    movementState = Movement.STOP;
                }
            }

        }
    }
}
