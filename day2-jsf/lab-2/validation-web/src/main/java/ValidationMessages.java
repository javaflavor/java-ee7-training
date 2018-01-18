

import java.util.ListResourceBundle;

import com.redhat.example.constants.MessageKeys;

public class ValidationMessages extends ListResourceBundle implements MessageKeys {
	
    public Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        { CHECK_CASE,			"全ての文字は {value} でなければなりません。" },
        { FIRST_NAME_REQUIRED,	"Last Nameの入力は必須です。" },
        { LAST_NAME_REQUIRED,	"Last Nameの入力は必須です。" }
    };
}