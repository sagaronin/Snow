public class ColumnToString {
    // Question
    /*
     * Given an integer columnNumber, return its corresponding column title as it
     * appears in an Excel sheet.
     * 
     * For example:
     * 
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 
     * 
     * Example 1:
     * 
     * Input: columnNumber = 1
     * Output: "A"
     */
    public static void main(String[] args) {
        // here 2002 corresponds to BXZ
        /*
         * N=(B+1)⋅26^2+(X+1)⋅26^1+(Z+1)∗26^0
         * N=(1+1)⋅676+(23+1)⋅26+(25+1)⋅1=2002
         */
        System.out.println("Column to string: " + convertToTitle(2002));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber = columnNumber - 1;
            ans.append((char) ((columnNumber % 26) + 'A'));
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }
}
