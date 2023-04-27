import java.math.BigInteger;

class IBANValidator {                                                           //Backend
    public boolean isValid(String iban) {
        // Entferne Leerzeichen aus der IBAN
        iban = iban.replace(" ", "");

        // Überprüfe die Länge der IBAN
        if (iban.length() < 15 || iban.length() > 34) {
            return false;
        }

        // Verschiebe die ersten vier Zeichen ans Ende der IBAN
        iban = iban.substring(4) + iban.substring(0, 4);

        // Ersetze Buchstaben durch Zahlen gemäß der Vorschrift
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            char c = iban.charAt(i);
            if (Character.isLetter(c)) {
                sb.append((int) c - 55);
            } else {
                sb.append(c);
            }
        }
        iban = sb.toString();

        // Berechne die Prüfsumme der IBAN
        BigInteger ibanNumber = new BigInteger(iban);
        BigInteger remainder = ibanNumber.mod(new BigInteger("97"));

        // Überprüfe, ob die Prüfsumme 1 ist
        return remainder.intValue() == 1;
    }
}