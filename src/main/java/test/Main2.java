package test;

public class Main2 {

    public static void main(String[] args){
//        String word = "hackerrekcahba";
        String word = "abcdesannasq";

        int startingIndex = -1;
        int endIndex = 0;

        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);

            //letter repeated
            if(word.indexOf(c) < word.lastIndexOf(c)){
                //
                if(startingIndex == -1)
                    startingIndex = i;
                endIndex = i;
            }
            else{

            }
        }

        System.out.println(word.substring(startingIndex, endIndex-1));
    }
}
