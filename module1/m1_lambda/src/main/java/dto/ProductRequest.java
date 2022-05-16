package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private int productID;
    private String name;
    private String pic_url;
    private int price;
}
