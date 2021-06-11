package com.ida.Phaser;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties)
    {
        switch(phase) {
            case 0:
                return studentArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean studentArrived() {
        System.out.println("全部考生都已做好准备，考生人数：" + getRegisteredParties());
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.println("所有考生都已完成第1题");
        return false;
    }


    private boolean finishSecondExercise() {
        System.out.println("所有考生都已完成第2题");
        return false;
    }

    private boolean finishExam() {
        System.out.println("所有考生都已完成第3题，结束考试！");
        return true;
    }

}
