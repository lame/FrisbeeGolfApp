package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

/**
 * Created by k on 7/19/14.
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

class playerStruct{

    protected String playerName;
    protected int holeNum;
    protected int courseNum;
    protected int[] playerPutts;

    playerStruct(int num, int cN, String n){
        this.holeNum = num;
        this.courseNum = cN;
        this.playerName = n;
        this.playerPutts = new int [holeNum];
    }

    public String toString() {
        return holeNum + " " + courseNum + " " + playerName + " " + Arrays.toString(playerPutts);
    }
}

public class Player{

    protected int playerPutts[];

    protected String playerName;
    protected static int MAX_HOLES = 24;
    protected static int AVE_PAR = 3;

    private int courseNum;

    public static void main(String args[]){

        LinkedList <playerStruct> ll = new LinkedList <playerStruct>();

        int parSum = 0;
        int score = 0;
        int holeCount;
        int courseNum;
        int playerNum;
        String name;

        Scanner in = new Scanner(System.in);

        System.out.printf("What course are you at:\n");
        courseNum = in.nextInt();
        in.nextLine();
        holeCount = getHoles(courseNum);

        System.out.printf("How many players?\n");
        playerNum = in.nextInt();
        in.nextLine();

        for(int i = 0; i<playerNum; ++i){
            System.out.printf("Player %d Name:\n", i+1);
            name = in.nextLine();

            ll.add(new playerStruct(holeCount, courseNum, name));
        }

        for(playerStruct element : ll){
            System.out.println(element + "\n");
        }

        System.out.printf("\n\n\n\n\n START GAME\n\n\n");
        // 	j = Hole Number
        for(int j=0; j < holeCount; ++j){
            //	i = Player Number
            int par = getPar(courseNum, j);
            parSum += par;

            for(int i = 0; i < playerNum; ++i){

                int putts;

                System.out.printf("Player %d Turn\n", i);

                System.out.printf("Hole %d Par is %d\n\n", j, par);
                System.out.printf("Player %d Putts for hole %d: ",i, j );
                putts = in.nextInt();
                //ll.set(i.playerPutts[j], (int) putts);

                System.out.printf("\n\n");
            }

            System.out.printf("LEADERBOARD\n\n");

            for(int i = 0; i < playerNum; ++i){
                for(int k=0; k < holeCount; ++k){
                   // score += ll.get(i.playerPutts[k]);
                }
                score = score - parSum;
                System.out.printf("Player %d Score: %d",i, score);
            }
        }
    }

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
}