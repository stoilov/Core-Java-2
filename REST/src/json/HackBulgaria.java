package json;

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
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class HackBulgaria {

	public static String download(String urlStr) throws ClientProtocolException {
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

	public static JSONObject[] parseJSONArray(String jsonBody)
			throws JSONException {
		JSONArray contents = new JSONArray(jsonBody);
		JSONObject[] objects = new JSONObject[contents.length()];
		for (int i = 0; i < contents.length(); i++) {
			objects[i] = contents.getJSONObject(i);
		}

		return objects;
	}

	public static void main(String[] args) {
		String json = "";
		JSONObject[] jsonarr = null;
		try {
			json = download("https://hackbulgaria.com/api/students/");
			jsonarr = parseJSONArray(json);
			for (JSONObject jsonObject : jsonarr) {
				jsonarr = parseJSONArray(json);
				if (parseJSONArray(jsonObject.get("courses").toString()).length > 1) {
					System.out.println(jsonObject.get("name"));
				}
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
