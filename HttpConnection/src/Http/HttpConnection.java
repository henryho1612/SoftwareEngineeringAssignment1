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
            //Establish a connection to send a post request
            conn = new DefaultHttpClient();
            //Make it into a post request
            post = new HttpPost(urlString);
            
            //Type of accepting file. Actually it has not been used correctly
            post.addHeader("Accept", "text/xml");
            //Add in the parameter - content from the json file
            postParameters = new ArrayList<>();
            postParameters.add(new BasicNameValuePair("Data", data.toString()));
            //put it in the entity of the post request
            post.setEntity(new UrlEncodedFormEntity(postParameters));

            //Execute the post request.
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = conn.execute(post, responseHandler);
            
            //Received back all the content of the website and the parameter for display purpose
            //Use for checking
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
