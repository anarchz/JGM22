/**

*/
package sdk.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import sdk.model.*;

import com.amazonaws.annotation.SdkInternalApi;

/**
 * InputMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class InputMarshaller {

    private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("name").build();
    private static final MarshallingInfo<String> PICURL_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("pic_url").build();
    private static final MarshallingInfo<Double> PRICE_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("price").build();
    private static final MarshallingInfo<Double> PRODUCTID_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("productID").build();

    private static final InputMarshaller instance = new InputMarshaller();

    public static InputMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(Input input, ProtocolMarshaller protocolMarshaller) {

        if (input == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(input.getName(), NAME_BINDING);
            protocolMarshaller.marshall(input.getPicUrl(), PICURL_BINDING);
            protocolMarshaller.marshall(input.getPrice(), PRICE_BINDING);
            protocolMarshaller.marshall(input.getProductID(), PRODUCTID_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
