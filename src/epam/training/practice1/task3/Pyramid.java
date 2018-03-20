public class Pyramid {
    private int [][] pyramid;

    private Pyramid(int[][] pyramid){
        this.pyramid = pyramid;
    }

    /**
     * Create object of {@code Pyramid} class
     * @param depth depth of pyramid, not bigger than 9, and not less then 0
     * @return {@code Pyramid} with specified depth
     */
    static Pyramid construct(int depth) {
        if (depth < 1 || depth > 9)
            throw new IllegalArgumentException();
        int[][] pyr = new int[depth][];
        for (int i = 0; i < depth; i++) {
            pyr[i] = new int[i * 2 + 1];
        }

        for (int i = 0; i < pyr.length; i++) {
            int n = 1;
            for (int j = 0; j < pyr[i].length; j++) {
                pyr[i][j] = n;
                if (j >= pyr[i].length / 2) /* after the center or center */
                    n--;
                else
                    n++;
            }
        }
        return new Pyramid(pyr);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int baseSize = pyramid[pyramid.length - 1].length;
        for (int i = 0; i < pyramid.length; i++) {   /*    spaces Elements spaces*/
            int spaceAmount = (baseSize - pyramid[i].length) / 2;

            builder.append(spaces(spaceAmount));

            for (int j = 0; j < pyramid[i].length; j++) { /* Elements*/
                builder.append(pyramid[i][j]);
            }

            builder.append(spaces(spaceAmount));
            builder.append('\n');
        }
        return new String(builder);
    }

    private StringBuilder spaces(int amount){
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            spaces.append(" ");
        }
        return spaces;
    }
}