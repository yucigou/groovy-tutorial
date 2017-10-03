@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.3')

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(
        new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
        new UsernamePasswordCredentials("postman", "password"));

CloseableHttpClient httpClient = HttpClients.custom()
        .setDefaultCredentialsProvider(credsProvider)
        .build();

HttpGet httpGet = new HttpGet("https://postman-echo.com/digest-auth");
HttpResponse httpResponse = httpClient.execute(httpGet);
String content = EntityUtils.toString(httpResponse.getEntity());
println content;