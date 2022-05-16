/**

*/
package sdk.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/cw09t8rmi3-2022-05-16T13:52:25Z/PostJGM_API_update"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostJGM_API_updateRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private Input input;

    /**
     * @param input
     */

    public void setInput(Input input) {
        this.input = input;
    }

    /**
     * @return
     */

    public Input getInput() {
        return this.input;
    }

    /**
     * @param input
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostJGM_API_updateRequest input(Input input) {
        setInput(input);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getInput() != null)
            sb.append("Input: ").append(getInput());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostJGM_API_updateRequest == false)
            return false;
        PostJGM_API_updateRequest other = (PostJGM_API_updateRequest) obj;
        if (other.getInput() == null ^ this.getInput() == null)
            return false;
        if (other.getInput() != null && other.getInput().equals(this.getInput()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getInput() == null) ? 0 : getInput().hashCode());
        return hashCode;
    }

    @Override
    public PostJGM_API_updateRequest clone() {
        return (PostJGM_API_updateRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostJGM_API_updateRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
