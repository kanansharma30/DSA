// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
class Main {
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c =='(' || c == '[' || c == '{'){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if(c == ')' && top != '('){
                    return false;
                }
                if(c == '}' && top != '{'){
                    return false;
                }
                if(c == ']' && top != '['){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    
    public static void main(String[] args) {
        // System.out.println("Try clicking the Run button.");
        //invalid = "{[()]}"
        //valid
        // jese hi open bracket milegi toh stack mai push or do
        // clsoing bracket mile toh dekho stack ke top pe hai ya ni, agar match ni hua so invalid aa jaayega
        // agar stack empty hai toh bhi invalid hi aayega 
    System.out.println(isValid("{[()]}"));         
    }
}
