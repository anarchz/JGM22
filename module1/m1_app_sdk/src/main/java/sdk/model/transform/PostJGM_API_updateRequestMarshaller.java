/**

*/
package sdk.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import sdk.model.*;

import com.amazonaws.annotation.SdkInternalApi;

/**
 * PostJGM_API_updateRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostJGM_API_updateRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> INPUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostJGM_API_updateRequestMarshaller instance = new PostJGM_API_updateRequestMarshaller();

    public static PostJGM_API_updateRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostJGM_API_updateRequest postJGM_API_updateRequest, ProtocolMarshaller protocolMarshaller) {

        if (postJGM_API_updateRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postJGM_API_updateRequest.getInput(), INPUT_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
