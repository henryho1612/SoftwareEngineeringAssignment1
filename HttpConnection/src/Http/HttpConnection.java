package Http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author HenryHo
 */
public class HttpConnection {

    HttpClient conn;
    HttpPost post;
    ArrayList<NameValuePair> postParameters;
    String data, urlString;
    
    public HttpConnection(String data, String urlString) {
        this.data = data;
        this.urlString = urlString;
    }

    public void sendPostRequest() {

        try {
            //Testing
            //URL url = new URL(urlString);
            //System.out.println(url.getHost());

            //Establish a connection to send a post request
            conn = new DefaultHttpClient();
            post = new HttpPost(urlString);
            //Use for Testing
            //System.out.println(post.getURI());

            //Adding value to a parameter
            post.addHeader("Accept", "text/xml");
            postParameters = new ArrayList<>();
            postParameters.add(new BasicNameValuePair("Data", data.toString()));
            post.setEntity(new UrlEncodedFormEntity(postParameters));

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = conn.execute(post, responseHandler);
            
            System.out.println("responseBody : " + responseBody);

        } catch (MalformedURLException ioe) {
            System.out.println("Invalid");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            post.releaseConnection();
        }
        
    }
}
