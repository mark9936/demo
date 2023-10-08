package com.demo.model.store.pk;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderPK implements Serializable {

    private String pNo;

    private String mId;

    private LocalDateTime cartTime;
}
