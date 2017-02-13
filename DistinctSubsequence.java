import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by DrDan on 1/19/2017.
 */
public class DistinctSubsequence {

    public void test(){
        System.out.println(numDistinct("aaabbaaaabbbaaaaba", "abba"));
    }

    public int numDistinct(String s, String t){
        if (s.equals(t)) return 1;
        if (s.length()<t.length()) return 0;

        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();
        for (int i=0; i<t.length(); i++){
            hs.add(t.charAt(i));
        }
        for (int i=0; i<s.length(); i++){
            if (hs.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String sm = sb.toString();

        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> dp = new HashSet<>();
        String d = "";
        for (int i=0; i<sm.length(); i++)
            d += (char)(i+33);
        numDistinctRecursive(sm,d,t,hm,dp);
        return hm.containsKey(t) ? hm.get(t) : 0;
    }

    public void numDistinctRecursive(String s, String d, String t, HashMap<Integer, Integer> hm, HashSet<Integer> dp){
        if (d.length() < t.length() || dp.contains(d.hashCode())) return;
        dp.add(d.hashCode());
        if (d.length() == t.length()) {
            StringBuilder st = new StringBuilder();
            for (int i=0; i<d.length(); i++){
                int x = d.charAt(i) - '!';
                st.append(s.charAt(x));
            }
            String s2 = st.toString();
            if (hm.containsKey(s2))
                hm.put(s2.hashCode(), hm.get(s2)+1);
            else hm.put(s2.hashCode(), 1);
        }
        for (int i=0; i<d.length(); i++){
            numDistinctRecursive(s, d.substring(0,i)+d.substring(i+1,d.length()), t, hm, dp);
        }
    }

}
