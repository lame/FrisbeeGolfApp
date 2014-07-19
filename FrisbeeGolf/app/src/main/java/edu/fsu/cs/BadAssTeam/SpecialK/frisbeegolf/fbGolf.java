package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

/**
 * Created by k on 7/19/14.
 */
public class fbGolf {

    protected int parArray[];
    protected int [][] playerArray;

    protected int MAX_PLAYERS = 4;
    protected int MAX_HOLES = 24;
    protected int AVE_PAR = 3;

//    @Override
//    protected void onCreate()

    public void setTurn(int score, int loc, int playerNum){
        playerArray[playerNum][loc]=score;
    }

    public int getHoles(int courseNumber){
        int holes;
        if(courseNumber == 1) //Tom Brown Course
            holes = 18;
        if(courseNumber == 2) //Jack McLean Course
            holes = 24;
        else
            holes = MAX_HOLES;

        return holes;
    }

    public int getPar(int courseNumber, int holeNum) {
        int parNumber;

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
            default:
                parNumber=AVE_PAR;
        }
        return parNumber;
    }

    public int getPlayerCount(){
        int playerCount;
        playerCount = MAX_PLAYERS;

        return playerCount;
    }
}
