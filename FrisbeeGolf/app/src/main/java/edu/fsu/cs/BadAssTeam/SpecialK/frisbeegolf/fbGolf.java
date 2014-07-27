package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

/**
 * Created by k on 7/19/14.
 */
class playerStruct{

    protected String playerName;
    protected int lNum;                //link (node) number
    protected int holeNum;          //total amount of holes
    protected int courseNum;
    protected int[] playerPutts;

    playerStruct(int lNum   , int num, int cN, String n){
        this.lNum = lNum;
        this.holeNum = num;
        this.courseNum = cN;
        this.playerName = n;
        this.playerPutts = new int [holeNum];
    }

    /*public String toString() {
        return holeNum + " " + courseNum + " " + playerName + " " + Arrays.toString(playerPutts);
    }*/
}

public class fbGolf{

    private int holeCount;
    protected int playerPutts[];
    protected String playerName;
    protected static int MAX_HOLES = 24;
    protected static int AVE_PAR = 3;
    private int courseNum;
    private playerStruct[] ll = new playerStruct[4];

    public fbGolf(int courseNum, String name1, String name2, String name3, String name4) {
        holeCount = getHoles(courseNum);
        ll[0] = (new playerStruct(0, holeCount, courseNum, name1));
        ll[1] = (new playerStruct(1, holeCount, courseNum, name2));
        ll[2] = (new playerStruct(2, holeCount, courseNum, name3));
        ll[3] = (new playerStruct(3, holeCount, courseNum, name4));
    }

    // 	j = Hole Number
    /*for(int j=0; j < holeCount; ++j){
        //	i = Player Number
        int par = getPar(courseNum, j);
        parSum += par;

            for(int i = 0; i < playerCount; ++i){

                int putts;

                System.out.printf("Player %d Turn\n", i);

                System.out.printf("Hole %d Par is %d\n\n", j, par);
                System.out.printf("Player %d Putts for hole %d: ",i, j );
                putts = in.nextInt();
                System.out.println();
                ll[i].playerPutts[j] = (int) putts;
            }

            for(int i = 0; i < playerCount; ++i){
                int score = 0;
                for(int k=0; k < holeCount; ++k){
                    score += ll[i].playerPutts[k];
                }
                score = score - parSum;
                System.out.printf("Player %d Score: %d\n",i, score);
            }
        }
    }*/

    public static int getHoles(int courseNumber){
        int holes;
        if(courseNumber == 1) //Tom Brown Course
            holes = 18;
        if(courseNumber == 2) //Jack McLean Course
            holes = 24;
        else
            holes = MAX_HOLES;
        return holes;
    }

    public static int getPar(int courseNumber, int holeNum) {
        int parNumber;
        if(courseNumber == 1){
            if (holeNum == 9)
                parNumber = 4;
            else
                parNumber = 3;
        }

        else if(courseNumber == 2){
            if (holeNum == 10 || holeNum == 16)
                parNumber = 4;
            else
                parNumber = 3;
        }

        else
            return AVE_PAR;
        return parNumber;
    }

    public void setPutts(int p, int hN, int s){
        int player = p;
        int holeNum = hN;
        int score = s;

        ll[player].playerPutts[holeNum] = score;

    }

    public int getPutts(int p, int hN){
        int player = p;
        int holeNum = hN;

        return ll[player].playerPutts[holeNum];
    }

    public int getTotalScore(int p){
        int player = p;
        int score = 0;

        for(int i = 0; i < ll.length; ++i){
            score += ll[player].playerPutts[i];
        }
        return score;
    }

    public void setZeroArray(int p){
        int player = p;

        for(int i = 0; i < ll.length; ++i){
            ll[player].playerPutts[i] = 0;
        }
    }
}

/* package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

/**
 * Created by k on 7/19/14.
 */

/*
public class fbGolf {

    protected int parArray[];
    protected int [][] playerArray;

    protected int MAX_PLAYERS = 4;
    protected int MAX_HOLES = 24;
    protected int AVE_PAR = 3;

//    @Override
//    protected void onCreate()

    public fbGolf(int courseNum){
        int holeCount = getHoles(courseNum);
        int playerCount = getPlayerCount();

        parArray = setParArray(courseNum);
        playerArray = setPlayerArray(holeCount, playerCount);

    }

    public int[][] setPlayerArray(int holeCount, int playerCount){
        for(int i=0; i<holeCount; ++i){
            for(int j=0; j<playerCount; ++j){
                playerArray[i][j] = 0;
            }
        }
        return playerArray;
    }

    public void setTurn(int score, int loc, int playerNum){
        playerArray[playerNum][loc]=score;
    }

    public int[] setParArray(int courseNumber){
        int holeCount = getHoles(courseNumber);
        for(int i=0; i<holeCount; ++i){
            parArray[i] = getPar(courseNumber, i);
        }
        return parArray;
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
}*/
