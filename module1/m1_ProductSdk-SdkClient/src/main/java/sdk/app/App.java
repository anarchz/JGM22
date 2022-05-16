package sdk.app;

import com.amazonaws.opensdk.config.ConnectionConfiguration;
import com.amazonaws.opensdk.config.TimeoutConfiguration;
import sdk.ProductSdk;
import sdk.model.Input;
import sdk.model.Output;
import sdk.model.PostJGM_API_updateRequest;
import sdk.model.PostJGM_API_updateResult;

public class App {
    private ProductSdk client;

    public App() {
        initSdk();
    }

    private void initSdk() {
        client = ProductSdk.builder()
                .connectionConfiguration(
                        new ConnectionConfiguration()
                                .maxConnections(100)
                                .connectionMaxIdleMillis(1000))
                .timeoutConfiguration(
                        new TimeoutConfiguration()
                                .httpRequestTimeout(3000)
                                .totalExecutionTimeout(10000)
                                .socketTimeout(2000))
                .build();
    }

    public void shutdown() {
        client.shutdown();
    }

    public Output updateByPostInputBody(Double id, Double price, String name, String url) {
        PostJGM_API_updateResult postResult = client.postJGM_API_update(
                new PostJGM_API_updateRequest()
                        .input(new Input()
                                .productID(id)
                                .price(price)
                                .name(name)
                                .picUrl(url)
                        ));
        return postResult.getOutput();
    }

    public static void main(String[] args) {
        System.out.println( "Update\\Upload start" );
        App app = new App();

        Output res = app.updateByPostInputBody(15.0, 120.0,"lace15", "https://militarist.ua/upload/iblock/376/37638b9edaebe47371c92d3c4b8f4aa9.jpg");
        System.out.printf("PUT /\n\n{\"productID\":15, \"price\":120,\"name\":\"lace15,\"url\":\"https://militarist.ua/upload/iblock/376/37638b9edaebe47371c92d3c4b8f4aa9.jpg\"}\n %s\n", res.getMessage());
    }
}
