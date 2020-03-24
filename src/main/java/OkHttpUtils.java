import okhttp3.OkHttpClient;

// static factory
public class OkHttpUtils {
    private static OkHttpClient OkHttpClient;
    public static OkHttpClient getInstance() {
        if (OkHttpClient == null) {
            OkHttpClient = new OkHttpClient.Builder().build();
        }
        return OkHttpClient;
    }
}

// instance factory
//public class OkHttpUtils {
//    private OkHttpClient OkHttpClient;
//    public OkHttpClient getInstance() {
//        if (OkHttpClient == null) {
//            OkHttpClient = new OkHttpClient.Builder().build();
//        }
//        return OkHttpClient;
//    }
//}