import java.util.*;

public class LevelOne {
    static final private String[] character = {"d","e","t","t","l","l","i"};
    static final private String[] correctAnswer = {"die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet", "edit", "idle", "lied", "tide", "tile", "tilt", "tilde", "tiled", "title", "tilted", "titled"};
    private int score = 0;

    public void Play() {
        // Stdin
        Scanner input = new Scanner(System.in);
        // shuffle random character
        Collections.shuffle(Arrays.asList(character));

        System.out.println("\nLevel 1");
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
                System.out.println("#Right. Score : " + this.getScore());
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

        if (this.getScore() > 70) {
            LevelTwo two = new LevelTwo(this.getScore());
            two.Play();
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
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
