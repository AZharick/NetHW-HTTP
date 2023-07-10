package NASARequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NASA {
   public final String copyright;
   public final String date;
   public final String explanation;
   public final String hdurl;
   public final String media_type;
   public final String service_version;
   public final String title;
   public final String url;

   public NASA(
           @JsonProperty ("copyright") String copyright,
           @JsonProperty ("date") String date,
           @JsonProperty ("explanation") String explanation,
           @JsonProperty ("hdurl") String hdurl,
           @JsonProperty ("media_type") String media_type,
           @JsonProperty ("service_version") String service_version,
           @JsonProperty ("title") String title,
           @JsonProperty ("url") String url) {
      this.copyright = copyright;
      this.date = date;
      this.explanation = explanation;
      this.hdurl = hdurl;
      this.media_type = media_type;
      this.service_version = service_version;
      this.title = title;
      this.url = url;
   }

   public String getUrl() {
      return url;
   }

   @Override
   public String toString() {
      return "NASA{" +
              "copyright='" + copyright + '\'' +
              ", date='" + date + '\'' +
              ", explanation='" + explanation + '\'' +
              ", hdurl='" + hdurl + '\'' +
              ", media_type='" + media_type + '\'' +
              ", service_version='" + service_version + '\'' +
              ", title='" + title + '\'' +
              ", url='" + url + '\'' +
              '}';
   }
}