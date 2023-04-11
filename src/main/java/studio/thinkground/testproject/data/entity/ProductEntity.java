package studio.thinkground.testproject.data.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //해당 클래스가 Entity임을 알려줌
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product") //Entity를 기반으로 DB에 자동으로 테이블 생성(name=테이블이름)
public class ProductEntity {

    @Id //테이블의 pk와 매칭
    String productId;

    String productName;

    Integer productPrice;

    Integer productStock;
}
