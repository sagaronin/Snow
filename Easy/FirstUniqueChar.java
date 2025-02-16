public class FirstUniqueChar {
    public static void main(String[] args) {
        String str="leetcodeltco";
        int i = findUnique(str);
        System.out.println("Unique char is: "+str.charAt(i));
    }

    public static int findUnique(String str){
        int frequency[] = new int[26];
        for (char ch : str.toCharArray()) {
            frequency[ch-'a']++;
        }
        for (char ch:str.toCharArray()) {
            if (frequency[ch-'a']==1) {
                return str.indexOf(ch);
            }
        }
        return -1;
    }
}
