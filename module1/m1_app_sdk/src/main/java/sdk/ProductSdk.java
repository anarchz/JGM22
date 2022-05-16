/**

*/
package sdk;

import javax.annotation.Generated;

import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;

import sdk.model.*;

/**
 * Interface for accessing ProductSdk.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface ProductSdk {

    /**
     * @param postJGM_API_updateRequest
     * @return Result of the PostJGM_API_update operation returned by the service.
     * @sample ProductSdk.PostJGM_API_update
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/cw09t8rmi3-2022-05-16T13:52:25Z/PostJGM_API_update"
     *      target="_top">AWS API Documentation</a>
     */
    PostJGM_API_updateResult postJGM_API_update(PostJGM_API_updateRequest postJGM_API_updateRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static ProductSdkClientBuilder builder() {
        return new ProductSdkClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
