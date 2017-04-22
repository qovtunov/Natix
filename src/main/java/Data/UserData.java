package Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData extends ConfigProperties {

    DateFormat dateFormat = new SimpleDateFormat("MMddHHmm");
    Date date = new Date();

    public String uniqueAccount = ConfigProperties.getProperty("user") + dateFormat.format(date); //generate unique username
}
