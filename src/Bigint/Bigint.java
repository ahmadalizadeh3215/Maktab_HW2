package Bigint;

public class Bigint {


    public static String insertZeroNumberTwo(String numberOne, String numberTwo) {
        int zerosCount = 0;
        String zero = "0";
        if (numberOne.length() != numberTwo.length()) {
            if (numberOne.length() > numberTwo.length()) {
                zerosCount = numberOne.length() - numberTwo.length();
                for (int i = 1; i <= zerosCount; i++) {
                    numberTwo = zero + numberTwo;
                }
            }
        }
        return numberTwo;
    }

    public static String insertZeroNumberOne(String numberOne, String numberTwo) {
        int zerosCount = 0;
        String zero = "0";
        if (numberOne.length() != numberTwo.length()) {
            if (numberOne.length() < numberTwo.length()) {
                zerosCount = numberTwo.length() - numberOne.length();
                for (int i = 1; i <= zerosCount; i++) {
                    numberOne = zero + numberOne;
                }
            }
        }
        return numberOne;
    }

    public static Boolean isValidInput(String numberOne, String numberTwo){
        char[] tempNumberOne = numberOne.toCharArray();
        char[] tempNumberTwo = numberTwo.toCharArray();

        for(int i = 0; i < tempNumberOne.length; i++) {
            if((tempNumberOne[i] < '0' | tempNumberOne[i] > '9')) {
                System.out.print("Invalid entries in number One : " + tempNumberOne[i]);
                return false;
            }
        }

        for(int i = 0; i < tempNumberTwo.length; i++) {
            if((tempNumberTwo[i] < '0' | tempNumberTwo[i] > '9')) {
                System.out.print("Invalid entries in number Two : "+tempNumberTwo[i]);
                return false;
            }
        }
        return true;
    }

    public String sub(String numberOne, String numberTwo) {
        if(!isValidInput(numberOne, numberTwo)){
            return "";
        }
        numberOne = insertZeroNumberOne((numberOne), (numberTwo));
        numberTwo = insertZeroNumberTwo((numberOne), (numberTwo));
        char[] tempNumberOne = numberOne.toCharArray();
        char[] tempNumberTwo = numberTwo.toCharArray();
        String ans = "";
        int carry = 0;
        for (int i = tempNumberOne.length - 1; i >= 0; i--) {
            if (((tempNumberOne[i] - '0') + (tempNumberTwo[i]) + carry) <= '9') {
                ans = (char) ((tempNumberOne[i] + '0') - (tempNumberTwo[i]) + carry) + ans;
                carry = 0;
            } else {
                ans = (char) (((tempNumberOne[i]) - '0' + (tempNumberTwo[i]) + carry) - 10) + ans;
                carry = 1;
            }
        }
        if (carry == 1)
            ans = "1" + ans;
        return ans;
    }

    public String multi(String numberOne, String numberTwo) {
        if(!isValidInput(numberOne, numberTwo)){
            return "";
        }
        numberOne = insertZeroNumberOne((numberOne), (numberTwo));
        numberTwo = insertZeroNumberTwo((numberOne), (numberTwo));
        if (numberOne.length() == 0 || numberTwo.length() == 0)
            return "0";

        int[] result = new int[numberOne.length() + numberTwo.length()];

        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = numberOne.length() - 1; i >= 0; i--) {

            int carry = 0;
            int n1 = numberOne.charAt(i) - '0';

            i_n2 = 0;

            for (int j = numberTwo.length() - 1; j >= 0; j--) {
                int n2 = numberTwo.charAt(j) - '0';
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
                carry = sum / 10;
                result[i_n1 + i_n2] = sum % 10;
                i_n2++;
            }

            if (carry > 0)
                result[i_n1 + i_n2] += carry;

            i_n1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        if (i == -1)
            return "0";

        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }

    public static String divide(String numberOne, int numberTwo) {
        if(!isValidInput(numberOne, String.valueOf(numberTwo))){
            return "";
        }
        StringBuilder result = new StringBuilder();
        char[] dividend = numberOne.toCharArray();
        int carry = 0;
        for (int i = 0; i < dividend.length; i++) {

            int x = carry * 10 + Character.getNumericValue(
                    dividend[i]);

            result.append(x / numberTwo);
            carry = x % numberTwo;
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result.substring(i);
            }
        }
        return "";
    }

    public String sum(String numberOne, String numberTwo) {
        if(!isValidInput(numberOne, numberTwo)){
            return "";
        }
        numberOne = insertZeroNumberOne((numberOne), (numberTwo));
        numberTwo = insertZeroNumberTwo((numberOne), (numberTwo));
        String result = "";
        int n1 = numberOne.length(), n2 = numberTwo.length();
        int diff = n2 - n1;
        int carry = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            int sum = ((int) (numberOne.charAt(i) - '0') +
                    (int) (numberTwo.charAt(i + diff) - '0') + carry);
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((int) (numberTwo.charAt(i) - '0') + carry);
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry > 0)
            result += (char) (carry + '0');

        return new StringBuilder(result).reverse().toString();
    }

    public Boolean compare(String numberOne, String numberTwo) {
        if(!isValidInput(numberOne, numberTwo)){
            return null;
        }
        int lengthOne = numberOne.length(), lengthTwo = numberTwo.length();

        if (lengthOne < lengthTwo)
            return true;
        if (lengthTwo < lengthOne)
            return false;

        for (int i = 0; i < lengthOne; i++) {
            if (numberOne.charAt(i) < numberTwo.charAt(i))
                return true;
            else if (numberOne.charAt(i) > numberTwo.charAt(i))
                return false;
        }
        return false;
    }
}
