import java.util.HashSet;

/**
 * Created by DrDan on 1/22/2017.
 */
public class IsSubsequence {
    public void test() {
        System.out.println(isSubsequence("abc","adebee"));
        SubsequenceFinder ssf = new SubsequenceFinder(new String[]{"a","b","c","ac","ab","bc","abc","","x","ax"}, "abc");
    }

    public boolean isSubsequence(String s, String t) {
        int p = 0;
        for (int i=0; i<t.length()&&p<s.length(); i++)
            if (s.charAt(p) == t.charAt(i))
                p++;
        return p == s.length();
    }

    public class SubsequenceFinder {

        public SubsequenceFinder(String[] in, String t){
            getAllSubsequences(t);
            for (String s : in){
                System.out.println("result: " + isSubsequence(s));
            }
        }

        HashSet<String> hs = new HashSet<>();
        public boolean isSubsequence(String s){
            return hs.contains(s);
        }

        public void getAllSubsequences(String t){
            if (hs.contains(t))
                return;
            else
                hs.add(t);
            for (int i=0; i<t.length(); i++){
                getAllSubsequences(t.substring(0, i) + t.substring(i+1));
            }
        }
    }

}
