public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 2)
            throw new IllegalArgumentException("Wrong run format");
        String[] words = new String[args.length - 1];
        System.arraycopy(args, 1, words, 0, args.length - 1);
        Runner.run(args[0], words);
    }

}
