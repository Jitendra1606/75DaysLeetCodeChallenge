class Solution {
    public String decodeString(String s) {
        int n = s.length();

        char[] arr = s.toCharArray(); //converting given string to character array for ease
        String temp = ""; // to store our answer
        int num = 0; 

        Stack<Integer> st = new Stack<>(); // stack to keep track of integers in given string
        Stack<String> si = new Stack<>(); // stack to keep track of strings in given string(3[abc])

        for(int i = 0 ; i < arr.length ; i++){
            char ch = arr[i]; 

            if(Character.isDigit(ch)){       // if it is a number (3[abc])
                num = num * 10 + (ch - '0'); // number can be large as it is positive integer
            }
            else if(ch == '['){

                st.push(num); //start pushing integer in the integer stack
                si.push(temp); // push the entire string till noe in the stack(a3[])

                num = 0; // no reinitialise the num
                temp = ""; // and also our answer string to be reinitialized
            }
            else if(ch == ']'){
                int k = st.pop(); // pop out the integer which is in the integer stack(a3[abc])

                String prev = si.pop(); //also pop out the string till now (a3[abc]) = abc will pop
                StringBuilder sb = new StringBuilder(prev);

                for(int j = 0 ; j < k ; j++){ //loop will run k times
                    sb.append(temp); //store this in our answer
                }
                temp = sb.toString();
            }else{
                temp += ch;
            }
        }
        return temp;
    }
}