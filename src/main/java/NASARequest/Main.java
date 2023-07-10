package NASARequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
   public static final String address = "https://api.nasa.gov/planetary/apod?api_key=gGnjdUjiJkXZ1tmB5ff39x17ipr12BwpHae71VVc";
   public static ObjectMapper mapper = new ObjectMapper();

   public static void main(String[] args) throws IOException {
      CloseableHttpClient httpClient = HttpClientBuilder.create()
              .setDefaultRequestConfig(RequestConfig.custom()
                      .setConnectTimeout(5000)
                      .setSocketTimeout(30000)
                      .setRedirectsEnabled(false)
                      .build())
              .build();

      HttpGet request = new HttpGet(address);
      CloseableHttpResponse response = httpClient.execute(request);

      NASA nasaInfo = mapper.readValue(response.getEntity().getContent(), NASA.class);
      String pictureName = getFileNameFromURL(nasaInfo.getUrl());

      HttpGet requestForPicture = new HttpGet(nasaInfo.getUrl());
      CloseableHttpResponse responsePicture = httpClient.execute(requestForPicture);
      byte[] picBytes = responsePicture.getEntity().getContent().readAllBytes(); //todo
      try(FileOutputStream fos = new FileOutputStream(pictureName)){
         fos.write(picBytes);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String getFileNameFromURL(String url) {
      int slashIndex = url.lastIndexOf('/');
      return url.substring(slashIndex+1);
   }
}