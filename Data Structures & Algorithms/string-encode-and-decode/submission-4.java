class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        String encoded = sb.toString();
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0 ; i < str.length() ; ++i){
            char c = str.charAt(i);
            if(c != '#'){
                sb1.append(c);
            }else{
                //Reached the delimiter
                StringBuilder sb2 = new StringBuilder();
                int wordLength = Integer.parseInt(sb1.toString());
                for(int j = i + 1 ; j < i + wordLength + 1 ; ++j){
                    sb2.append(str.charAt(j));
                }
                decoded.add(sb2.toString());
                sb1.setLength(0);
                sb2.setLength(0);

                //Move the index of i after the position of word
                i += wordLength;
            }
        }

        return decoded;
    }
}
