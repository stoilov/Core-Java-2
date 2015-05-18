package downloadimg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ImageDownload {

	public static void download(String urlStr, String destination) throws ClientProtocolException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(urlStr);
	
		try (CloseableHttpResponse response = httpclient.execute(httpget);) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream;
				instream = entity.getContent();
				
				FileOutputStream out = new FileOutputStream(destination);
				int c;

	            while ((c = instream.read()) != -1) {
	                out.write(c);
	            }
	            out.close();
				instream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			download("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg",
					"/home/stoilov/downl.jpg");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
