import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LevelTwo {
    private int levelScore;
    private int accumulateScore;
    static final private String[] character = {"s","e","c","a","e","n"};
    static final private String[] correctAnswer = {"see", "sea", "seen", "ace", "aces", "acne", "acnes", "cane", "case", "cees", "cease", "ease", "eases", "encase", "scene", "secane", "sence", "sense", "sane", "scena"};

    public LevelTwo(int previousScore) {
        this.accumulateScore = previousScore;
    }

    public void Play() {
        // Stdin
        Scanner input = new Scanner(System.in);
        // shuffle random character
        Collections.shuffle(Arrays.asList(character));

        System.out.println("\nLevel 2");
        System.out.println("=======");

        // print random char
        for(String ch : character) System.out.printf("%5s%1s", "  ", ch);
        System.out.println();
        System.out.println();

        // loop 10x for guess the string
        ArrayList<String> answer = new ArrayList<>();
        int userCorrect = 0;
        for(int i = 1; i <= 10; i++) {
            String ans = "";

            do {
                System.out.printf("%s> %-12s : ", i, "Your Answer");
                ans = input.nextLine();
            } while (ans.length() < 3 || ans.length() > 6);

            if(answer.contains(ans)) {
                System.out.println("You had already type this word before..");
                i--;
                continue;
            }

            answer.add(ans);

            boolean correct = this.checkAnswer(ans);
            if(correct) {
                this.setScore(10);
                System.out.println("#Right. Score : " + this.getLevelScore());
                userCorrect++;
            }
        }

        System.out.println("\nYou had answered 10 times with " + userCorrect + " right answers..");

        System.out.println("\nCorrect Answers : ");
        for(String correct : correctAnswer) System.out.print(correct + " ");

        this.end();
    }

    private boolean checkAnswer(String answer) {
        boolean result = false;
        for(String correct : correctAnswer) {
            if(answer.equals(correct)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private void end() {
        System.out.println();

        if (this.getLevelScore() > 70) {
            LevelThree three = new LevelThree(this.getAccumulateScore());
            three.Play();
        } else {
            Scanner input = new Scanner(System.in);
            String repeat = "";
            do {
                System.out.println("\nYou Lose!! Try Again..");
                System.out.print("Do you want to retry [y/t] ? ");
                repeat = input.nextLine();
            } while (!repeat.equalsIgnoreCase("y") && !repeat.equalsIgnoreCase("t"));

            if(repeat.equalsIgnoreCase("y")) this.Play();
        }
    }

    public void setScore(int score) {
        this.levelScore += score;
        this.accumulateScore += score;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public int getAccumulateScore() {
        return accumulateScore;
    }
}
