package instagram2.bbcag.ch.instagram2.User;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import instagram2.bbcag.ch.instagram2.R;


public class ValidateUserSignUp {

    public boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("([a-z0-9][-a-z0-9_\\+\\.]*[a-z0-9])@([a-z0-9][-a-z0-9\\.]*[a-z0-9]\\.(arpa|root|aero|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw)|([0-9]{1,3}\\.{3}[0-9]{1,3}))");
        Matcher matcher = pattern.matcher(email);
        if(!matcher.find()&& email.length() == 0){
            return false;
        }
        return true;
    }

    public boolean isUsernameValid(String username){
        Pattern pattern = Pattern.compile("/^[a-z0-9]{3,10}$/");
        Matcher matcher = pattern.matcher(username);
        if(!matcher.find()&& username.length() == 0){
            return false;
        }
        return true;
    }

    public boolean isPasswordValid(String password){
        Pattern pattern = Pattern.compile("\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find() && password.length() == 0){
            return false;
        }
        return true;
    }

    public boolean isOnlyText(String text){
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);
        if(!matcher.find() && text.length() == 0){
            return false;
        }
        return true;
    }

    public String getTextOfInputTextField(Activity activity, Integer id){
        EditText editText = (EditText) activity.findViewById(id);
        String text = editText.getText().toString();
        return text;
    }
}
