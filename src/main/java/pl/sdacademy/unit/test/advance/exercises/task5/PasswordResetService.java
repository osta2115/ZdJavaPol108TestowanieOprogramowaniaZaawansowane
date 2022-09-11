package pl.sdacademy.unit.test.advance.exercises.task5;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Random;

public class PasswordResetService {

    private static final String BODT_TEMPLATE =
            "Twoje tymczasowe hasło wygenerowane dnia REPLACE_DATE o godzinie REPLACE_TIME to REPLACE_NEW_PASSWORD";

    private DateTimeProvider dateTimeProvider;
    private RandomPasswordProvider randomPasswordProvider;

    public PasswordResetService(DateTimeProvider dateTimeProvider, RandomPasswordProvider randomPasswordProvider) {
        this.dateTimeProvider = dateTimeProvider;
        this.randomPasswordProvider = randomPasswordProvider;
    }

    public String generateEmailBody() {
//        var now = LocalDateTime.now();
//        var stringBuilder = new StringBuilder();
//        String password = RandomPasswordProvider.generateRandomPassword(10);
//        return stringBuilder.append("Twoje tymczasowe hasło wygenerowane dnia ")
//                .append(now.getYear())
//                .append(now.getMonth())
//                .append(now.getDayOfMonth())
//                .append(" o godzinie ")
//                .append(now.getHour())
//                .append(now.getMinute())
//                .append(now.getSecond())
//                .append(" to ")
//                .append(password)
//                .toString();

        LocalDateTime currentDateTime = dateTimeProvider.getCurrentDateTime();
        String newPassword = randomPasswordProvider.generateRandomPassword();
        return BODT_TEMPLATE
                .replace("REPLACE_DATE", currentDateTime.toLocalDate().toString())
                .replace("REPLACE_TIME", currentDateTime.toLocalTime().toString())
                .replace("REPLACE_NEW_PASSWORD", newPassword);
    }
}


