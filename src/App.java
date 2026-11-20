import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class App {
        public static void main(String[] args) throws IOException, InterruptedException {
                    String mathTriviaUrl = "https://opentdb.com/api.php?amount=8&category=19&type=multiple";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(mathTriviaUrl)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Trivia data recieved: " + response.body());
            } else {
                System.out.println("Data not received: " + response.statusCode());
            }
            JSONObject json = new JSONObject(response.body());
            int responseCode = json.getInt("response_code");
            
            
            System.out.println("Hello and Welcome To Math Trivia!!");
            System.out.println("This quiz has 8 question. If you get one wrong, you get another chance!");
            //ask for username
            System.out.println("To begin, what is your username?\n");
            Scanner input = new Scanner(System.in);
            System.out.println("Hello, :" + input);
            
            //Begin Quiz
            JSONArray results = json.getJSONArray("results"); 
            JSONObject first = results.getJSONObject(0);
            
            System.out.println("First Question, Difficulty:");


    }
}
