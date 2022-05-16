/**

*/
package sdk.model.transform;

import javax.annotation.Generated;

import sdk.model.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * Output JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class OutputJsonUnmarshaller implements Unmarshaller<Output, JsonUnmarshallerContext> {

    public Output unmarshall(JsonUnmarshallerContext context) throws Exception {
        Output output = new Output();

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
                if (context.testExpression("message", targetDepth)) {
                    context.nextToken();
                    output.setMessage(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return output;
    }

    private static OutputJsonUnmarshaller instance;

    public static OutputJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new OutputJsonUnmarshaller();
        return instance;
    }
}
