package kwaksuin.portfolio.community.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://kwaksi98.dothome.co.kr/Register.php";
    private Map<String,String> map;

    public RegisterRequest(String userEmail, String userPassword, String userName, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("userEmail",userEmail);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
