/**

*/
package sdk.model.transform;

import javax.annotation.Generated;

import sdk.model.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * Input JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class InputJsonUnmarshaller implements Unmarshaller<Input, JsonUnmarshallerContext> {

    public Input unmarshall(JsonUnmarshallerContext context) throws Exception {
        Input input = new Input();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("name", targetDepth)) {
                    context.nextToken();
                    input.setName(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("pic_url", targetDepth)) {
                    context.nextToken();
                    input.setPicUrl(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("price", targetDepth)) {
                    context.nextToken();
                    input.setPrice(context.getUnmarshaller(Double.class).unmarshall(context));
                }
                if (context.testExpression("productID", targetDepth)) {
                    context.nextToken();
                    input.setProductID(context.getUnmarshaller(Double.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return input;
    }

    private static InputJsonUnmarshaller instance;

    public static InputJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new InputJsonUnmarshaller();
        return instance;
    }
}
