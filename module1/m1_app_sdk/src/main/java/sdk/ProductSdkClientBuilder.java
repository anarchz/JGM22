/**

*/
package sdk;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link sdk.ProductSdk}.
 * 
 * @see sdk.ProductSdk#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class ProductSdkClientBuilder extends SdkSyncClientBuilder<ProductSdkClientBuilder, ProductSdk> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("cw09t8rmi3.execute-api.us-east-1.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "us-east-1";

    /**
     * Package private constructor - builder should be created via {@link ProductSdk#builder()}
     */
    ProductSdkClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Construct a synchronous implementation of ProductSdk using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of ProductSdk.
     */
    @Override
    protected ProductSdk build(AwsSyncClientParams params) {
        return new ProductSdkClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

}
