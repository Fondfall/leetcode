public class BackspaceCompare_844 {
    public static boolean backspaceCompare(String s, String t) {
        int slow = 0;
        char[] sChar = new char[s.length()];
        for(int fast = 0; fast < s.length(); fast++){
            if(s.charAt(fast) == '#'){
                if(slow != 0){
                    slow--;
                }
            }else{
                sChar[slow++] = s.charAt(fast);
            }
        }
        s = new String(sChar,0,slow);
        slow = 0;
        char[] tChar = new char[t.length()];
        for(int fast = 0; fast < t.length(); fast++){
            if(t.charAt(fast) == '#'){
                if(slow != 0){
                    slow--;
                }
            }else{
                tChar[slow++] = t.charAt(fast);
            }
        }
        t = new String(tChar,0,slow);
        return s.equals(t);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("cd##","c#d#"));
    }
}
