import java.util.LinkedList;

/**
 * Created by DrDan on 1/14/2017.
 */
public class SimplifyUnixPath {

    public void test() {
        System.out.println(simplifyPath("/a/./b/../../c/d/e/f/"));
    }

    public String simplifyPath(String p){
        String[] commands = p.split("/");
        LinkedList<String> st = new LinkedList<>();
        for (String s : commands){
            if ( s.equals("..") && !st.isEmpty()){
                st.pop();
            }
            else if ( !s.equals(".") && !s.equals("") && !s.equals("..") )
                st.push(s);
        }
        StringBuilder path = new StringBuilder();
        while (!st.isEmpty()){
            path.append("/");
            path.append(st.removeLast());
        }
        return path.toString().equals("") ? "/" : path.toString();
    }
}
