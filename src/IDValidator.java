public class IDValidator {
    // My own code
    public static void main(String[] args) {
        while (true) { // Infinite loop
            System.out.print("\nEnter a South African ID number (Enter 0 to exit): ");
            String input = System.console().readLine(); // Get user input512

            Boolean luhn;
            if (input.length() == 13 && !input.matches(".*[a-zA-Z].*")) { // if-else block to make sure the id number
                                                                          // supplied is 13 digits
                luhn = isValidLuhn(input);
            } else if (input.equals("0")) { // Exit program if 0 is detected
                break;
            } else {
                System.out.print("No ID number detected.\n");
                continue;
            }

            String validate;
            if (luhn) { // if-else block to make the output of the luhn variable more understandable
                validate = "ID number " + input + " is valid.";
            } else {
                validate = "ID number " + input + " is invalid.";
            }

            System.out.print(validate + "\n "); // Print variable validate
        }
    }

    // Copied (https://en.wikipedia.org/wiki/Luhn_algorithm)
    public static boolean isValidLuhn(String number) {
        int checksum = Character.getNumericValue(number.charAt(number.length() - 1));
        int total = 0;

        for (int i = number.length() - 2; i >= 0; i--) {
            int sum = 0;
            int digit = Character.getNumericValue(number.charAt(i));
            if (i % 2 == number.length() % 2) { // right to left every odd digit
                digit = digit * 2;
            }

            sum = digit / 10 + digit % 10;
            total += sum;
        }

        return total % 10 != 0 ? 10 - total % 10 == checksum : checksum == 0;
    }
}