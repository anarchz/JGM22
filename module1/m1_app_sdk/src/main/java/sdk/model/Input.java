/**

*/
package sdk.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/cw09t8rmi3-2022-05-16T13:52:25Z/Input" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class Input implements Serializable, Cloneable, StructuredPojo {

    private String name;

    private String picUrl;

    private Double price;

    private Double productID;

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Input name(String name) {
        setName(name);
        return this;
    }

    /**
     * @param picUrl
     */

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * @return
     */

    public String getPicUrl() {
        return this.picUrl;
    }

    /**
     * @param picUrl
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Input picUrl(String picUrl) {
        setPicUrl(picUrl);
        return this;
    }

    /**
     * @param price
     */

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return
     */

    public Double getPrice() {
        return this.price;
    }

    /**
     * @param price
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Input price(Double price) {
        setPrice(price);
        return this;
    }

    /**
     * @param productID
     */

    public void setProductID(Double productID) {
        this.productID = productID;
    }

    /**
     * @return
     */

    public Double getProductID() {
        return this.productID;
    }

    /**
     * @param productID
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Input productID(Double productID) {
        setProductID(productID);
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
        if (getName() != null)
            sb.append("Name: ").append(getName()).append(",");
        if (getPicUrl() != null)
            sb.append("PicUrl: ").append(getPicUrl()).append(",");
        if (getPrice() != null)
            sb.append("Price: ").append(getPrice()).append(",");
        if (getProductID() != null)
            sb.append("ProductID: ").append(getProductID());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Input == false)
            return false;
        Input other = (Input) obj;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false)
            return false;
        if (other.getPicUrl() == null ^ this.getPicUrl() == null)
            return false;
        if (other.getPicUrl() != null && other.getPicUrl().equals(this.getPicUrl()) == false)
            return false;
        if (other.getPrice() == null ^ this.getPrice() == null)
            return false;
        if (other.getPrice() != null && other.getPrice().equals(this.getPrice()) == false)
            return false;
        if (other.getProductID() == null ^ this.getProductID() == null)
            return false;
        if (other.getProductID() != null && other.getProductID().equals(this.getProductID()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
        hashCode = prime * hashCode + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        hashCode = prime * hashCode + ((getPrice() == null) ? 0 : getPrice().hashCode());
        hashCode = prime * hashCode + ((getProductID() == null) ? 0 : getProductID().hashCode());
        return hashCode;
    }

    @Override
    public Input clone() {
        try {
            return (Input) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        sdk.model.transform.InputMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
