import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFact {
   public final String id;
   public final String text;
   public final String type;
   public final String user;
   public final int upvotes;

   public CatFact(
           @JsonProperty ("id") String id,
           @JsonProperty ("text") String text,
           @JsonProperty ("type") String type,
           @JsonProperty ("user") String user,
           @JsonProperty ("upvotes") int upvotes) {
      this.id = id;
      this.text = text;
      this.type = type;
      this.user = user;
      this.upvotes = upvotes;
   }

   @Override
   public String toString() {
      return "CatFact{" +
              "id='" + id + '\'' +
              ", text='" + text + '\'' +
              ", type='" + type + '\'' +
              ", user='" + user + '\'' +
              ", upvotes=" + upvotes +
              '}';
   }

   public String getId()   { return id;   }
   public String getText() {
      return text;
   }
   public String getType() {
      return type;
   }
   public String getUser() {
      return user;
   }
   public int getUpvotes() {
      return upvotes;
   }
}