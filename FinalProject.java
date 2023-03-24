import java.awt.*;
import javax.swing.JTextField;

/*
 1. Use try-catch exception handling 
 */

public class FinalProject {
    public static void main(String[] args) {
        DrawingPanel p = new DrawingPanel(500, 500);
        p.setBackground(Color.CYAN);
        Graphics g = p.getGraphics();
        g.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        g.drawString("Let's Play!", 182, 150);
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));
        g.drawString("DOMINOES!", 182, 200);
        g.setColor(Color.RED);
        g.fillRoundRect(129, 280, 100, 150, 40, 20);
        g.setColor(Color.BLACK);
        g.drawLine(129, 355, 229, 355);

        int y = 290;
        for (int i = 0; i < 4; i++) {
            g.fillArc(200, y, 20, 20, 0, 360);
            g.fillArc(140, y, 20, 20, 0, 360);
            y = y + 40;

        }

        g.setColor(Color.MAGENTA);

        int x = 241;
        g.fillRoundRect(230, 310, 150, 100, 40, 20);
        g.setColor(Color.BLACK);
        g.drawLine(304, 314, 304, 407);

        for (int i = 0; i < 2; i++) {
            g.fillArc(x, 323, 20, 20, 0, 360);
            g.fillArc(x, 380, 20, 20, 0, 360);
            x = x + 40;

        }

        x = 310;
        for (int i = 0; i < 3; i++) {
            g.fillArc(x, 323, 20, 20, 0, 360);
            g.fillArc(x, 380, 20, 20, 0, 360);
            x = x + 25;
        }
        java.util.Scanner n = new java.util.Scanner(System.in);
        System.out.println("State your names players!");
        String namespl1=n.nextLine();
        String namespl2=n.nextLine();
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));
        g.drawString("Welcome ".toUpperCase() + namespl1.toUpperCase() + " & "+ namespl2.toUpperCase() + " !", 33, 464);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int[][] domino = new int[7][];
        int r = domino.length + 1;

        for (int i = 0; i < domino.length; i++) {
            domino[i] = new int[r];
            r = r - 1;
        }

        for (int i = 0; i < domino.length; i++) {
            domino[i][0] = i;
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < domino.length; i++) {
            for (int c = 1; c < domino[i].length; c++) {
                a = domino[i][0] + b;
                domino[i][c] = a;
                b = b + 1;
            }
            b = 0;
        }

        Dominoes[] dominoes = new Dominoes[28];
        int top = 0;
        int bot = 0;

        int u = 0;
        for (int l = 0; l < dominoes.length; l++) {
            for (int i = 0; i < domino.length; i++) {
                for (int c = 1; c < domino[i].length; c++) {
                    top = domino[i][0];
                    bot = domino[top][c];
                    dominoes[u] = new Dominoes(top, bot);
                    if (u < 27) {
                        u = u + 1;
                    }
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Player[] player1 = new Player[14];
        Player[] player2 = new Player[14];
        Dominoes[] dominoes1 = new Dominoes[28];
        dominoes1 = shuffle(dominoes);

        for (int i = 0; i < player1.length; i++) {
            player1[i] = new Player(dominoes1[i], 0);
        }

        int sub = 1;
        int index = dominoes.length - 1;

        for (int i = 0; i < player2.length; i++) {
            player2[i] = new Player(dominoes1[index], 0);
            index = index - sub;
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean pl1st = false;
        boolean pl2st = false;

        Player prev;


        java.util.Scanner scan = new java.util.Scanner(System.in);

        int d = 0;
        int z = 1;
        int pl1count = 0;
        int pl2count = 0;
        boolean pl1 = true;
        boolean pl2 = false;
        boolean stale = false;
        boolean stale2 = true;
        set(player1);
        System.out.println("Pick the first domino");
        int startdomin = scan.nextInt();
        prev = player1[startdomin];
        prev.order++;
        pl1count++;
        System.out.println(prev.getset().dom());

        set2(player2);
        prev = choicep2(player2, prev);
        prev.order++;
        pl2count++;
        System.out.println(prev.getset().dom());
        int exit = 0;
        for (int i = 0; i < player1.length - 1; i++) {
            while (exit != 1) {
                while (pl1) {
                    set(player1);
                    if (pl1pog(player1, prev).equals("Go")) {
                        prev = choicep1(player1, prev);
                        prev.order++;
                        System.out.println(prev.getset().dom());
                        pl1count++;
                        if (pl1count == 14) {
                            System.out.println("Game Over! \nPlayer 1 WINS!");
                            exit = 1;
                        }
                        stale=false;
                        pl1 = false;
                        pl2 = true;
                    } else {
                        System.out.println("\nPlayer 1 has to pass");
                        stale = true;
                        pl2 = true;
                        pl1 = false;
                    }
                }
                while (pl2) {
                    set2(player2);
                    if (pl2pog(player2, prev).equals("Go")) {
                        prev = choicep2(player2, prev);
                        prev.order++;
                        System.out.println(prev.getset().dom());
                        pl2count++;
                        if (pl1count == 14) {
                            System.out.println("Game Over! \nPlayer 2 WINS!");
                            exit = 1;

                        }
                        stale2=false;
                        pl2 = false;
                        pl1 = true;
                    } else {
                        System.out.println("\nPlayer 2 has to pass");
                        stale2 = true;
                        pl1 = true;
                        pl2 = false;
                    }
                }
                if (stale && stale2) {
                    if (pl1count == pl2count) {
                        System.out.println("\nNo one wins\n Start Over");
                        exit = 1;
                    } else if (pl1count > pl2count) {
                        System.out.println("\nPlayer 1 WINS!");
                        exit = 1;
                    } else {
                        System.out.println("\nPlayer 2 WINS!");
                        exit = 1;
                    }
                }

            }
        }
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static Dominoes[] shuffle(Dominoes[] a) {
        for (int i = a.length - 1; i > 0; i--)
            swap(a, i, (int) (Math.random() * (i + 1)));
        return a;
    }

    static void swap(Dominoes[] a, int i, int j) {
        Dominoes temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static String pl1pog(Player[] player1, Player prev) {
        int count = 0;
        int count2 = 0;
        String dec = "";
        for (int i = 0; i < player1.length; i++) {
            if (player1[i].getset().getbottom() == prev.getset().getbottom() || player1[i].getset().gettop() == prev.getset().gettop() || player1[i].getset().getbottom() == prev.getset().gettop() || player1[i].getset().gettop() == prev.getset().getbottom()) {
                count++;
            }

        }

        for (int i = 0; i < player1.length; i++) {
            if (player1[i].getset().getbottom() == prev.getset().getbottom() || player1[i].getset().gettop() == prev.getset().gettop() || player1[i].getset().getbottom() == prev.getset().gettop() || player1[i].getset().gettop() == prev.getset().getbottom()) {
                if (player1[i].order == 1) {
                    count2++;
                }
            }
        }
        if (count != count2) {
            dec = "Go";
        } else {
            dec = "Pass";
        }
        return dec;
    }

    static String pl2pog(Player[] player2, Player prev) {
        int count = 0;
        int count2 = 0;
        String dec = "";
        for (int i = 0; i < player2.length; i++) {
            if (player2[i].getset().getbottom() == prev.getset().getbottom() || player2[i].getset().gettop() == prev.getset().gettop() || player2[i].getset().getbottom() == prev.getset().gettop() || player2[i].getset().gettop() == prev.getset().getbottom()) {
                count++;
            }

        }

        for (int i = 0; i < player2.length; i++) {
            if (player2[i].getset().getbottom() == prev.getset().getbottom() || player2[i].getset().gettop() == prev.getset().gettop() || player2[i].getset().getbottom() == prev.getset().gettop() || player2[i].getset().gettop() == prev.getset().getbottom()) {
                if (player2[i].order == 1) {
                    count2++;
                }
            }
        }
        if (count != count2) {
            dec = "Go";
        } else {
            dec = "Pass";
        }
        return dec;
    }


    static Player choicep1(Player[] player1, Player prev) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int indexchoice;
        boolean fine = true;
        boolean fine1 = true;
        Player a = new Player(new Dominoes(0, 0), 1);
        System.out.println("\nYou need to match " + prev.getset().dom() + "\nPlayer 1 what is your choice?");
        indexchoice = scan.nextInt();

        while (fine) {
            if (player1[indexchoice].getset().getbottom() == prev.getset().getbottom() || player1[indexchoice].getset().gettop() == prev.getset().gettop() || player1[indexchoice].getset().getbottom() == prev.getset().gettop() || player1[indexchoice].getset().gettop() == prev.getset().getbottom()) {
                if (player1[indexchoice].order == 0) {
                    a = player1[indexchoice];
                    fine = false;
                }
            }
            if (fine) {
                System.out.println("\nThis was used or invalid");
                System.out.println("\nYou need to match " + prev.getset().dom() + "\nPlayer 1 what is your choice?");
                indexchoice = scan.nextInt();
                fine = true;

            }
        }

        return a;
    }


    static Player choicep2(Player[] player2, Player prev) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int indexchoice;
        boolean fine = true;
        boolean fine1 = true;
        Player a = new Player(new Dominoes(0, 0), 1);
        System.out.println("\nYou need to match " + prev.getset().dom() + "\nPlayer 2 what is your choice?");
        indexchoice = scan.nextInt();

        while (fine) {
            if (player2[indexchoice].getset().getbottom() == prev.getset().getbottom() || player2[indexchoice].getset().gettop() == prev.getset().gettop() || player2[indexchoice].getset().getbottom() == prev.getset().gettop() || player2[indexchoice].getset().gettop() == prev.getset().getbottom()) {
                if (player2[indexchoice].order == 0) {
                    a = player2[indexchoice];
                    fine = false;

                }
            }
            if (fine) {
                System.out.println("\nThis was used or invalid");
                System.out.println("\nYou need to match " + prev.getset().dom() + "\nPlayer 2 what is your choice?");
                indexchoice = scan.nextInt();
                fine = true;
            }

        }
        return a;
    }

    static void set(Player[] player1) {
        System.out.println("\nPlayer 1, your set is:");
        for (int l = 0; l < player1.length; l++) {
            System.out.println("Index: " + l + " " + player1[l].getset().dom());
        }
        System.out.println("\nThese have already been used: ");
        for (int l = 0; l < player1.length; l++) {
            if (player1[l].getorder() == 1) {
                System.out.println("Index: " + l + " " + player1[l].getset().dom());

            }
        }
    }


    static void set2(Player[] player2) {
        System.out.println("\nPlayer 2, your set is:");
        for (int l = 0; l < player2.length; l++) {
            System.out.println("Index: " + l + " " + player2[l].getset().dom());
        }
        System.out.println("\nThese have already been used: ");
        for (int l = 0; l < player2.length; l++) {
            if (player2[l].getorder() == 1) {
                System.out.println("Index: " + l + " " + player2[l].getset().dom());
            }
        }

    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Player {
    public Dominoes set;
    public int order;

    public Player(Dominoes _set, int _order) {
        set = _set;
        order = _order;
    }

    public Dominoes getset() {
        return set;
    }

    public int getorder() {
        return order;
    }
}

class Dominoes {
    public int top;
    public int bottom;

    public Dominoes(int _top, int _bottom) {
        top = _top;
        bottom = _bottom;
    }

    public int gettop() {
        return top;
    }

    public int getbottom() {
        return bottom;
    }

    public String dom() {
        return "Top: " + top + " " + "Bottom: " + bottom + " ";
    }

}
/*
Im making a dominoes game
So far I've made to so that I know my 28 different domino pieces
The next step will be to create two players, and I intend to do that using a class maybe
Then I will have the game appear on the drawing screen
 */



