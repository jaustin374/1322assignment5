public class DNALib {
    public static int count = 0;
    public static boolean validator(String dna) {
        count++;
        if (dna.equals("")) {
            return false;
        }
        else if (dna.length() == 1 && (dna.charAt(0) == 'A' || dna.charAt(0) == 'C' || dna.charAt(0) == 'G' || dna.charAt(0) == 'T')) {
            if (count % 3 == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (dna.charAt(0) == 'A' || dna.charAt(0) == 'C' || dna.charAt(0) == 'G' || dna.charAt(0) == 'T') {
                return validator(dna.substring(1));
            }
        }
        return false;
    }

    public static String reverser(String dna) {
        if (dna.length() == 1) {
            return dna;
        }
        else {
            char charAtEnd = dna.charAt(dna.length()-1);
            String minusOne = dna.substring(0, dna.length()-1);
            return charAtEnd + reverser(minusOne);
        }
    }

    public static String inverser(String dna) {
        char toReplace = dna.charAt(0);
        if (dna.length() == 1) {
            if (toReplace == 'A') {
                return "T";
            }
            else if (toReplace == 'C') {
                return "G";
            }
            else if (toReplace == 'G') {
                return "C";
            }
            else {
                return "A";
            }
        }
        else {
            if (toReplace =='A') {
                String replacement = "T";
                return replacement + inverser(dna.substring(1, dna.length()));
            }
            else if (toReplace =='C') {
                String replacement = "G";
                return replacement + inverser(dna.substring(1, dna.length()));
            }
            else if (toReplace == 'G') {
                String replacement = "C";
                return replacement + inverser(dna.substring(1, dna.length()));
            }
            else {
                String replacement = "A";
                return replacement + inverser(dna.substring(1, dna.length()));
            }
        }
    }

    public static String translator(String dna) {
        String aminoacid = "";
        String sequence = "";
        if (dna.equals("")) {
            return "";
        }
        else {
            sequence = dna.substring(0,3);
        }
        switch (sequence) {
            case "GCA", "GCC", "GCG", "GCT" -> aminoacid = "A";
            case "TGC", "TGT" -> aminoacid = "C";
            case "GAC", "GAT" -> aminoacid = "D";
            case "GAA", "GAG" -> aminoacid = "E";
            case "TTC", "TTT" -> aminoacid = "F";
            case "GGA", "GGC", "GGG", "GGT" -> aminoacid = "G";
            case "CAC", "CAT" -> aminoacid = "H";
            case "ATA", "ATC", "ATT" -> aminoacid = "I";
            case "AAA", "AAG" -> aminoacid = "K";
            case "CTA", "CTC", "CTG", "CTT", "TTA", "TTG" -> aminoacid = "L";
            case "ATG" -> aminoacid = "M";
            case "AAT", "AAC" -> aminoacid = "N";
            case "CCA", "CCC", "CCG", "CCT" -> aminoacid = "P";
            case "CAA", "CAG" -> aminoacid = "Q";
            case "AGA", "AGG", "CGA", "CGC", "CGG", "CGT" -> aminoacid = "R";
            case "AGC", "AGT", "TCA", "TCC", "TCG", "TCT" -> aminoacid = "S";
            case "ACA", "ACC", "ACG", "ACT" -> aminoacid = "T";
            case "GTA", "GTC", "GTG", "GTT" -> aminoacid = "V";
            case "TGG" -> aminoacid = "W";
            case "TAC", "TAT" -> aminoacid = "Y";
            case "TAA", "TAG", "TGA" -> aminoacid = "-";
        }
        return aminoacid + translator(dna.substring(3));
    }
}
