import java.util.Random;
import java.util.Scanner;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class DiceRoller {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    //IO System
    static Scanner reader = new Scanner(System.in);

    //Attributes
    final static int willpower = 5;
    final static int logic = 8;
    final static int intuition = 5;
    final static int reaction = 4;
    final static int edgeStat = 3;

    //Skills
    final static int cybercombat = 5;
    final static int eWarfare = 5;
    final static int hacking = 5;
    final static int computer = 6;
    final static int hardware = 6;
    final static int software = 6;

    static String rollOut = "";

    private DiceRoller() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(
                "WELCOME TO THE NET CHUMMER! HOW ARE YOU GOING TO HACK TODAY?");
        deck();
    }

    private static void deck() {
        int hackCatChoice = catChoicePrompt();

        if (hackCatChoice == -1) {
            System.out.println("GOODBYE");
            System.exit(0);
        }

        else if (hackCatChoice == 1) {
            int attackChoice = attackChoice();
            while (attackChoice != -1) {
                if (attackChoice == 1 || attackChoice == 3
                        || attackChoice == 4) {
                    hackShit(logic + cybercombat);
                    attackChoice = attackChoice();
                } else if (attackChoice == 2) {
                    hackShit(hacking + logic);
                    attackChoice = attackChoice();
                } else if (attackChoice == 5) {
                    hackShit(computer + logic);
                    attackChoice = attackChoice();
                } else if (attackChoice == 6) {
                    hackShit(eWarfare + logic);
                    attackChoice = attackChoice();
                } else {
                    System.out.println("ERR 0xP3:8K:AC");
                    System.out.println("INVALID OPTION SELECTED");
                    System.out.println(
                            "PLEASE SELECT AGAIN FROM THE FOLLOWING LIST: ");
                    attackChoice = attackChoice();
                }
            }
        }
        //SLEAZE
        else if (hackCatChoice == 2) {
            int sleazeChoice = sleazeChoice();
            while (sleazeChoice != -1) {
                if (sleazeChoice == 1) { //Check Overwatch
                    hackShit(logic + eWarfare);
                    sleazeChoice = sleazeChoice();
                } else if (sleazeChoice == 2 || sleazeChoice == 5
                        || sleazeChoice == 7) { //Control Device OR Hide OR Snoop
                    hackShit(eWarfare + intuition);
                    sleazeChoice = sleazeChoice();
                } else if (sleazeChoice == 3) { //Format Device
                    hackShit(computer + logic);
                    sleazeChoice = sleazeChoice();
                } else if (sleazeChoice == 4) { //Hack On The Fly
                    hackShit(hacking + logic);
                    sleazeChoice = sleazeChoice();
                } else if (sleazeChoice == 6) { //Data Bomb
                    hackShit(software + logic);
                    sleazeChoice = sleazeChoice();
                } else if (sleazeChoice == 8) { //Spoof Command
                    hackShit(hacking + intuition);
                    sleazeChoice = sleazeChoice();
                } else {
                    System.out.println("ERR 0xP3:8K:AC");
                    System.out.println("INVALID OPTION SELECTED");
                    System.out.println(
                            "PLEASE SELECT AGAIN FROM THE FOLLOWING LIST: ");
                    sleazeChoice = sleazeChoice();
                }
            }

        }
        //DATA PROCESSING
        else if (hackCatChoice == 3) {
            int dataChoice = dataChoice();
            while (dataChoice != -1) {
                if (dataChoice == 1 || dataChoice == 5) {
                    hackShit(logic + computer); //Edit file OR Reboot Device
                    dataChoice = dataChoice();
                } else if (dataChoice == 2) {
                    hackShit(eWarfare + logic); //Enter Rigged Device
                    dataChoice = dataChoice();
                } else if (dataChoice == 3 || dataChoice == 4
                        || dataChoice == 6) {
                    hackShit(computer + intuition); //Matrix Perception OR Matrix Search OR Trace Icon
                    dataChoice = dataChoice();
                } else {
                    System.out.println("ERR 0xP3:8K:AC");
                    System.out.println("INVALID OPTION SELECTED");
                    System.out.println(
                            "PLEASE SELECT AGAIN FROM THE FOLLOWING LIST: ");
                    dataChoice = dataChoice();
                }
            }

        }

        else if (hackCatChoice == 4) {
            System.out.println("HOW LONG DO YOU HAVE TO CODE?");
            int time_limit = reader.nextInt();

            System.out.println(
                    "HOW DIFFICULT IS THE CODING (THRESHOLD OF TEST)?");
            int goal = reader.nextInt();

            if (time_limit == 0 || goal == 0) {
                System.out.println(
                        "YOU'RE NOT FASTJACK, YOU CAN'T BREAK MATH...");
                deck();
            } else {
                int progress = 0;
                int time = 0;

                while (progress < goal && time <= time_limit) {
                    int store = coding(software + logic);
                    if (store < 0) {
                        if (store == -2) {
                            System.out.println(
                                    "A CRITICAL ERROR HAS OCCURED. ALL SOFTWARE PROGRESS HAS BEEN LOST");
                            progress = 0;
                        } else if (store == -1) {
                            System.out.println(
                                    "PROGRAM HAS DETECTED CORRUPTED SECTORS ON DISK, SOME DATA MAY BE UNRECOVERABLE");
                            progress /= 2;
                        }
                    } else {
                        progress += store;
                    }
                    System.out.println(
                            "DAY " + time + ": " + progress + "/" + goal);
                    time++;
                }
                if (time > time_limit && progress < goal) {
                    System.out.println(
                            "SUFFICIENT PROGRESS NOT OBTAINED IN PROVIDED TIME FRAME");
                } else {
                    System.out.println("CODING COMPLETED ON DAY " + time);
                }
            }
        }

        else

        {
            System.out.println("YOU HAVE REACHED THE FORBIDDEN ZONE. GO AWAY");
            deck();
        }

        deck();

    }

    private static int coding(int numDice) {
        int hitCount = 0;
        int glitch = 0;
        Random edge = new Random();
        for (int i = 1; i <= numDice; i++) {
            int roll = edge.nextInt(6) + 1;
            if (roll >= 5) {
                hitCount++;
            } else if (roll == 1) {
                glitch++;
            }
        }
        if (glitch > numDice / 2) {
            if (hitCount == 0) {
                return -2; //CRITICAL GLITCH, YOU'RE FUCKED
            } else {
                return -1; //GLITCH, THAT AIN'T GOOD
            }
        }

        return hitCount;
    }

    private static int catChoicePrompt() {
        System.out.println("(1) SMASH THE FRONT DOOR"); //Attack
        System.out.println("(2) SNEAK THROUGH THE BACK DOOR"); //Sleaze
        System.out.println("(3) PROCESS THE DATA"); //Data Processing
        System.out.println("(4) CODE SOME WIZ SOFTWARE"); //Software coding

        System.out.println("(-1) JACK OUT");

        int choice = reader.nextInt();
        return choice;
    }

    private static int attackChoice() {
        System.out.println("CHOOSE YOUR ATTACK:");
        System.out.println("(1) BRUTE FORCE");
        System.out.println("(2) CRACK FILE");
        System.out.println("(3) CRASH PROGRAM");
        System.out.println("(4) DATA SPIKE");
        System.out.println("(5) ERASE MARK");
        System.out.println("(6) JAM SIGNALS");
        System.out.println("(-1) CHANGE HACKING MODE");

        int choice2 = reader.nextInt();
        return choice2;
    }

    private static int sleazeChoice() {
        System.out.println("HOW ARE YOU SKULKING:");
        System.out.println("(1) CHECK OVERWATCH SCORE");
        System.out.println("(2) CONTROL DEVICE");
        System.out.println("(3) FORMAT DEVICE");
        System.out.println("(4) HACK ON THE FLY");
        System.out.println("(5) HIDE");
        System.out.println("(6) SET DATA BOMB");
        System.out.println("(7) SNOOP");
        System.out.println("(8) SPOOF COMMAND");
        System.out.println("(-1) CHANGE HACKING MODE");

        int choice2 = reader.nextInt();
        return choice2;
    }

    private static int dataChoice() {
        System.out.println("CHOOSE YOUR METHOD:");
        System.out.println("(1) EDIT FILE");
        System.out.println("(2) ENTER RIGGED DEVICE");
        System.out.println("(3) MATRIX PERCEPTION");
        System.out.println("(4) MATRIX SEARCH");
        System.out.println("(5) REBOOT DEVICE");
        System.out.println("(6) TRACE ICON");
        System.out.println("(-1) CHANGE HACKING MODE");

        int choice2 = reader.nextInt();
        return choice2;
    }

    private static void hackShit(int dice) {
        int hitCount = 0;

        String preEdge = "Would you like to pre-edge this roll? Enter 'yes' or 'no'.";
        String preEdgeCheck = "";
        String postEdge = "Would you like to post-edge this roll? Enter 'yes' or 'no'.";
        String postEdgeCheck = "";

        System.out.println(preEdge);
        while (preEdgeCheck.equals("")) {
            System.out.println("?");
            preEdgeCheck = reader.nextLine();
        }
        System.out.println();

        if (preEdgeCheck.equals("yes")) {
            dice += edgeStat;
        }

        Random edge = new Random();
        hitCount = rollDice(edge, dice, hitCount, preEdgeCheck);

        System.out.println(rollOut);
        System.out.println(hitCount + " hits scored on " + dice + " rolls");
        System.out.println();
        if (preEdgeCheck.equals("no")) {
            System.out.println(postEdge);
            postEdgeCheck = reader.nextLine();
            if (postEdgeCheck.equals("yes")) {
                hitCount = rollDice(edge, dice - hitCount, hitCount,
                        preEdgeCheck);
                System.out.println(
                        hitCount + " hits scored on " + dice + " rolls");
                System.out.println();
            }

        }
    }

    private static int rollDice(Random edge, int dice, int hitCount,
            String preEdgeCheck) {
        rollOut = "(";
        for (int i = 1; i <= dice; i++) {
            int roll = edge.nextInt(6) + 1;
            if (roll >= 5) {
                rollOut += "!" + roll;
                hitCount++;
            } else {
                rollOut += roll;
            }
            if (preEdgeCheck.equals("yes")) {
                if (roll == 6) {
                    rollOut += "(";
                    while (roll == 6) {
                        roll = edge.nextInt(6) + 1;
                        if (roll >= 5) {
                            rollOut += "!" + roll + " ";
                            hitCount++;
                        } else {
                            rollOut += roll;
                        }
                    }
                    rollOut += ")";
                }
            }
            rollOut += ", ";
        }
        rollOut += ")";
        return hitCount;
    }
}
