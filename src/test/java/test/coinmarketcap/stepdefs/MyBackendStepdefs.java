package test.coinmarketcap.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class MyBackendStepdefs {
    private RequestSpecification request;
    private ValidatableResponse json;
    private Response response;

    private static String apiAuthKey = "X-CMC_PRO_API_KEY";
    private static String apiAuthValue = "7458a725-e9b8-4bdc-8499-22ac3a2a5f0b";
    private static  String baseURL = "https://pro-api.coinmarketcap.com/v1";
    ArrayList<Integer> ids;

    @Given("user calls {} service")
    public void userCallsCryptocurrencyMapService(String url) {
        url = baseURL + url;
        response = given().header(apiAuthKey, apiAuthValue)
                .header("Content-Type", "application/json")
                .get(url);
     }

    @When("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        json = response.then().statusCode(statusCode);

        JsonPath
                extractor = response.jsonPath();
        ArrayList<String> transId = extractor.get("data.symbol");
        ids = new ArrayList<Integer>();
        int size = transId.size();

        for (int i = 0; i < size; i++) {
            if (transId.get(i).equals("BTC")) {
                ids.add(((ArrayList<java.lang.Integer>) (extractor.get("data.id"))).get(i));
            }
            if (transId.get(i).equals("ETH")) {
                ids.add(((ArrayList<java.lang.Integer>) (extractor.get("data.id"))).get(i));
            }
            if (transId.get(i).equals("USDT")) {
                ids.add(((ArrayList<java.lang.Integer>) (extractor.get("data.id"))).get(i));
            }
        }
    }

    @Then("user convert them to Bolivian Boliviano using the {} call")
    public void userConvertThemToBolivianBolivianoUsingTheToolsPriceConversionCall(String url) {
        for(int i=0; i< ids.size();i++) {
            String urlGet = baseURL +url+"?id="+ids.get(i)+"&amount=50&convert=BOB";
            given().header(apiAuthKey, apiAuthValue)
                    .header("Content-Type", "application/json")
                    .get(urlGet)
                    .then().assertThat().body("data.quote.BOB.price", notNullValue());
        }
     }

    @Then("response includes the following")
    public void responseIncludesTheFollowing(Map<String,String> responseFields) {
        for (Map.Entry<String,String> field : responseFields.entrySet()) {
            if (!field.getValue().equals("null"))  {
                if (StringUtils.isNumeric(field.getValue())) {
                    json.body(field.getKey(),equalTo(Integer.parseInt(field.getValue())));
                }
                else
                    json.body(field.getKey(),equalTo(field.getValue()));
            }
            else {
                json.body(field.getKey(), not(notNullValue()));
            }
        }
    }

    @Given("user placed {} call by Ethereum ID {}")
    public void userCallsCryptocurrencyInfoCallByEthereumID(String url, int etheriumId) {
//        https://pro-api.coinmarketcap.com/v1/cryptocurrency/info
        url = baseURL + url + "?id=" + etheriumId;
        response = given()
                    .header(apiAuthKey, apiAuthValue)
                    .header("Content-Type", "application/json")
                    .get(url);

    }

    @When("user gets response")
    public void userGetsResponse() {
        json = response.then().statusCode(200);
    }
}
