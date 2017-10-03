@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.3')

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.client.methods.HttpGet;

def httpclient = new DefaultHttpClient();

def responseHandler = new BasicResponseHandler();

httpclient.getCredentialsProvider().setCredentials(
        new AuthScope("localhost", 8100),
        new UsernamePasswordCredentials("spring_security", "digest"));

def httpget = new HttpGet("http://localhost:8100/JerseyRestExample/rest/api/hi/Yuci");
System.out.println("executing request" + httpget.getRequestLine());

def response = httpclient.execute(httpget, responseHandler);
System.out.println("Response :: " + response);