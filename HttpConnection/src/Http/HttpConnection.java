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

            // <editor-fold defaultstate="collapsed" desc=" ${Testing Code} ">
//            StringEntity entity = new StringEntity(
//                    "<DocSearch><searchString>*.pdf</searchString>"
//                    + "<userName>Sudhakar KV</userName></DocSearch>",
//                    "text/xml", "ISO-8859-1");
//            post.addHeader("Accept", "text/xml");
//            post.setEntity(entity);
//            post.addHeader("Content-Type", "text/xml");
            //post.setEntity(new StringEntity(data));
            //HttpResponse response = conn.execute(post);
//            StringEntity entity = new StringEntity(
//                    "<DocSearch><searchString>*.pdf</searchString>"
//                    + "<userName>Sudhakar KV</userName></DocSearch>",
//                    "text/xml", "ISO-8859-1");
//            post.addHeader("Accept", "text/xml");
//            post.setEntity(entity);
            
            //StatusLine status = response.getStatusLine();
            //System.out.println(status.getStatusCode());
            //System.out.println("\nSending 'POST' request to URL : " + url.toString());
            //System.out.println("Post parameters : " + urlParameters);
            //HttpEntity entity = response.getEntity();
            //BufferedReader in = new BufferedReader(
                    //new InputStreamReader(entity.getContent()));
            //String inputLine;
            //StringBuffer responses = new StringBuffer();

            //while ((inputLine = in.readLine()) != null) {
                //responses.append(inputLine);
            //}
            //in.close();
            //print result
            //System.out.println(responses.toString());
            //httpPost.addHeader( "Authorization", bs.getValue() );
            //httpPost.addHeader( "Content-Type", "application/xml" );
            //httpPost.addHeader( "Accept", "application/xml" );

            //httpPost.setEntity( new StringEntity( xmlReport.toString() ) );
            //HttpResponse response = httpclient.execute( targetHost, httpPost, localcontext );
            //HttpEntity entity = response.getEntity();
            // </editor-fold>
            
        } catch (MalformedURLException ioe) {
            System.out.println("Invalid");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            post.releaseConnection();
        }
        
        // <editor-fold defaultstate="collapsed" desc=" ${Another way of open a connection} ">
//        String servlet = url.toString();
//        String query = "act=1&id=350";
//        java.net.URL urli = new java.net.URL(servlet);
//        HttpURLConnection conn = (HttpURLConnection) urli.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setDoOutput(true);
//        conn.setRequestProperty("Content-Length", "sdfsdf");
////        conn.getOutputStream().write(query.getBytes(charEncoding));
//        conn.connect();
//        conn.disconnect();
        // </editor-fold>
    }

    public void receivedPostRequest() {

    }
}
