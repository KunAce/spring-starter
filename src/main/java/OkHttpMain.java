import okhttp3.*;
import okhttp3.Callback;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OkHttpMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient",OkHttpClient.class);
        Request request = new Request.Builder()
                .get()
                .url("https://www.google.com/logos/doodles/2020/celebrating-banh-mi-6753651837108330.3-law.gif")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                FileOutputStream out = new FileOutputStream(new File("\\home\\Downloads\\test.gif"));
                int len;
                byte[] buf = new byte[1024];
                InputStream is = response.body().byteStream();
                while ((len = is.read(buf)) != -1 ) {
                    out.write(buf, 0, len);
                }
                out.close();
                is.close();
            }
        });
    }
}
