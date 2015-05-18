package beautifier;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ParseJSON {
	
	private static String download(String urlStr) throws ClientProtocolException {
		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(urlStr);

		try (CloseableHttpResponse response = httpclient.execute(httpget);) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();

				StringWriter writer = new StringWriter();
				Charset charset = Charset.forName("UTF-8");
				IOUtils.copy(instream, writer, charset);

				result = writer.toString();

				instream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	private String getBeautiful(String ugly) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(ugly);
		String beautiful = gson.toJson(je);
		return beautiful;
	}
	
	public String beutifyViaUrl(String url) throws ClientProtocolException {
		return getBeautiful(download(url));
	}
	
}
