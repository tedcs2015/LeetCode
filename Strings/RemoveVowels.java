package stringAndArrays;

public class RemoveVowels {
    public String removeVowels(String S) {
    	 if(S == null || S.isEmpty())
         	return S;
         
    	 StringBuilder sb = new StringBuilder();
    	 for(int i = 0; i < S.length(); i++) {
    		 char c = S.charAt(i);
    		 if(!isVowel(c)) {
    			 sb.append(c);
    		 }
    	 }
         
         return sb.toString();
     }
 	
 	private boolean isVowel(char c) {
 		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
 	}
}
