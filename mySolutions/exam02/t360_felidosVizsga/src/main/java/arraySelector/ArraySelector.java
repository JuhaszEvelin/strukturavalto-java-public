package arraySelector;

public class ArraySelector {

    /**
     * Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat,
     * és egy szövegként összerak, szögletes zárójelek között!
     * <p>
     * A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros,
     * a második, azaz egyes indexű elem páratlan, stb.
     * <p>
     * Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
     */

    public static String selectEvens(int[] array) {
        String result = "";

        if (array.length != 0) {
            result += "[";
            for (int i = 0; i < array.length; i++) {

                if (i == 0) {
                    result += array[i];
                } else if (i % 2 == 0) {
                    result += ", " + array[i];
                }
            }
            result += "]";
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(selectEvens(new int[]{1}));

    }

}
