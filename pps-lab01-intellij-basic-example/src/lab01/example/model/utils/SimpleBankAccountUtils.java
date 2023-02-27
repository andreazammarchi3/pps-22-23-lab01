package lab01.example.model.utils;

public class SimpleBankAccountUtils {
    public static boolean isWithdrawAllowed(final double balance, final double amount, final int fee){
        return balance - fee >= amount;
    }

    public static boolean checkUser(final int userId, final int checkId) {
        return userId == checkId;
    }
}
