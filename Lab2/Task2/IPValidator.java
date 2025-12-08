import java.util.*;

public class IPValidator {


    public static String[] split(String str, String delim) {
        return str.split(delim, -1);
    }



    public static boolean isValidIPv4(String ip) {
        String[] parts = split(ip, "\\.");
        if (parts.length != 4) {
            return false; 
        }

        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3) {
            return false;
            }
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                return false;
                }
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
            return false;
            }
            if (part.startsWith("0") && part.length() > 1) {
            return false; 
            }
        }
        return true;
    }


    public static boolean isValidIPv6(String ip) {
        if (ip.isEmpty()) return false;

        String[] parts = split(ip, ":");
        boolean doubleColonUsed = ip.contains("::");
        if (doubleColonUsed && ip.indexOf("::") != ip.lastIndexOf("::")) {
        return false; 
        }

        if (!doubleColonUsed && parts.length != 8) {
        return false; 
        }
        if (doubleColonUsed && parts.length > 8) 
        {
            return false; 
        }

        for (String part : parts) {
            if (part.isEmpty()) {
            continue; 
            }
            if (part.length() > 4 || part.length() < 1) {
            return false; 
            }
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) && !((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String ip = sc.nextLine().trim();

        if (isValidIPv4(ip)) {
            System.out.println("Valid IPv4 address");
            System.out.println("Octets: " + Arrays.toString(split(ip, "\\.")));
        } else if (isValidIPv6(ip)) {
            System.out.println("Valid IPv6 address");
            System.out.println("Groups: " + Arrays.toString(split(ip, ":")));
        } else {
            System.out.println("Invalid IP address");
        }
        sc.close();
    }
}

