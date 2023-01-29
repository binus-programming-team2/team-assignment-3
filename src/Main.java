public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("Coepoe Word Puzzle");
        System.out.println("==================");
        rules();

        LevelOne one = new LevelOne();
        one.Play();
    }

    private static void rules() {
        System.out.println("\nRules : ");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each level, you have 10 chances to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 points each level.");
    }
}