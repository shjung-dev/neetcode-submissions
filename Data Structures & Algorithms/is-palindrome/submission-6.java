class Solution {
    public boolean isPalindrome(String s) {
        int lp = 0;
        int rp = s.length()-1;

        while(lp < rp){
            if(!Character.isLetterOrDigit(s.charAt(lp))){
                ++lp;
            }else if(!Character.isLetterOrDigit(s.charAt(rp))){
                --rp;
            }else{
                if(Character.toLowerCase(s.charAt(lp)) != Character.toLowerCase(s.charAt(rp)))return false;
                ++lp;
                --rp;
            }
        }

        return true;
    }
}
