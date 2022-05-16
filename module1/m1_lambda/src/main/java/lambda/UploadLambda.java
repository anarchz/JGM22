package lambda;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dto.ProductRequest;
import dto.ProductResponce;

public class UploadLambda implements RequestHandler<ProductRequest, ProductResponce> {

    private DynamoDB dynamoDB;
    private final String DYNAMODB_TABLE = "JGM_products";
    private Regions REGION = Regions.US_EAST_1;
    @Override
    public ProductResponce handleRequest(ProductRequest productRequest, Context context) {
        this.initDynamoClient();
        this.persistData(productRequest);
        ProductResponce responce = new ProductResponce();
        responce.setMessage("Upload successful");
        return responce;
    }

    private void initDynamoClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        this.dynamoDB = new DynamoDB(client);
    }

    private PutItemOutcome persistData(ProductRequest request) {
        return this.dynamoDB
                .getTable(DYNAMODB_TABLE)
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withInt("productID", request.getProductID())
                                .withInt("price", request.getPrice())
                                .withString("name", request.getName())
                                .withString("pic_url", request.getPic_url())
                        ));
    }
}
