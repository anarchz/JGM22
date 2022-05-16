/**

*/
package sdk.model.transform;

import javax.annotation.Generated;

import sdk.model.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * PostJGM_API_updateResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostJGM_API_updateResultJsonUnmarshaller implements Unmarshaller<PostJGM_API_updateResult, JsonUnmarshallerContext> {

    public PostJGM_API_updateResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostJGM_API_updateResult postJGM_API_updateResult = new PostJGM_API_updateResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postJGM_API_updateResult;
        }

        while (true) {
            if (token == null)
                break;

            postJGM_API_updateResult.setOutput(OutputJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postJGM_API_updateResult;
    }

    private static PostJGM_API_updateResultJsonUnmarshaller instance;

    public static PostJGM_API_updateResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostJGM_API_updateResultJsonUnmarshaller();
        return instance;
    }
}
