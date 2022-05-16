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
public class PostJGM_API_updateResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private Output output;

    /**
     * @param output
     */

    public void setOutput(Output output) {
        this.output = output;
    }

    /**
     * @return
     */

    public Output getOutput() {
        return this.output;
    }

    /**
     * @param output
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostJGM_API_updateResult output(Output output) {
        setOutput(output);
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
        if (getOutput() != null)
            sb.append("Output: ").append(getOutput());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostJGM_API_updateResult == false)
            return false;
        PostJGM_API_updateResult other = (PostJGM_API_updateResult) obj;
        if (other.getOutput() == null ^ this.getOutput() == null)
            return false;
        if (other.getOutput() != null && other.getOutput().equals(this.getOutput()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getOutput() == null) ? 0 : getOutput().hashCode());
        return hashCode;
    }

    @Override
    public PostJGM_API_updateResult clone() {
        try {
            return (PostJGM_API_updateResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
