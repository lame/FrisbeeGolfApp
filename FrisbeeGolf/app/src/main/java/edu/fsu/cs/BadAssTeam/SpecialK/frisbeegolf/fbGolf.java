package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

/**
 * Created by k on 7/19/14.
 */
public class fbGolf {

//    protected int
    



    protected int getHoles(int courseNumber){
        int holes;
        if(courseNumber == 1) //Tom Brown Course
            holes = 18;
        if(courseNumber == 2) //Jack McLean Course
            holes = 24;
        else
            holes = 0;

        return holes;
    }

    protected int getPar(int courseNumber, int holeNum) {
        int parNumber = 0;

        switch (courseNumber) {
            case 1: {
                if (holeNum == 9)
                    parNumber = 4;
                else
                    parNumber = 3;
            }
            case 2: {
                if (holeNum == 10 || holeNum == 16)
                    parNumber = 4;
                else
                    parNumber = 3;
            }
        }
        return parNumber;
    }
}
