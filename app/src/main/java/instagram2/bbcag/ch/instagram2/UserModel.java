package instagram2.bbcag.ch.instagram2;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserModel {

    public boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find() == true){
            System.out.println("true");
            return true;
        }else{
            StringBuilder errorMessage = new StringBuilder("Invalid email adress");
            System.out.println("false");
            return false;
        }
    }

    public boolean isUsernameValid(){
         return true;
    }

    public boolean isPasswordValid(){
        return true;
    }


}
