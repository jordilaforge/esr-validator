
public class EsrValidator {

    public boolean validate(String esrNumber) {
        if (!(esrNumber.length() == 27 || esrNumber.length() == 16)) {
            return false;
        }
        String esrWithCuttedChecksum = esrNumber.substring(0, esrNumber.length() - 1);
        int checksum = calcDigit(esrWithCuttedChecksum);
        System.out.println(checksum);
        return checksum == Integer.parseInt(esrNumber.substring(esrNumber.length() - 1));
    }

    private int calcDigit(String number) {
        int[] table = {0, 9, 4, 6, 8, 2, 7, 1, 3, 5};
        int carry = 0;
        for (int i = 0; i < number.length(); i++) {
            int x = Integer.parseInt(number.substring(i, i + 1));
            int index = (carry + x) % 10;
            carry = table[index];
        }
        return (10 - carry) % 10;
    }
}
